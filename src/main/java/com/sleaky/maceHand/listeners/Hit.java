package com.sleaky.maceHand.listeners;

import com.sleaky.maceHand.staticStorage.MacePlayers;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Detects when a player hits another player
 */
public class Hit implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player attacker)) {
            return;
        }

        if (attacker.getVelocity().getY() <= 0 && attacker.getFallDistance() > 2
                && attacker.getItemInHand().getType() == Material.AIR
                && MacePlayers.isPlayerActive(attacker)) {
            e.setDamage((e.getDamage() * (1 + Math.abs(attacker.getVelocity().getY()))) + (attacker.getFallDistance() * 1.5));
            FallDamage.cancelFall(attacker);
        }

    }

}
