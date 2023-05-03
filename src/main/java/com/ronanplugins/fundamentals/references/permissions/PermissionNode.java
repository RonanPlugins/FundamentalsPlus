package com.ronanplugins.fundamentals.references.permissions;

import lombok.Getter;

public enum PermissionNode implements PermissionCheck {
    // Add your permission nodes here
    USE("use"),
    EXAMPLE_PERMISSION("example.permission"),

//    Teleportation
    TELEPORT_USE("teleport.use");


    @Getter private final String node;

    PermissionNode(String node) {
        this.node = PermissionCheck.getPrefix() + node;
    }

    @Override
    public boolean isDev() {
        return false; // Change this to `true` if you want to make a permission node developer-only
    }
}