package com.ronanplugins.fundamentals.player.commands.fly;

import com.ronanplugins.fundamentals.player.commands.FunCommandRegisterable;
import com.ronanplugins.fundamentals.references.messages.MessagesCore;
import com.ronanplugins.fundamentals.references.permissions.PermissionNode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CmdFly extends FunCommandRegisterable {

    public CmdFly() {
        super("fly");
    }

    @Override
    public void run(CommandSender sendi, String label, String[] args) {
        Player player = (Player) sendi;
        boolean going_to_fly = !player.isFlying();
        fly(player, going_to_fly);
    }

    public static void fly(Player player, boolean going_to_fly) {
        player.setFlying(going_to_fly);
        if (going_to_fly) {
            MessagesCore.FLY_ENABLED.send(player);
        } else {
            MessagesCore.FLY_DISABLED.send(player);
        }
    }

    @Override
    public List<String> tab(CommandSender sendi, String label, String[] args) {
        return null;
    }

    @Override
    public @NotNull PermissionNode permission() {
        return PermissionNode.COMMAND_FLY;
    }
}
