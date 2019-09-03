package lolidevs.abuseblocker.listeners;

import lolidevs.abuseblocker.utils.Logger;
import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEntityEvent;

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
                Logger.LogOPEN(event.getInventory(),(Player) p);
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
            Logger.LogINTERACT(event.getRightClicked(), p);
        }
    }

}
