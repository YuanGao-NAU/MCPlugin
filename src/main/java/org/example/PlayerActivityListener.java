package org.example;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Set;

public class PlayerActivityListener implements Listener {
    Set<String> onlinePlayers;

    PlayerActivityListener(Set<String> onlinePlayers) {
        this.onlinePlayers = onlinePlayers;
    }

    @EventHandler
    public void onPlayerJoinServer(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        this.onlinePlayers.add(player.getName());
        if (player.isOp()) {
            event.setJoinMessage(ChatColor.GREEN + "狗管理" + player.getName() + "悄悄地来了!");
        } else {
            event.setJoinMessage(ChatColor.GREEN + "玩家" + player.getName() + "加入了游戏!");
        }
    }

    @EventHandler
    public void onPlayerLeftServer(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        this.onlinePlayers.remove(this.onlinePlayers.remove(player.getName()));
        if (player.isOp()) {
            event.setQuitMessage(ChatColor.GREEN + "狗管理" + player.getName() + "灰溜溜的走了!");
        } else {
            event.setQuitMessage(ChatColor.GREEN + "玩家" + player.getName() + "离开了游戏!");
        }
    }
}
