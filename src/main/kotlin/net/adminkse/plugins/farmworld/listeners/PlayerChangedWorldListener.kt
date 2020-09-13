package net.adminkse.plugins.farmworld.listeners

import org.bukkit.Location
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChangedWorldEvent
import org.bukkit.plugin.java.JavaPlugin
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class PlayerChangedWorldListener(var plugin: JavaPlugin) : Listener {

    @EventHandler
    public fun onPlayerChangedWorld(event: PlayerChangedWorldEvent) {
        if(event.player.world.name==plugin.config.get("worldName")) {
            println("Event triggered")
            var r = 100 * sqrt(Math.random())
            var a = Math.random() * 2 * Math.PI
            var x = r * cos(a) + event.player.location.x
            var z = r * sin(a) + event.player.location.z
            var y = event.player.world.getHighestBlockYAt(x.toInt(), z.toInt()).toDouble()
            event.player.teleport(Location(event.player.world, x, y, z))
        } else println(event.player.world.name + " : "+plugin.config.get("worldName"))
    }
}