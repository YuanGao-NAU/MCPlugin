package org.example;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MCPlugin extends JavaPlugin {
    public Set<String> onlinePlayers = new HashSet();

    public MCPlugin() {
    }

    public void onEnable() {
        Iterator var1 = this.getServer().getOnlinePlayers().iterator();

        while(var1.hasNext()) {
            Player player = (Player)var1.next();
            this.onlinePlayers.add(player.getDisplayName());
        }

        this.getServer().getPluginManager().registerEvents(new PlayerActivityListener(this.onlinePlayers), this);
        super.onEnable();
    }

    public void onDisable() {
        super.onDisable();
    }
}
