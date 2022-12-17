package com.github.nicks.warp.data;


import com.github.nicks.nicklib.data.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;


public class WarpData {

    private Config config;
    private StringData stringData = new StringData();


    /**
     * Create a warp
     *
     * @param player
     * @param name
     */
    public void createWarp(Player player, String name) {
        config = new Config("warp/" + name);
        if (!config.isFileExist()) {
            config.setLocation("location", player.getLocation());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.msgWarpCreate(name)));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgExist()));
        }
    }


    /**
     * Delete a warp
     *
     * @param name
     */
    public void deleteWarp(Player player, String name) {
        config = new Config("warp/" + name);

        if (config.isFileExist()) {
            config.delete();
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.msgWarpDelete(name)));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgNotExist()));
        }
    }


    /**
     * Teleport to a warp
     *
     * @param player
     * @param name
     */
    public void teleportWarp(Player player, String name) {
        config = new Config("warp/" + name);

        if (config.isFileExist()) {
            World world = Bukkit.getWorld(config.getString("location.world"));
            player.teleport(new Location(world, config.getDouble("location.x"), config.getDouble("location.y"), config.getDouble("location.z")));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.msgWarpTeleport(name)));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgNotExist()));
        }
    }

    /**
     * Teleport to a warp
     *
     * @param player
     */
    public void teleportWarp(Player player, Player target, String name) {

        config = new Config("warp/" + name);

        if (config.isFileExist()) {
            if (target == null) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgNotPlayer()));
            } else {
                World world = Bukkit.getWorld(config.getString("location.world"));
                target.teleport(new Location(world, config.getDouble("location.x"), config.getDouble("location.y"), config.getDouble("location.z")));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.msgWarpTeleportTargetP()
                        .replace("{target}", target.getDisplayName())
                        .replace("{warp}", name)));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.msgWarpTeleportTargetT()
                        .replace("{player}", target.getDisplayName())
                        .replace("{warp}", name)));
            }
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgNotExist()));
        }
    }


    /**
     * Set spawn
     *
     * @param player
     */
    public void setSpawn(Player player) {
        config = new Config("spawn");
        config.setLocation("location", player.getLocation());
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.msgWarpSetSpawn()));
    }


    /**
     * Teleport to spawn
     *
     * @param player
     */
    public void teleportSpawn(Player player) {
        config = new Config("spawn");

        if (config.isFileExist()) {
            World world = Bukkit.getWorld(config.getString("location.world"));
            player.teleport(new Location(world, config.getDouble("location.x"), config.getDouble("location.y"), config.getDouble("location.z")));
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.msgWarpSetSpawn()));
        }
    }
}
