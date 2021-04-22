package pro.freeserver.plugin.alphakun.healthkits.healdata;

import org.bukkit.Sound;

public class HealthKitData {

    private double healvalue;
    private String healitemname;
    private Sound playsound;
    private float soundvolume;
    private float soundpitch;
    private double usetime;

    public HealthKitData(String healitemname, double healvalue, double usetime, Sound playsound, float soundvolume, float soundpitch){
        this.healitemname = healitemname;
        this.healvalue = healvalue;
        this.playsound = playsound;
        this.soundvolume = soundvolume;
        this.soundpitch = soundpitch;
        this.usetime = usetime;
    }

    public double getHealvalue() {
        return healvalue;
    }

    public void setHealvalue(double healvalue) {
        this.healvalue = healvalue;
    }

    public String getHealitemname() {
        return healitemname;
    }

    public void setHealitemname(String healitemname) {
        this.healitemname = healitemname;
    }

    public Sound getPlaysound() {
        return playsound;
    }

    public void setPlaysound(Sound playsound) {
        this.playsound = playsound;
    }

    public float getSoundvolume() {
        return soundvolume;
    }

    public void setSoundvolume(float soundvolume) {
        this.soundvolume = soundvolume;
    }

    public float getSoundpitch() {
        return soundpitch;
    }

    public void setSoundpitch(float soundpitch) {
        this.soundpitch = soundpitch;
    }

    public double getUsetime() {
        return usetime;
    }

    public void setUsetime(double usetime) {
        this.usetime = usetime;
    }
}
