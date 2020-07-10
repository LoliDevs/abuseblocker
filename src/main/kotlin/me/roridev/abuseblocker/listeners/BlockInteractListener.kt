package me.roridev.abuseblocker.listeners

import org.bukkit.GameMode
import org.bukkit.block.Container
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class BlockInteractListener : Listener {
    @EventHandler
    fun BlockInteract(event: PlayerInteractEvent){
        if(event.action != Action.RIGHT_CLICK_BLOCK) return
        if(!event.hasBlock()) return
        if(event.player.gameMode != GameMode.CREATIVE) return
        val tileEntity = event.clickedBlock?.state
        if(tileEntity !is Container) return
        event.player.sendActionBar("Cannot open ${tileEntity.block.type} on CREATIVE")
        event.isCancelled = true

    }
}