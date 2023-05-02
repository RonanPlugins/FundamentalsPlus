package com.ronanplugins.fundamentals.references.depends;

import com.ronanplugins.fundamentals.FundamentalsPlus;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DepPlaceholderAPI extends PlaceholderExpansion {

    @NotNull
    @Override
    public String getIdentifier() {
        return FundamentalsPlus.getInstance().getDescription().getName().toLowerCase();
    }

    @NotNull
    @Override
    public String getAuthor() {
        return FundamentalsPlus.getInstance().getDescription().getAuthors().get(0);
    }

    @NotNull
    @Override
    public String getVersion() {
        return FundamentalsPlus.getInstance().getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String request) {
        return null;
    }
}
