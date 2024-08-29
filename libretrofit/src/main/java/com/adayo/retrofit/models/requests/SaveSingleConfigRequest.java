package com.adayo.retrofit.models.requests;

import com.haibing.mvvm.constants.ConfigConstants;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;
import com.adayo.retrofit.utils.GsonUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * @Description 单项配置
 * @Author 王小军
 * @CreateTime 2024年07月08日
 **/

public class SaveSingleConfigRequest extends BaseRequest {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, SaveSingleConfigRequest.class.getSimpleName());
    public int type;
    public String configValue;

    public static class LightSetting {
        @SerializedName(ConfigConstants.TAKE_ME_HOME)
        public String takeMeHome;
        @SerializedName(ConfigConstants.TURN_FLASH_FREQUENCY)
        public String turnFlashFrequency;
        @SerializedName(ConfigConstants.HEADLIGHT_HEIGHT)
        public String headlightHeight;
        public LightSetting(String takeMeHome, String turnFlashFrequency, String headlightHeight) {
            this.takeMeHome = takeMeHome;
            this.turnFlashFrequency = turnFlashFrequency;
            this.headlightHeight = headlightHeight;
        }
        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class VoiceSetting {
        @SerializedName(ConfigConstants.SPEAKER_SETTING)
        public String speakerSetting;
        @SerializedName(ConfigConstants.AWAKENING_WORDS)
        public String awakeningWords;
        public VoiceSetting(String speakerSetting, String awakeningWords) {
            this.speakerSetting = speakerSetting;
            this.awakeningWords = awakeningWords;
        }
        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class SeatMemory {
        @SerializedName(ConfigConstants.SEAT_MEMORY_1)
        public String seatMemory1;
        @SerializedName(ConfigConstants.SEAT_MEMORY_2)
        public String seatMemory2;
        @SerializedName(ConfigConstants.SEAT_MEMORY_3)
        public String seatMemory3;
        public SeatMemory(String seatMemory1, String seatMemory2, String seatMemory3) {
            this.seatMemory1 = seatMemory1;
            this.seatMemory2 = seatMemory2;
            this.seatMemory3 = seatMemory3;
        }
        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class DriveMode {
        @SerializedName(ConfigConstants.DRIVE_MODE)
        public String driveMode;
        public DriveMode(String driveMode) {
            this.driveMode = driveMode;
        }
        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class SoundSetting {
        @SerializedName(ConfigConstants.VOLUME_COMPENSATION)
        public String volumeCompensation;
        @SerializedName(ConfigConstants.NAVIGATION_SOUND_SETTING)
        public String navigationSoundSetting;
        @SerializedName(ConfigConstants.VOLUME_BALANCE)
        public String volumeBalance;
        @SerializedName(ConfigConstants.EQUALIZER_SETTING)
        public String equalizerSetting;
        public SoundSetting(String volumeCompensation, String navigationSoundSetting, String volumeBalance, String equalizerSetting) {
            this.volumeCompensation = volumeCompensation;
            this.navigationSoundSetting = navigationSoundSetting;
            this.volumeBalance = volumeBalance;
            this.equalizerSetting = equalizerSetting;
        }
        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class EspMode {
        @SerializedName(ConfigConstants.ESP_MODE)
        public String espMode;
        public EspMode(String espMode) {
            this.espMode = espMode;
        }
        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class TailgateMaxHeight {
        @SerializedName(ConfigConstants.TAILGATE_MAX_HEIGHT)
        public String tailgateMaxHeight;
        public TailgateMaxHeight(String tailgateMaxHeight) {
            this.tailgateMaxHeight = tailgateMaxHeight;
        }
        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class PrivacyMode {
        @SerializedName(ConfigConstants.PRIVACY_MODE)
        public String privacyMode;
        public PrivacyMode(String privacyMode) {
            this.privacyMode = privacyMode;
        }
        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class DisplaySetting {
        @SerializedName(ConfigConstants.LANGUAGE_SETTING)
        public String languageSetting;
        @SerializedName(ConfigConstants.THEME_MODE)
        public String themeMode;
        public DisplaySetting(String languageSetting, String themeMode) {
            this.languageSetting = languageSetting;
            this.themeMode = themeMode;
        }
        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class AtmosphereLights {
        @SerializedName(ConfigConstants.RGB_SETTING)
        public String rgbSetting;
        @SerializedName(ConfigConstants.BRIGHTNESS_SETTING)
        public String brightSetting;
        @SerializedName(ConfigConstants.LIGHT_INTELLIGENT_MODE)
        public String lightIntelligentMode;
        public AtmosphereLights(String rgbSetting, String brightSetting, String lightIntelligentMode) {
            this.rgbSetting = rgbSetting;
            this.brightSetting = brightSetting;
            this.lightIntelligentMode = lightIntelligentMode;
        }
        @Override
        public String toString() {
            return new Gson().toJson(this);
        }

    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SaveSingleConfigRequest{");
        sb.append("type=").append(type);
        sb.append(", configValue=").append(configValue);
        sb.append('}');
        return sb.toString();
    }
}
