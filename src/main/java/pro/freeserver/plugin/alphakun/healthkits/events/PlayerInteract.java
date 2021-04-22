package pro.freeserver.plugin.alphakun.healthkits.events;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import pro.freeserver.plugin.alphakun.healthkits.healdata.MedicalDataGetClass;

import static pro.freeserver.plugin.alphakun.healthkits.Healthkits.*;

public class PlayerInteract implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack item = p.getInventory().getItemInMainHand();
        if (NBTEditor.contains(item,"healitems") && e.getHand().equals(EquipmentSlot.HAND)) {
            e.setCancelled(true);
            double healValue = MedicalDataGetClass.getHealValue(item);
            String healitemname = MedicalDataGetClass.getHealItemName(item);
            long longusetime = (long) healthKitData.getUsetime();
            p.setHealth(healValue);
            healtime(p,longusetime);
            p.sendActionBar("§a§n" + healitemname + "を使用しました。");
            if (debugmessage) {
                System.out.println(p.getName() + " is now used " + healitemname);
            }
        }
    }

    private void healtime(Player p,Long delay) {
        new BukkitRunnable() {
            @Override
            public void run() {
                p.playSound(p.getLocation(),healthKitData.getPlaysound(),healthKitData.getSoundvolume(),healthKitData.getSoundpitch());
            }
        }.runTaskLater(plugin,delay);
    }
}
