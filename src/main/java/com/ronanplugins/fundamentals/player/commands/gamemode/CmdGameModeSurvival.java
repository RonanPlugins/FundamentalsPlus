package com.ronanplugins.fundamentals.player.commands.gamemode;

import com.ronanplugins.fundamentals.player.commands.FunCommandRegisterable;
import com.ronanplugins.fundamentals.references.messages.MessagesCore;
import com.ronanplugins.fundamentals.references.permissions.PermissionNode;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CmdGameModeSurvival extends FunCommandRegisterable {

    public CmdGameModeSurvival() {
        super("gamemodesurvival, gms, gmsurvival, gmsur");
    }

    @Override
    public void run(CommandSender sendi, String label, String[] args) {
        Player player = (Player) sendi;
        player.setGameMode(GameMode.SURVIVAL);
        MessagesCore.GAMEMODE_SET_SURVIVAL.send(sendi);
    }

    @Override
    public List<String> tab(CommandSender sendi, String label, String[] args) {
        return null;
    }

    @Override
    public @NotNull PermissionNode permission() {
        return PermissionNode.COMMAND_GAMEMODE_SURVIVAL;
    }
}
