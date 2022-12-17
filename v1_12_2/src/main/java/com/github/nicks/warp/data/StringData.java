package com.github.nicks.warp.data;

import com.github.nicks.nicklib.data.Config;

import java.util.List;


public class StringData {

    private Config config = new Config("config");



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
        return getPrefix() + config.getString("messages.warp.teleport").replace("{warp}", name);
    }


    /**
     * Get String from config | messages.warp.setSpawn
     */
    public String msgWarpSetSpawn() {
        return getPrefix() + config.getString("messages.warp.setSpawn");
    }


    /**
     * Get String from config | messages.warp.teleportSpawn
     * @return
     */
    public String msgWarpSpawn() {
        return getPrefix() + config.getString("messages.warp.teleportSpawn");
    }


    /**
     * Get StringList from config | Messages.warp.list
     * @param list
     * @return
     */
    public String getWarpList(List<String> list) {
        return getPrefix() + config.getString("messages.warp.list").replace("{list}", list.toString());
    }


    /**
     * Get String from config | errorMessages.warp.notSetSpawn
     */
    public String errorMsgWarpNotSetSpawn() {
        return getPrefix() + config.getString("errorMessages.warp.notSetSpawn");
    }


    /**
     * Get String from config | errorMessages.warp.exactly
     * @return
     */
    public String errorMsgExactly() {
        return getPrefix() + config.getString("errorMessages.warp.exactly");
    }


    /**
     * Get String from config | errorMessages.warp.notPermissions
     * @return
     */
    public String errorMsgNotPermission() {
        return getPrefix() + config.getString("errorMessages.warp.notPermission");
    }


    /**
     * Get String from config | errorMessages.warp.exist
     * @return
     */
    public String errorMsgExist() {
        return getPrefix() + config.getString("errorMessages.warp.exist");
    }


    /**
     * Get String from config | errorMessages.warp.notExist
     * @return
     */
    public String errorMsgNotExist() {
        return getPrefix() + config.getString("errorMessages.warp.notExist");
    }



    /**
     * Gets a prefix from the config
     */
    public String getPrefix() {
        return config.getString("prefix");
    }
}
