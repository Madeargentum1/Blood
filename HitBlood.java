package com.blood;

import net.minecraft.server.v1_16_R3.Explosion;
import org.bukkit.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HitBlood implements Listener {
    private final Main m;

    public HitBlood(Main m) {
        this.m = m;
    }

    @EventHandler
    public void hitblood(EntityDamageByEntityEvent e){
        Entity en = e.getEntity();
        World w = en.getWorld();
        Location loc = new Location(
                w,
                en.getLocation().getX(),
                en.getLocation().getY() + 1,
                en.getLocation().getZ()
        );
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(
                255,
                6,
                7),
                1);

        if (en.getType() == EntityType.PLAYER) {
            w.spawnParticle(
                    Particle.REDSTONE,
                    loc,
                    1,
                    dustOptions
            );
        }
    }
    @EventHandler
    public void hpblood(PlayerMoveEvent e){
        Player p = e.getPlayer();
        Location loc = p.getLocation();
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(
                255,
                6,
                7),
                1);
        PotionEffect ptn = new PotionEffect(
                PotionEffectType.SLOW,
                40,
                2);
        PotionEffect ptn2 = new PotionEffect(
                PotionEffectType.SLOW_DIGGING,
                40,
                2
        );
        if (p.getHealth() < 6) {
            p.getWorld().spawnParticle(
                    Particle.REDSTONE,
                    loc,
                    1,
                    dustOptions
            );
            p.addPotionEffect(ptn);
            p.addPotionEffect(ptn2);
        }
    }
}
