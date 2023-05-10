package com.ronanplugins.fundamentals.references.tasks;

import com.ronanplugins.fundamentals.player.commands.fly.CmdFly;
import com.ronanplugins.fundamentals.references.permissions.PermissionNode;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class TaskJoin {

    public static void run(PlayerJoinEvent e) {
        flight(e.getPlayer());
    }

    private static void flight(Player player) {
        if (PermissionNode.JOIN_FLY.check(player).isPassed()) {
            CmdFly.fly(player, true);
        }
    }

}
