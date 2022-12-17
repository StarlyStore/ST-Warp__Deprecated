package com.github.nicks.warp;

import com.github.nicks.nicklib.data.Config;
import com.github.nicks.warp.command.SetSpawnCmd;
import com.github.nicks.warp.command.SpawnCmd;
import com.github.nicks.warp.command.WarpCmd;
import com.github.nicks.warp.command.tabcomplete.WarpTabCompl;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private final Logger log = Bukkit.getLogger();
    private Main plugin;


    @Override
    public void onEnable() {
        plugin = this;
        if(Bukkit.getPluginManager().getPlugin("ST-Core") == null) {
            log.warning("[" + plugin.getName() + "] ST-Core 플러그인이 적용되지 않았습니다! 플러그인을 비활성화합니다.");
            log.warning("[" + plugin.getName() + "] 다운로드 링크 : &fhttps://discord.gg/TF8jqSJjCG");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

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
