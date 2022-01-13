package me.jayie.commandblocker;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reloadcommand implements CommandExecutor {

    private CommandBlocker plugin;
    public reloadcommand(CommandBlocker plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("cmdblocker")){
                if (args[0].equalsIgnoreCase("reload")){
                    if (player.hasPermission("cmdblocker.reload")){
                        plugin.reloadConfig();
                    }
                }
            }
        }

        return true;
    }
}
