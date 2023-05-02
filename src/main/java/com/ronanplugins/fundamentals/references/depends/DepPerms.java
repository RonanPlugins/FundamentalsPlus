package com.ronanplugins.fundamentals.references.depends;

import com.ronanplugins.fundamentals.FundamentalsPlus;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;

public class DepPerms {
    public Permission p = null;

    public boolean hasPerm(String perm, CommandSender sendi) {
        //sendi.sendMessage(perm);
        if (p != null)
            return p.has(sendi, perm);
        return sendi.hasPermission(perm);
    }

    public void register() {
        try {
            if (FundamentalsPlus.getInstance().getServer().getPluginManager().isPluginEnabled("Vault")) {
                RegisteredServiceProvider<Permission> permissionProvider = FundamentalsPlus.getInstance().getServer()
                        .getServicesManager().getRegistration(Permission.class);
                p = permissionProvider.getProvider();
            } else
                p = null;
        } catch (NullPointerException e) {
            //Vault but no Perms
        }
    }
}
