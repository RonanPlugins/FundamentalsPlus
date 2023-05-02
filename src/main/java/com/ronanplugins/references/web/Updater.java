package com.ronanplugins.references.web;

import com.ronanplugins.FundamentalsPlus;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Updater {

    public static String updatedVersion = FundamentalsPlus.getInstance().getDescription().getVersion();

    public Updater(FundamentalsPlus pl) {
        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    URLConnection con = new URL(getLatestVersionUrl()).openConnection();
                    updatedVersion = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
                } catch (Exception ex) {
                    Bukkit.getConsoleSender().sendMessage("[FundamentalsPlus] Failed to check for an update on custom maven repository");
                    updatedVersion = pl.getDescription().getVersion();
                }
            }
        }.runTaskAsynchronously(pl);
    }

    private String getLatestVersionUrl() {
        return "https://repo.ronanplugins.com/releases/com/ronanplugins/FundamentalsPlus/"; // Update this URL to point to the correct path for FundamentalsPlus
    }
}