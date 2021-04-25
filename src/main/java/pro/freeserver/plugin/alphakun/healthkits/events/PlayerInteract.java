package pro.freeserver.plugin.alphakun.healthkits.events;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pro.freeserver.plugin.alphakun.healthkits.healdata.MedicalDataGetClass;

import static pro.freeserver.plugin.alphakun.healthkits.Healthkits.debugmessage;
import static pro.freeserver.plugin.alphakun.healthkits.Healthkits.healthKitData;
import static pro.freeserver.plugin.alphakun.healthkits.timers.Timer.healtime;

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
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,999999,2,false,false,false));
            p.getWorld().playSound(p.getLocation(),Sound.ENTITY_BLAZE_SHOOT,1f,2f);
            healtime(p,healValue,healitemname,longusetime);
            if (debugmessage) {
                System.out.println(p.getName() + " is now used " + healitemname);
            }
            minusItemStack(item,1,p);
        }
    }



    private void minusItemStack(ItemStack item,int minusstack,Player p) {
        item.setAmount(item.getAmount() - minusstack);
        p.updateInventory();
    }
}
