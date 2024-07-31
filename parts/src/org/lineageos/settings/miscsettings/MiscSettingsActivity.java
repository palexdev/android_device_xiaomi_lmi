package org.lineageos.settings.miscsettings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import androidx.fragment.app.Fragment;

import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity;
import com.android.settingslib.collapsingtoolbar.R;

public class MiscSettingsActivity extends CollapsingToolbarBaseActivity {

    protected static final String TAG_MISC_SETTINGS = "MiscSettings";
    private Intent starterIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        starterIntent = getIntent();
        if (!Settings.System.canWrite(this)) {
            requestWriteSettingsPermission();
        } else {
            getFragmentManager()
                .beginTransaction()
                .add(
                    R.id.content_frame,
                    new MiscSettingsFragment(),
                    TAG_MISC_SETTINGS
                )
                .commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Settings.System.canWrite(this)){
            Log.d(TAG_MISC_SETTINGS, "WRITE_SETTINGS_PERMISSION granted");
            finish();
            startActivity(starterIntent);
        }
    }

    private void requestWriteSettingsPermission() {
        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}