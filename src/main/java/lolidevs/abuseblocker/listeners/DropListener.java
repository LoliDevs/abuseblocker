package lolidevs.abuseblocker.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropListener implements Listener {
    @EventHandler
    public void onDrop(PlayerDropItemEvent event)
    {
        Player p = event.getPlayer();
        if(p.getGameMode().equals(GameMode.CREATIVE))
        {
            event.setCancelled(true);
            p.sendMessage(ChatColor.WHITE + "["+ChatColor.RED+"AbuseBlocker"+ChatColor.WHITE+"] Impossivel dropar no modo CRIATIVO");

        }
    }
    @EventHandler
    public void onPickup(EntityPickupItemEvent event)
    {
        if(event.getEntity() instanceof  Player)
        {
            Player p = (Player) event.getEntity();
            if(p.getGameMode().equals(GameMode.CREATIVE))
            {
                event.setCancelled(true);
            }
        }
    }
}
