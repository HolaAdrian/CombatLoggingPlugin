package de.adrian.combatLogging.Utility;

import de.adrian.combatLogging.CombatLogging;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Runnable {

    public static void startCounting(CombatLogging pl) {
        Bukkit.getScheduler().runTaskTimer(pl, new java.lang.Runnable() {
            @Override
            public void run() {
                for (UUID uuid : CombatLogging.playercooldown.keySet()) {
                    Integer i = CombatLogging.playercooldown.get(uuid);
                    if (i > 1){
                        i --;
                        CombatLogging.playercooldown.put(uuid, i);
                        if (Bukkit.getPlayer(uuid) != null){
                            Player player = Bukkit.getPlayer(uuid);
                            player.sendActionBar(ChatColor.RED+ "You are in combat for " + i + " seconds!");
                        }
                    }
                    else {
                        i --;
                        if (Bukkit.getPlayer(uuid) != null){
                            Player player = Bukkit.getPlayer(uuid);
                            player.sendActionBar(ChatColor.GREEN + "You are out of cooldown!");
                        }
                        CombatLogging.playercooldown.remove(uuid);

                    }
                }
            }
        }, 0L, 20L);
    }
}
