package com.sleaky.maceHand.listeners;

import org.bukkit.damage.DamageType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Class used to disable fall damage for players who hit the ground after a hand mace hit
 */
public class FallDamage implements Listener {

    private static final Set<UUID> hits = new HashSet<>();

    public static void cancelFall(Player p) {
        hits.add(p.getUniqueId());
    }

    private static void removePlayer(Player p) {
        hits.remove(p.getUniqueId());
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player p)) {
            return;
        }

        if (hits.contains(p.getUniqueId()) && e.getDamageSource().getDamageType() == DamageType.FALL) {
            e.setCancelled(true);
            removePlayer(p);
        }
    }
}
