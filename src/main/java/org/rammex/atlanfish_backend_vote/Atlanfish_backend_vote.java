package org.rammex.atlanfish_backend_vote;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.rammex.atlanfish_backend_vote.commands.vtapp;

import java.io.File;
import java.io.IOException;

public final class Atlanfish_backend_vote extends JavaPlugin {

    private FileConfiguration config;
    private File configFile;

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            this.getCommand("voteapp").setExecutor(new vtapp(this));
            new placeholder(this).register();

        } else {

            getLogger().info("Error Plugin PlaceHolderAPI non trouvé, si le bug persiste contacter : .rammex ( sur discord )");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        configFile = new File(getDataFolder(), "data.yml");
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            saveResource("data.yml", false);
        }
        config = YamlConfiguration.loadConfiguration(configFile);

    }

    @Override
    public void onDisable() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfigg(){
        return config;
    }

    public FileConfiguration getSave(){
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
