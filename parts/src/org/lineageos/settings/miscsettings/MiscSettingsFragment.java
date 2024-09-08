package org.lineageos.settings.miscsettings;

import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import androidx.preference.PreferenceFragment;
import androidx.preference.SwitchPreferenceCompat;

import org.lineageos.settings.R;

public class MiscSettingsFragment extends PreferenceFragment {

    private static final String KEY_STORAGE_SHOW_ALL = "storage_show_all";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.misc_settings);

        initSwitch(KEY_STORAGE_SHOW_ALL);
    }

    private void initSwitch(String setting) {
        SwitchPreferenceCompat sw = findPreference(setting);
        if (sw != null) {
            sw.setOnPreferenceChangeListener((pref, val) -> {
                Log.d(MiscSettingsActivity.TAG_MISC_SETTINGS, "Updating preference " + setting + " to: " + val);
                boolean enabled = (Boolean) val;
                updateSystemSetting(setting, enabled);
                return true;
            });
            return;
        }
        Log.e(MiscSettingsActivity.TAG_MISC_SETTINGS, "Failed to initialize switch for: " + setting);
    }

    private void updateSystemSetting(String key, boolean value) {
        ContentResolver cr = getContext().getContentResolver();
        Settings.System.putInt(cr, key, value ? 1 : 0);
    }
}