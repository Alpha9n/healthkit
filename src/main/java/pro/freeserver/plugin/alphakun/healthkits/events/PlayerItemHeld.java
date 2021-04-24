package pro.freeserver.plugin.alphakun.healthkits.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.potion.PotionEffectType;
import pro.freeserver.plugin.alphakun.healthkits.timers.Timer;

public class PlayerItemHeld implements Listener {
    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent e){
        if (Timer.healtask.containsKey(e.getPlayer())) {
            Timer.healtask.get(e.getPlayer()).cancel();
            e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
        }
    }
}
