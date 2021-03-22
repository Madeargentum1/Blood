package com.blood;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public void onEnable(){
        getLogger().info("I'm enabled!");
        Bukkit.getPluginManager().registerEvents(new HitBlood(this), this);
    }
    public void onDisable() {
        getLogger().info("I'm disabled!");
    }
    //Bukkit.getPluginManager().registerEvents(new HitBlood(this), this);
}
