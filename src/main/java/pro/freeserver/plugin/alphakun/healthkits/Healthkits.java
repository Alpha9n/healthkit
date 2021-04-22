package pro.freeserver.plugin.alphakun.healthkits;

import org.bukkit.Sound;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pro.freeserver.plugin.alphakun.healthkits.commands.GiveItem;
import pro.freeserver.plugin.alphakun.healthkits.events.InventoryClick;
import pro.freeserver.plugin.alphakun.healthkits.events.PlayerInteract;
import pro.freeserver.plugin.alphakun.healthkits.healdata.HealthKitData;

public final class Healthkits extends JavaPlugin {

    public static Plugin plugin;
    public static String prefix = "§dHealth §f>> ";
    public static HealthKitData healthKitData = new HealthKitData("",0.0, 40.0, Sound.ENTITY_SHEEP_SHEAR, 100f, 1.0f);
    public static Boolean debugmessage = true;

    @Override
    public void onEnable() {
        plugin = this;
        loadCommands();
        loadEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadCommands() {
        getCommand("giveheal").setExecutor(new GiveItem());
    }

    private void loadEvents() {
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
    }

}
