package pro.freeserver.plugin.alphakun.healthkits.items;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;
import pro.freeserver.plugin.alphakun.healthkits.apis.ItemStackAPI;

import java.util.Arrays;

import static pro.freeserver.plugin.alphakun.healthkits.Healthkits.healthKitData;
import static pro.freeserver.plugin.alphakun.healthkits.apis.GsonAPI.dataSerialize;
import static pro.freeserver.plugin.alphakun.healthkits.apis.NBThandler.setHealthItemData;

public class MedicalKit {
    public static ItemStack createIFAK() {
        ItemStack item = ItemStackAPI.setItemStack(Material.STICK,1,"§aIFAK §f[§c回復§f]", Arrays.asList("§9IFAK(Improved First Aid Kit)は","§9USAMMAが、陸軍の兵士のために開発した","§9応急キットです。"),800);
        healthKitData.setHealitemname("ifak");
        healthKitData.setHealvalue(20.0);
        healthKitData.setPlaysound(Sound.ENTITY_SHEEP_SHEAR);
        healthKitData.setSoundvolume(100.0f);
        healthKitData.setSoundpitch(2f);
        healthKitData.setUsetime(100.0);
        String data = dataSerialize(healthKitData);
        return setHealthItemData(item,data);
    }
}
