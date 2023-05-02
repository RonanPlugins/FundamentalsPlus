package com.ronanplugins.fundamentals.references;

import com.ronanplugins.fundamentals.FundamentalsPlus;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public class AsyncHandler {

    public static void async(Runnable runnable) {
        Bukkit.getScheduler().runTaskAsynchronously(FundamentalsPlus.getInstance(), runnable);
    }

    public static void sync(Runnable runnable) {
        Bukkit.getScheduler().runTask(FundamentalsPlus.getInstance(), runnable);
    }

    public static BukkitTask asyncLater(Runnable runnable, long ticks) {
        return Bukkit.getScheduler().runTaskLaterAsynchronously(FundamentalsPlus.getInstance(), runnable, ticks);
    }
    public static BukkitTask syncLater(Runnable runnable, long ticks) {
        return Bukkit.getScheduler().runTaskLater(FundamentalsPlus.getInstance(), runnable, ticks);
    }
}
