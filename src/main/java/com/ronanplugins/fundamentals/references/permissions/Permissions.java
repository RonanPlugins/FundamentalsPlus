package com.ronanplugins.fundamentals.references.permissions;

import com.ronanplugins.fundamentals.references.depends.DepPerms;
import org.bukkit.command.CommandSender;

public class Permissions {

    private final DepPerms depPerms = new DepPerms();

    public void register() {
        depPerms.register();
    }

    public boolean checkPerm(String str, CommandSender sendi) {
        return depPerms.hasPerm(str, sendi);
    }

}