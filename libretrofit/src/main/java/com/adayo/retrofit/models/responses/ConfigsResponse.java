package com.adayo.retrofit.models.responses;

import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

/**
 * @Description 千人千面设置项响应
 * @Author 王小军
 * @CreateTime 2024年07月08日
 **/

public class ConfigsResponse extends BaseResponse {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, ConfigsResponse.class.getSimpleName());
    public Data data;
    public static class Data {
        public String seat;
        public String rearviewMirror;
        public String hud;
        public String atmosphereLamp;
        public String panoramicImage;
        public String adas;
        public String steeringWheel;
        public String instrument;
        public String courtesyLamp;
        public String carDoor;
        public String ac;
        public String radio;
        public String wallpaper;
        public String lighting;
        public String privacy;
        public String sound;
        public String voice;
        public String display;
        public String soundEffects;
        public String tailgate;
        public String driveMode;
        public String other;
        public long updateTime;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Data{");
            sb.append("seat='").append(seat).append('\'');
            sb.append(", rearviewMirror='").append(rearviewMirror).append('\'');
            sb.append(", hud='").append(hud).append('\'');
            sb.append(", atmosphereLamp='").append(atmosphereLamp).append('\'');
            sb.append(", panoramicImage='").append(panoramicImage).append('\'');
            sb.append(", adas='").append(adas).append('\'');
            sb.append(", steeringWheel='").append(steeringWheel).append('\'');
            sb.append(", instrument='").append(instrument).append('\'');
            sb.append(", courtesyLamp='").append(courtesyLamp).append('\'');
            sb.append(", carDoor='").append(carDoor).append('\'');
            sb.append(", ac='").append(ac).append('\'');
            sb.append(", radio='").append(radio).append('\'');
            sb.append(", wallpaper='").append(wallpaper).append('\'');
            sb.append(", lighting='").append(lighting).append('\'');
            sb.append(", privacy='").append(privacy).append('\'');
            sb.append(", sound='").append(sound).append('\'');
            sb.append(", voice='").append(voice).append('\'');
            sb.append(", display='").append(display).append('\'');
            sb.append(", soundEffects='").append(soundEffects).append('\'');
            sb.append(", tailgate='").append(tailgate).append('\'');
            sb.append(", driveMode='").append(driveMode).append('\'');
            sb.append(", other='").append(other).append('\'');
            sb.append(", updateTime=").append(updateTime);
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConfigsResponse{");
        sb.append("data=").append(data);
        sb.append(", statusCode='").append(statusCode).append('\'');
        sb.append(", statusMessage='").append(statusMessage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
