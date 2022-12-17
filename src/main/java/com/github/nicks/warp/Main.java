package com.github.nicks.warp;

import com.github.nicks.nicklib.data.Config;
import com.github.nicks.warp.command.SetSpawnCmd;
import com.github.nicks.warp.command.SpawnCmd;
import com.github.nicks.warp.command.WarpCmd;
import com.github.nicks.warp.command.tabcomplete.WarpTabCompl;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        Config config = new Config("config");
        config.loadDefaultConfig();
        init();
    }


    /**
     * Register Event or Command
     */
    public void init() {

        // Register Command
        Bukkit.getPluginCommand("warp").setExecutor(new WarpCmd());
        Bukkit.getPluginCommand("warp").setTabCompleter(new WarpTabCompl());
        Bukkit.getPluginCommand("setspawn").setExecutor(new SetSpawnCmd());
        Bukkit.getPluginCommand("spawn").setExecutor(new SpawnCmd());
    }
}
