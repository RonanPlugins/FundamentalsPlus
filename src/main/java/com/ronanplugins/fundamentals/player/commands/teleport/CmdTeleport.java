package com.ronanplugins.fundamentals.player.commands.teleport;

import com.ronanplugins.fundamentals.player.commands.FunCommandRegisterable;
import com.ronanplugins.fundamentals.references.messages.MessagesCore;
import com.ronanplugins.fundamentals.references.permissions.PermissionNode;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

// alias /tp
public class CmdTeleport extends FunCommandRegisterable {

    public CmdTeleport() {
        super("teleport", "tp");
    }

    @Override
    public void run(CommandSender sendi, String label, String[] args) {
        Player player = (Player) sendi;
        if (args.length == 0) {
            MessagesCore.INVALID_ARGUMENTS.send(player);
            return;
        }

        // Try to parse coordinates from arguments
        Double x = null, y = null, z = null;
        boolean areCoordinates = false;
        try {
            x = Double.parseDouble(args[0]);
            y = Double.parseDouble(args[1]);
            z = Double.parseDouble(args[2]);
            areCoordinates = true;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            // If not coordinates, proceed with teleporting to player
        }

        if (areCoordinates) {
            if (args.length == 3) {
                Location location = new Location(player.getWorld(), x, y, z);
                player.teleport(location);
                MessagesCore.TELEPORT_SUCCESS.send(player);
            } else {
                MessagesCore.INVALID_ARGUMENTS.send(player);
            }
        } else {
            Player targetPlayer = Bukkit.getPlayer(args[0]);

            if (targetPlayer == null) {
                MessagesCore.TELEPORT_PLAYER_NOT_FOUND.send(player);
                return;
            }

            if (args.length == 1) {
                player.teleport(targetPlayer);
                MessagesCore.TELEPORT_TO_PLAYER_SUCCESS.send(player);
            } else {
                Player destinationPlayer = Bukkit.getPlayer(args[1]);

                if (destinationPlayer == null) {
                    MessagesCore.TELEPORT_PLAYER_NOT_FOUND.send(player);
                    return;
                }

                targetPlayer.teleport(destinationPlayer);
                MessagesCore.TELEPORT_OTHER_SUCCESS.send(player);
            }
        }
    }

    @Override
    public List<String> tab(CommandSender sendi, String label, String[] args) {
        // Return possible tab completions for this command
        List<String> suggestions = new ArrayList<>();

        if (args.length == 1) {
            String partialName = args[0].toLowerCase();
            for (Player player : Bukkit.getOnlinePlayers()) {
                String playerName = player.getName();
                if (playerName.toLowerCase().startsWith(partialName)) {
                    suggestions.add(playerName);
                }
            }
        }

        return suggestions;
    }

    @Override
    public @NotNull PermissionNode permission() {
        return PermissionNode.COMMAND_TELEPORT;
    }
}
