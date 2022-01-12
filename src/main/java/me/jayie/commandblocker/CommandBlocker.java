package me.jayie.commandblocker;

import me.jayie.commandblocker.listeners.commandblocker;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandBlocker extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        startupmessage();
        listeners();
        files();
    }

    public void listeners(){
        getServer().getPluginManager().registerEvents(new commandblocker(this), this);
    }

    public void files(){

    }

    public void startupmessage(){
        getLogger().info(Color("&8[&cCMDBlocker&8] &aActivated, Your security is now enabled."));
        getLogger().info(Color("&8[&cCMDBlocker&8] &7Created by Jayie."));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    private String Color(String s){
        s = ChatColor.translateAlternateColorCodes('&', s);
        return s;
    }
}
