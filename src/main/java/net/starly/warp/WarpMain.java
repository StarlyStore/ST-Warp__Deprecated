package net.starly.warp;

import net.starly.core.bstats.Metrics;
import net.starly.core.data.Config;
import net.starly.warp.command.SetSpawnCommand;
import net.starly.warp.command.SpawnCommand;
import net.starly.warp.command.WarpCmdTab;
import net.starly.warp.command.WarpCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class WarpMain extends JavaPlugin {

    private final Logger log = Bukkit.getLogger();
    private static JavaPlugin plugin;
    public static Config config;

    @Override
    public void onEnable() {
        Metrics metrics = new Metrics(this, 17174);

        if (Bukkit.getPluginManager().getPlugin("ST-Core") == null) {
            log.warning("[" + plugin.getName() + "] ST-Core 플러그인이 적용되지 않았습니다! 플러그인을 비활성화합니다.");
            log.warning("[" + plugin.getName() + "] 다운로드 링크 : &fhttps://discord.gg/TF8jqSJjCG");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        plugin = this;

        config = new Config("config", plugin);
        config.loadDefaultPluginConfig();
        init();
    }


    /**
     * Register Event or Command
     */
    public void init() {
        // Register Command
        Bukkit.getPluginCommand("warp").setExecutor(new WarpCommand());
        Bukkit.getPluginCommand("warp").setTabCompleter(new WarpCmdTab());
        Bukkit.getPluginCommand("setspawn").setExecutor(new SetSpawnCommand());
        Bukkit.getPluginCommand("spawn").setExecutor(new SpawnCommand());
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }
}
