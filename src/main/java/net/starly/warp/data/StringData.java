package net.starly.warp.data;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

import static net.starly.warp.WarpMain.config;

public class StringData {

    /**
     * Get String from config | messages.warp.main
     */
    public String msgMain() {
        return getPrefix() + config.getString("messages.warp.main");
    }


    /**
     * Get String from config | messages..warp.create
     * @param name
     */
    public String msgWarpCreate(String name) {
        return getPrefix() + config.getString("messages.warp.create").replace("{warp}", name);
    }


    /**
     * Get String from config | messages.warp.delete
     * @param name
     */
    public String msgWarpDelete(String name) {
        return getPrefix() + config.getString("messages.warp.delete").replace("{warp}", name);
    }


    /**
     * Get String from config | messages.warp.teleport
     * @param name
     */
    public String msgWarpTeleport(String name) {
        return getPrefix() + config.getString("messages.warp.teleported").replace("{warp}", name);
    }


    /**
     * Get String from config | messages.warp.set_spawn
     */
    public String msgWarpSetSpawn() {
        return getPrefix() + config.getString("messages.warp.set_spawn");
    }


    /**
     * Get String from config | messages.warp.teleport_spawn
     * @return
     */
    public String msgWarpSpawn() {
        return getPrefix() + config.getString("messages.warp.teleport_spawn");
    }


    public String msgWarpHelp(Player player) {
        List<String> message = config.getConfig().getStringList("messages.warp.help");

        for(String msg : message) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', getPrefix() + msg));
        }
        return null;
    }


    /**
     * Get String from config | messages.warp.teleport_target_executor
     */
    public String msgWarpTeleportTargetP() {
        return getPrefix() + config.getString("messages.warp.teleport_target_executor");
    }


    /**
     * Get String from config | messages.warp.teleport_target_target
     */
    public String msgWarpTeleportTargetT() {
        return getPrefix() + config.getString("messages.warp.teleport_target_target");
    }


    /**
     * Get StringList from config | Messages.warp.list
     * @param list
     */
    public String msgWarpList(List<String> list) {
        return getPrefix() + config.getString("messages.warp.list").replace("{list}", String.join("\n", list));
    }


    /**
     * Get String from config | errorMessages.warp.spawn_is_not_set
     */
    public String errorMsgWarpNotSetSpawn() {
        return getPrefix() + config.getString("errorMessages.warp.spawn_is_not_set");
    }


    /**
     * Get String from config | errorMessages.warp.please_enter_name
     * @return
     */
    public String errorMsgExactly() {
        return getPrefix() + config.getString("errorMessages.warp.please_enter_name");
    }


    /**
     * Get String from config | errorMessages.warp.no_permission
     * @return
     */
    public String errorMsgNotPermission() {
        return getPrefix() + config.getString("errorMessages.warp.no_permission");
    }


    /**
     * Get String from config | errorMessages.warp.already_exist
     * @return
     */
    public String errorMsgExist() {
        return getPrefix() + config.getString("errorMessages.warp.already_exist");
    }


    /**
     * Get String from config | errorMessages.warp.not_exist
     * @return
     */
    public String errorMsgNotExist() {
        return getPrefix() + config.getString("errorMessages.warp.not_exist");
    }


    public String errorMsgNotPlayer() {
        return getPrefix() + config.getString("errorMessages.warp.wrong_target");
    }

    public String errorMsgWrong() {
        return getPrefix() + config.getString("errorMessages.warp.wrong_command");
    }


    /**
     * Gets a prefix from the config
     */
    public String getPrefix() {
        return config.getString("prefix");
    }
}
