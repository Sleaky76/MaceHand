package com.sleaky.maceHand.staticStorage;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Container for all players who have the mace hand active
 */
public class MacePlayers {

    private static final List<UUID> macePlayers = new ArrayList<>();

    public static void addPlayer(Player p) {
        macePlayers.add(p.getUniqueId());
    }

    public static void removePlayer(Player p) {
        macePlayers.remove(p.getUniqueId());
    }

    public static boolean isPlayerActive(Player p) {
        return macePlayers.contains(p.getUniqueId());
    }
}
