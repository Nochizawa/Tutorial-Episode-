package me.Rae.Tutorial;

import org.bukkit.plugin.java.JavaPlugin;

import me.Rae.Tutorial.Events.EventsClass;
import net.md_5.bungee.api.ChatColor;

public class Tutorial extends JavaPlugin {

    private Commands commands = new Commands();

    @Override
    public void onEnable() {
        getCommand(commands.cmd1).setExecutor(commands);
        getCommand(commands.cmd2).setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nTutorial has been Enabled\n\n");
        getServer().getPluginManager().registerEvents(new EventsClass(), this);
        loadConfig();
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nTutorial has been Disabled\n\n");
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}















