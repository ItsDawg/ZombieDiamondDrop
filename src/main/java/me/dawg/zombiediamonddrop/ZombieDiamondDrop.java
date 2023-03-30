package me.dawg.zombiediamonddrop;

import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class ZombieDiamondDrop extends JavaPlugin implements @NotNull Listener {

    @Override
    public void onEnable() {
        // Register the event listener
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public @NotNull ComponentLogger getComponentLogger() {
        return super.getComponentLogger();
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntityType() == EntityType.ZOMBIE) {
            // Check if the zombie was killed by a player
            if (event.getEntity().getKiller() != null) {
                // Add a diamond to the drops
                event.getDrops().add(new ItemStack(Material.DIAMOND));
            }
        }
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
