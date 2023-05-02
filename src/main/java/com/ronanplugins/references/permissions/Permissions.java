package com.ronanplugins.references.permissions;

import org.bukkit.command.CommandSender;

public class Permissions {

    public boolean checkPerm(String permission, CommandSender sender) {
        return sender.hasPermission(permission);
    }

}