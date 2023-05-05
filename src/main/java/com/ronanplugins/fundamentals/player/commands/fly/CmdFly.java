package com.ronanplugins.fundamentals.player.commands.fly;

import com.ronanplugins.fundamentals.player.commands.FunCommandRegisterable;
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
        sendi.sendMessage("Flight command!");
        if (sendi instanceof Player player) {
            //CONFIRM MESSAGE
            player.setFlying(!player.isFlying());
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
