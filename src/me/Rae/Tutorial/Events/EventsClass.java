package me.Rae.Tutorial.Events;

import java.awt.*;
import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;


public class EventsClass implements Listener {

    public String prefix = (ChatColor.BLUE + "Tutorial > ");

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage("");
        player.sendMessage(prefix + ChatColor.GOLD + "Welcome back, " + player.getName());

        //=========================================================

        ItemStack item = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.LIGHT_PURPLE + " Welcome Book");

        ArrayList<String> lore = new ArrayList<String>();

        lore.add(ChatColor.WHITE + "Read this for instructions and rules.");

        meta.setLore(lore);
        item.setItemMeta(meta);

        player.getInventory().setItem(0, item);

        Location spawn = new Location(player.getWorld(), 347, 64, -103);
        player.teleport(spawn);

        //=========================================================

        Firework fw = player.getWorld().spawn(player.getLocation(), Firework.class);
        FireworkMeta fwm = fw.getFireworkMeta();
        FireworkEffect.Builder builder = FireworkEffect.builder();

        fwm.addEffect(builder.flicker(true).withColor(org.bukkit.Color.BLUE).build());
        fwm.addEffect(builder.trail(true).build());
        fwm.addEffect(builder.withFade(org.bukkit.Color.ORANGE).build());
        fwm.setPower(2);
    }
}
