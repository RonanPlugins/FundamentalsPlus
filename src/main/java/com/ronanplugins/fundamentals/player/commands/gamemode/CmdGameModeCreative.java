package com.ronanplugins.fundamentals.player.commands.gamemode;

import com.ronanplugins.fundamentals.player.commands.FunCommandRegisterable;
import com.ronanplugins.fundamentals.references.messages.MessagesCore;
import com.ronanplugins.fundamentals.references.permissions.PermissionNode;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CmdGameModeCreative extends FunCommandRegisterable {

    public CmdGameModeCreative() {
        super("gamemodecreative, gmc, gmcreative, gmcre");
    }

    @Override
    public void run(CommandSender sendi, String label, String[] args) {
        Player player = (Player) sendi;
        player.setGameMode(GameMode.CREATIVE);
        MessagesCore.GAMEMODE_SET_CREATIVE.send(sendi);
    }

    @Override
    public List<String> tab(CommandSender sendi, String label, String[] args) {
        return null;
    }

    @Override
    public @NotNull PermissionNode permission() {
        return PermissionNode.COMMAND_GAMEMODE_CREATIVE;
    }
}
