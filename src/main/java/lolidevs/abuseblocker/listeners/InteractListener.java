package lolidevs.abuseblocker.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {
    @EventHandler
    public void onInventoryOpen (InventoryOpenEvent event)
    {
        HumanEntity p = event.getPlayer();

        if(p.getGameMode().equals(GameMode.CREATIVE))
        {
            if(event.getInventory().getType().equals(InventoryType.CREATIVE)
                    || event.getInventory().getType().equals(InventoryType.ANVIL)
                    || event.getInventory().getType().equals(InventoryType.PLAYER)
                    || event.getInventory().getType().equals(InventoryType.LOOM)
                    || event.getInventory().getType().equals(InventoryType.CARTOGRAPHY)
            )
            {
                event.setCancelled(false);
            }
            else
            {
                event.setCancelled(true);
                p.sendMessage(ChatColor.WHITE+"["+ChatColor.RED+"AbuseBlocker"+ChatColor.WHITE+"] Impossivel abrir " +ChatColor.GRAY+ event.getInventory().getType().name() + ChatColor.WHITE+" no modo CRIATIVO");
            }
        }

    }

    @EventHandler
    public void onEntityInteract (PlayerInteractEntityEvent event)
    {
        Player p = event.getPlayer();
        if(p.getGameMode().equals(GameMode.CREATIVE))
        {
            event.setCancelled(true);
            p.sendMessage(ChatColor.WHITE + "["+ChatColor.RED+"AbuseBlocker"+ChatColor.WHITE+"] Impossivel interagir com "+ChatColor.GRAY + event.getRightClicked().getType().name() + ChatColor.WHITE+" no modo CRIATIVO");
        }
    }

}
