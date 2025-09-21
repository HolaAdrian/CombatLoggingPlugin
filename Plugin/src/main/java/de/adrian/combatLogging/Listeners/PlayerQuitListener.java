package de.adrian.combatLogging.Listeners;

import de.adrian.combatLogging.CombatLogging;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (CombatLogging.playercooldown.containsKey(player.getUniqueId())){
            if (CombatLogging.playercooldown.get(player.getUniqueId()) > 0){
                player.setHealth(0);
                event.setQuitMessage(ChatColor.RED + player.getName() + " quit during combat!");
            }
        }
    }
}
