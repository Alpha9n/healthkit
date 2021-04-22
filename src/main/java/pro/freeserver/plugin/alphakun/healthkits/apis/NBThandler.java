package pro.freeserver.plugin.alphakun.healthkits.apis;


import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.inventory.ItemStack;

public class NBThandler {
    public static ItemStack setHealthItemData(ItemStack item, String data) {
        return NBTEditor.set(item,data,"healitems");
    }

    public static String getHealthItemData(ItemStack item) {
        return NBTEditor.getString(item,"healitems");
    }
}