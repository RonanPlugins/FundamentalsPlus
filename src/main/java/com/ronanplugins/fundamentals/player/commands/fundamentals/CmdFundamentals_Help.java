package com.ronanplugins.fundamentals.player.commands.fundamentals;

import com.ronanplugins.fundamentals.player.commands.FunCommandCore;
import com.ronanplugins.fundamentals.references.permissions.PermissionNode;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CmdFundamentals_Help implements FunCommandCore {
    @Override
    public void run(CommandSender sendi, String label, String[] args) {
        sendi.sendMessage("Fundamentals Info Command!");
    }

    @Override
    public List<String> tab(CommandSender sendi, String label, String[] args) {
        return null;
    }

    @Override
    public PermissionNode permission() {
        return null;
    }
}
