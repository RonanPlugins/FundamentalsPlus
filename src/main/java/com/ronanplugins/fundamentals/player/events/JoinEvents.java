package com.ronanplugins.fundamentals.player.events;

import com.ronanplugins.fundamentals.references.tasks.TaskJoin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvents implements Listener {

    @EventHandler
    void join(PlayerJoinEvent e) {
        TaskJoin.run(e); //Join Tasks
    }

}
