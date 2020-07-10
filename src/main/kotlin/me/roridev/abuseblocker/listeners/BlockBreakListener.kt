package me.roridev.abuseblocker.listeners

import me.roridev.abuseblocker.AbuseBlocker
import org.bukkit.GameMode
import org.bukkit.block.Container
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import java.util.logging.Level

class BlockBreakListener : Listener {
    @EventHandler
    fun BlockBreak(event : BlockBreakEvent){
        if(event.player.gameMode != GameMode.CREATIVE) return
        val tileEntity = event.block.state
        if(tileEntity !is Container) return
        if(tileEntity.inventory.contents.filterNotNull().isEmpty()) return
        event.player.sendActionBar("This ${event.block.type.name} has items!")
        event.isCancelled = true
    }
}