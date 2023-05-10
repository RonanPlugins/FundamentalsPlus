package com.ronanplugins.fundamentals.references.permissions;

import lombok.Getter;

public enum PermissionNode implements PermissionCheck {
    // Add your permission nodes here
    //Core commands (ie: /fp <sub-cmd>)
    CORE_USE("use"),
    //Teleportation
    COMMAND_TELEPORT("command.teleport"),
    //Fly
    COMMAND_FLY("command.fly"),
    //Gamemode
    COMMAND_GAMEMODE_CREATIVE("command.gmc"),
    COMMAND_GAMEMODE_SURVIVAL("command.gms"),
    ;


    @Getter private final String node;

    PermissionNode(String node) {
        this.node = PermissionCheck.getPrefix() + node;
    }

    @Override
    public boolean isDev() {
        return false; // Change this to `true` if you want to make a permission node developer-only
    }
}