package com.sleaky.maceHand.commands;

import com.sleaky.maceHand.staticStorage.MacePlayers;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.util.RGBLike;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MaceHandCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player p)) {
            sender.sendMessage(ChatColor.RED + "You are not a player.");
            return true;
        }

        if (args.length == 0) {
            if (MacePlayers.isPlayerActive(p)) {
                MacePlayers.removePlayer(p);
                p.sendMessage(ChatColor.GREEN + "Mace hand disabled.");
            } else {
                MacePlayers.addPlayer(p);
                p.sendMessage(ChatColor.GREEN + "Mace hand enabled.");
            }
        } else {
            Player player = Bukkit.getPlayer(args[0]);
            if (player != null) {
                if (MacePlayers.isPlayerActive(player)) {
                    MacePlayers.removePlayer(player);
                    p.sendMessage(ChatColor.GREEN + "Mace hand disabled for " + player.getName());
                } else {
                    MacePlayers.addPlayer(player);
                    p.sendMessage(ChatColor.GREEN + "Mace hand enabled for " + player.getName());
                }
            } else {
                p.sendMessage(ChatColor.RED + "Invalid player specified.");
            }
        }
        return true;
    }
}
