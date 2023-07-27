package org.rammex.atlanfish_backend_vote.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.rammex.atlanfish_backend_vote.Atlanfish_backend_vote;

public class vtapp implements CommandExecutor {

    private Atlanfish_backend_vote plugin;

    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();


    public vtapp(Atlanfish_backend_vote plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Player player = (Player) sender;
        int getcurrentvote = plugin.getConfigg().getInt("currentvote");
        plugin.getConfigg().set("currentvote", getcurrentvote+1);
        if(sender instanceof Player){
            player.sendMessage(ChatColor.GREEN+"Vote ajouté");
        }
        plugin.getSave();
        if(pinataspawn(getcurrentvote)){
            String commands = "pinataparty spawn spawn";
            Bukkit.dispatchCommand(console, commands);
            plugin.getConfigg().set("currentvote", 0);
        } else{
            return false;
        }
        return false;
    }


    public boolean pinataspawn(int currentvote){
        if (currentvote > plugin.getConfigg().getInt("voteneeded")) {
            return true;
        } else{
            if (currentvote == plugin.getConfigg().getInt("voteneeded")) {
                return true;
            } else{
                return false;
            }
        }
    }
}
