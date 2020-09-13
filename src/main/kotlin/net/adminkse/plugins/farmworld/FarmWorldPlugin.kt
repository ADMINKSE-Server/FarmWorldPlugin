package net.adminkse.plugins.farmworld

import net.adminkse.plugins.farmworld.listeners.PlayerChangedWorldListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.player.PlayerChangedWorldEvent

class FarmWorldPlugin : JavaPlugin() {

    override fun onEnable() {
        super.onEnable()

        Bukkit.getPluginManager().registerEvents(PlayerChangedWorldListener(this), this)

        if(this.config.saveToString()=="") this.saveDefaultConfig()

        println("FarmWorldPlugin enabled")
    }

}