package me.roridev.abuseblocker.listeners

import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerAttemptPickupItemEvent

class ItemPickupListener : Listener {
    @EventHandler
    fun ItemPickup(event: PlayerAttemptPickupItemEvent){
        if(event.player.gameMode != GameMode.CREATIVE) return
        event.player.sendActionBar("Cannot PICK items on CREATIVE mode.")
        event.isCancelled = true
    }
}