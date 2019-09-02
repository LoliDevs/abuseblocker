package lolidevs.abuseblocker.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

//PS : Its the PlayerDeathListener
public class GrimReaper implements Listener {
    @EventHandler
    public void onDie(PlayerDeathEvent event)
    {
        Player p = event.getEntity();
        if(p.getGameMode().equals(GameMode.CREATIVE))
        {
            event.getDrops().clear();
            event.setDroppedExp(0);
        }
    }
}
