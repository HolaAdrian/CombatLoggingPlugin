package de.adrian.combatLogging;

import de.adrian.combatLogging.Listeners.PlayerDammageListener;
import de.adrian.combatLogging.Listeners.PlayerQuitListener;
import de.adrian.combatLogging.Utility.Runnable;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class CombatLogging extends JavaPlugin {

    public static CombatLogging main;
    public static HashMap<UUID, Integer> playercooldown = new HashMap<>();
    public static int cooldown;

    @Override
    public void onEnable() {
        main = this;
        playercooldown.clear();
        Runnable.startCounting(main);

        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDammageListener(), this);

        saveDefaultConfig();
        cooldown = getConfig().getInt("cooldown");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
