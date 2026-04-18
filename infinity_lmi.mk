#
# Copyright (C) 2021 The LineageOS Project
#
# SPDX-License-Identifier: Apache-2.0
#

# Inherit from those products. Most specific first.
$(call inherit-product, $(SRC_TARGET_DIR)/product/core_64_bit.mk)
$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base_telephony.mk)

# Inherit from the device configuration.
$(call inherit-product, device/xiaomi/lmi/device.mk)

# Inherit from common Infinity-X configuration
$(call inherit-product, vendor/infinity/config/common_full_phone.mk)

# Device identifier. This must come after all inclusions
PRODUCT_NAME := infinity_lmi
PRODUCT_DEVICE := lmi
PRODUCT_MANUFACTURER := Xiaomi
PRODUCT_BRAND := POCO
PRODUCT_MODEL := POCO F2 Pro
EXTRA_UDFPS_ANIMATIONS := true
TARGET_DISABLE_EPPE := true

PRODUCT_GMS_CLIENTID_BASE := android-xiaomi

BUILD_FINGERPRINT := Redmi/lmi/lmi:12/SKQ1.211006.001/V14.0.1.0.SJKMIXM:user/release-keys

PRODUCT_BUILD_PROP_OVERRIDES += \
    ProductName=lmi_global \
    SystemName=lmi_global

# Infinity-X stuff
#TARGET_SHIPS_GOOGLE_DIALER := true
TARGET_BOOT_ANIMATION_RES := 1080
#TARGET_SHIPS_FULL_GAPPS := true
USE_MOTO_CALCULATOR := false
TARGET_SUPPORTS_BLUR := true
TARGET_HAS_UDFPS := true
#TARGET_SHIPS_MIUI := true
WITH_GAPPS := true

# Maintainer & Build type
INFINITY_BUILD_TYPE := OFFICIAL
INFINITY_MAINTAINER := palexdev