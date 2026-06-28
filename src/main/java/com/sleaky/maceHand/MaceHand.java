package com.sleaky.maceHand;

import com.sleaky.maceHand.commands.MaceHandCommand;
import com.sleaky.maceHand.listeners.FallDamage;
import com.sleaky.maceHand.listeners.Hit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MaceHand extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("macehand").setExecutor(new MaceHandCommand());
        getServer().getPluginManager().registerEvents(new FallDamage(), this);
        getServer().getPluginManager().registerEvents(new Hit(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
