package com.ronanplugins.fundamentals.player.commands;

import com.ronanplugins.fundamentals.references.permissions.PermissionNode;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface FundamentalsCommand {
    void execute(CommandSender sender, String label, String[] args);

    List<String> tabComplete(CommandSender sendi, String[] args);

    @NotNull PermissionNode permission();

    String getName();

    default boolean isDebugOnly() {
        return false;
    }

    default boolean enabled() {
        return true;
    }
}
