package pro.freeserver.plugin.alphakun.healthkits.healdata;

import org.bukkit.inventory.ItemStack;
import pro.freeserver.plugin.alphakun.healthkits.apis.GsonAPI;

import static pro.freeserver.plugin.alphakun.healthkits.apis.NBThandler.getHealthItemData;

public class MedicalDataGetClass {
    public static double getHealValue(ItemStack item){
        String data = getHealthItemData(item);
        HealthKitData healthKitData = GsonAPI.dataDeSerialize(data);
        return healthKitData.getHealvalue();
    }

    public static String getHealItemName(ItemStack item){
        String data = getHealthItemData(item);
        HealthKitData healthKitData = GsonAPI.dataDeSerialize(data);
        return healthKitData.getHealitemname();
    }
}
