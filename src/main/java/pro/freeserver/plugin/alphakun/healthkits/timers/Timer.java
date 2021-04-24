package pro.freeserver.plugin.alphakun.healthkits.timers;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

import static pro.freeserver.plugin.alphakun.healthkits.Healthkits.healthKitData;
import static pro.freeserver.plugin.alphakun.healthkits.Healthkits.plugin;

public class Timer {

    public static HashMap<Player,BukkitRunnable> healtask = new HashMap<>();

    public static void healtime(Player p, double healValue, String healitemname, Long delay) {
        BukkitRunnable healtime = new BukkitRunnable() {
            @Override
            public void run() {
                p.setHealth(healValue);
                p.playSound(p.getLocation(),healthKitData.getPlaysound(),healthKitData.getSoundvolume(),healthKitData.getSoundpitch());
                p.sendActionBar("§a§n§l" + healitemname + "を使用しました");
                p.removePotionEffect(PotionEffectType.SLOW);
            }
        };
        healtime.runTaskLater(plugin,delay);
        healtask.put(p,healtime);
    }
}
