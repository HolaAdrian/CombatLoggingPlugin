package de.adrian.combatLogging.Listeners;

import de.adrian.combatLogging.CombatLogging;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerDammageListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent e = (EntityDamageByEntityEvent) event;

            if (e.getEntity() instanceof Player) {
                Player hit = (Player) e.getEntity();

                if (e.getDamager() instanceof Player) {
                    Player damager = (Player) e.getDamager();

                    CombatLogging.playercooldown.put(hit.getUniqueId(), CombatLogging.cooldown);
                    CombatLogging.playercooldown.put(damager.getUniqueId(), CombatLogging.cooldown);

                    hit.sendActionBar(ChatColor.RED+ "You are in combat for" + CombatLogging.cooldown + " seconds!");
                    damager.sendActionBar(ChatColor.RED+ "You are in combat for" + CombatLogging.cooldown + " seconds!");

                }
            }
        }
    }

}
