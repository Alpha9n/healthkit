package pro.freeserver.plugin.alphakun.healthkits.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static pro.freeserver.plugin.alphakun.healthkits.items.MedicalKit.createIFAK;
import static pro.freeserver.plugin.alphakun.healthkits.Healthkits.*;

public class GiveItem implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()){
                if (label.equalsIgnoreCase("giveheal")) {
                    if (args.length == 0) {
                        player.sendMessage(prefix + "§9利用法 \n§f=> §9/giveheal <itemname>");
                    }
                    else{
                        String arg1 = args[0];
                        generateItem(arg1, player);
                    }
                }
            }
        }
        return false;
    }

    private void generateItem(String healitemname, Player player) {
        if (healitemname.equalsIgnoreCase("ifak")){
            player.getInventory().addItem(createIFAK());
        }
    }
}
