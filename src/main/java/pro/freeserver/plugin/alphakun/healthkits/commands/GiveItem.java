package pro.freeserver.plugin.alphakun.healthkits.commands;

import org.apache.commons.lang.math.NumberUtils;
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
                        player.sendMessage(prefix + "§9利用法 \n§f=> §9/giveheal <itemname> <amount>");
                    }
                    else if(args.length == 2 && NumberUtils.isDigits(args[1])) {
                        generateItem(args[0],player,Integer.parseInt(args[1]));
                    }
                    else {
                        String arg1 = args[0];
                        generateItem(arg1, player, 1);
                    }
                }
            }
        }
        return false;
    }

    private void generateItem(String healitemname, Player player, int amount) {
        for (int i = 1; i <= amount; i++){
            if (healitemname.equalsIgnoreCase("ifak")){
                player.getInventory().addItem(createIFAK());
            }
        }
    }
}
