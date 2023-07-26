package org.rammex.atlanfish_backend_vote;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;

public class placeholder extends PlaceholderExpansion {

    private Atlanfish_backend_vote plugin; // This instance is assigned in canRegister()

    public placeholder(Atlanfish_backend_vote plugin){
        this.plugin = plugin;
    }

    @Override
    public String getAuthor() {
        return "rammex";
    }

    @Override
    public String getIdentifier() {
        return "atlanfish";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean persist() {
        return true; // This is required or else PlaceholderAPI will unregister the Expansion on reload
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if(params.equalsIgnoreCase("getvote")) {
            return String.valueOf(plugin.getConfigg().getInt("currentvote"));
        }
        return null; // Placeholder is unknown by the Expansion
    }




}
