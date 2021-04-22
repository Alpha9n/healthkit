package pro.freeserver.plugin.alphakun.healthkits.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class InventoryClick implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getView().getPlayer();
        if (e.getClick().equals(ClickType.RIGHT)){
            ItemStack item = e.getCurrentItem();
            if (item != null && item.hasItemMeta()) {

            }
        }
    }
}
