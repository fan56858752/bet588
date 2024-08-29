package com.haibing.mvvm.constants;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description 千人千面配置项常量
 * @Author 王小军
 * @CreateTime 2024年07月22日
 **/

public class ConfigConstants {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, ConfigConstants.class.getSimpleName());
    public static final String SPEAKER_SETTING = "speaker_setting";
    public static final String AWAKENING_WORDS = "awakening_words";

    public static final String TAKE_ME_HOME = "take_me_home";
    public static final String TURN_FLASH_FREQUENCY = "turn_flash_frequency";
    public static final String HEADLIGHT_HEIGHT = "headlight_height";

    public static final String SEAT_MEMORY_1 = "seat_memory_1";
    public static final String SEAT_MEMORY_2 = "seat_memory_2";
    public static final String SEAT_MEMORY_3 = "seat_memory_3";

    public static final String DRIVE_MODE = "drive_mode";
    public static final String ESP_MODE = "esp_mode";
    public static final String TAILGATE_MAX_HEIGHT = "tailgate_max_height";

    public static final String RGB_SETTING = "rgb_setting";
    public static final String BRIGHTNESS_SETTING = "brightness_setting";
    public static final String LIGHT_INTELLIGENT_MODE = "light_intelligent_mode";

    public static final String PRIVACY_MODE = "privacy_mode";

    public static final String LANGUAGE_SETTING = "language_setting";
    public static final String THEME_MODE = "theme_mode";

    public static final String VOLUME_COMPENSATION = "volume_compensation";
    public static final String NAVIGATION_SOUND_SETTING = "navigation_sound_setting";
    public static final String VOLUME_BALANCE = "volume_balance";
    public static final String EQUALIZER_SETTING = "equalizer_setting";
}
