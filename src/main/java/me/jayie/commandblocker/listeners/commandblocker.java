package me.jayie.commandblocker.listeners;

import com.sun.org.apache.xerces.internal.xs.StringList;
import me.jayie.commandblocker.CommandBlocker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;

import java.util.List;

public class commandblocker implements Listener {

    private CommandBlocker plugin;
    public commandblocker(CommandBlocker plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void CommandEvent(PlayerCommandPreprocessEvent e){
        List<String> blockedcommands = plugin.getConfig().getStringList("BlockedCommands");
        String prefix = plugin.getConfig().getString("PrefixValue");
        String error = plugin.getConfig().getString("CommandNotAllowed");
        String bypass = plugin.getConfig().getString("BypassedBlocker");
        Player player = e.getPlayer();
        String blockedcommandssplitcompare = "";
        boolean check = false;
        for(String blockedcommandssplit : blockedcommands){
            blockedcommandssplitcompare = blockedcommandssplit;
            if (e.getMessage().equalsIgnoreCase(blockedcommandssplitcompare)){
                check = true;
            }
        }

        if (check){
            if (!player.isOp()) {
                e.setCancelled(true);
                player.sendMessage(Color(prefix + " " + error));
            }else{
                player.sendMessage(Color(prefix + " " + bypass));
            }
        }


    }
    private String Color(String s){
        s = ChatColor.translateAlternateColorCodes('&', s);
        return s;
    }
}
