package pro.freeserver.plugin.alphakun.healthkits.events;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import pro.freeserver.plugin.alphakun.healthkits.healdata.MedicalDataGetClass;

import static pro.freeserver.plugin.alphakun.healthkits.Healthkits.*;

public class InventoryClick implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getView().getPlayer();
        ItemStack item = e.getCurrentItem();
        if (NBTEditor.contains(item,"healitems")) {
            e.setCancelled(true);
            double healValue = MedicalDataGetClass.getHealValue(item);
            String healitemname = MedicalDataGetClass.getHealItemName(item);
            long longusetime = (long) healthKitData.getUsetime();
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,999999,2,false,false,false));
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_BLAZE_SHOOT,1f,2f);
            healtime(p,healValue,healitemname,longusetime);
            if (debugmessage) {
                System.out.println(p.getName() + " is now used " + healitemname);
            }
            minusItemStack(item,1,p);
        }
    }

    private void healtime(Player p,double healValue,String healitemname,Long delay) {
        new BukkitRunnable() {
            @Override
            public void run() {
                p.setHealth(healValue);
                p.playSound(p.getLocation(),healthKitData.getPlaysound(),healthKitData.getSoundvolume(),healthKitData.getSoundpitch());
                p.sendActionBar("§a§n§l" + healitemname + "を使用しました");
                p.removePotionEffect(PotionEffectType.SLOW);
            }
        }.runTaskLater(plugin,delay);
    }

    private void minusItemStack(ItemStack item,int minusstack,Player p) {
        item.setAmount(item.getAmount() - minusstack);
        p.updateInventory();
    }
}
