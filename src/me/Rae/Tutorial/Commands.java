package me.Rae.Tutorial;

import net.minecraft.server.v1_12_R1.CommandExecute;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Commands extends CommandExecute implements Listener, CommandExecutor {

    public String cmd1 = "giveitem";
    public String cmd2 = "tutorial";

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            if (cmd.getName().equalsIgnoreCase(cmd1)) {

                if (args.length != 0) {
                    Material item = Material.getMaterial(args[0].toUpperCase());

                    if (item != null) {

                        Inventory inv = ((Player) sender).getInventory();
                        inv.addItem(new ItemStack(item, 1));

                        return true;
                    }

                    else {

                        sender.sendMessage(ChatColor.YELLOW + args[0] + ChatColor.RED + "is not a valid item.");
                        return true;

                    }
                }

                else {

                    sender.sendMessage(ChatColor.BLUE + "Not enough arguments.");
                    return true;
                }
            }

            if (cmd.getName().equalsIgnoreCase(cmd2)) {
                System.out.print(1);
            }

        }

        else {

            sender.sendMessage(ChatColor.RED + "Only players can use this command!");

            return true;
        }
        return false;
    }

}
