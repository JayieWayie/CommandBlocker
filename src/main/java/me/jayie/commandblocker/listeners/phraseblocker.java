package me.jayie.commandblocker.listeners;

import me.jayie.commandblocker.CommandBlocker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class phraseblocker implements Listener {


    private CommandBlocker plugin;
    public phraseblocker(CommandBlocker plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        List<String> phrases = plugin.getConfig().getStringList("BlockedPhrases");
        String blockedphrasesmsg = plugin.getConfig().getString("BlockedPhrasesMessage");
        String prefix = plugin.getConfig().getString("PrefixValue");
        Player player = e.getPlayer();
        String phrasessplitcompare = "";
        for (String phrasessplit : phrases){
            phrasessplitcompare = phrasessplit;
        }

        if (e.getMessage().equalsIgnoreCase(phrasessplitcompare)){
            e.setCancelled(true);
            player.sendMessage(prefix + " " + blockedphrasesmsg);
        }




    }

    private String Color(String s){
        s= ChatColor.translateAlternateColorCodes('&',s);
        return s;
    }


}
