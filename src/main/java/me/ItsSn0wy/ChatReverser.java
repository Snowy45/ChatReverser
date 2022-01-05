package me.ItsSn0wy;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatReverser extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        Bukkit.getLogger().info("" +
                "\n=-=-=-=-=-=-=-=-=-=-=" +
                "\nEnabling Chat-Reverser" +
                "\nBy: ItsSn0wy" +
                "\n=-=-=-=-=-=-=-=-=-=-=");
        this.getServer().getPluginManager().registerEvents(this,this);

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("" +
                "\n=-=-=-=-=-=-=-=-=-=-=" +
                "\nDisabling Chat-Reverser" +
                "\nBy: ItsSn0wy" +
                "\n=-=-=-=-=-=-=-=-=-=-=");
    }

    @EventHandler
    public void onChatMessage(AsyncPlayerChatEvent e){
        if (!e.getPlayer().hasPermission("chat.Reverse")) return; //Checking for permission


        String[] input = e.getMessage().split(" ");
        String newMessage = "";

        for(String word : input){
            StringBuilder builder = new StringBuilder();
            builder.append(word);

            builder.reverse();
            if(!newMessage.isEmpty()){
                newMessage += " " + builder;
            } else {
                newMessage += builder;
            }
        }

        e.setMessage(newMessage);


    }

}
