package me.roridev.abuseblocker.listeners

import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerDropItemEvent

class ItemDropListener: Listener {
    @EventHandler
    fun ItemDropped(event : PlayerDropItemEvent){
        if(event.player.gameMode != GameMode.CREATIVE) return
        event.player.sendActionBar("Cannot DROP items on CREATIVE mode.")
        event.isCancelled = true
    }
}