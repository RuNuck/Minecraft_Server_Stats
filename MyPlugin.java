package org.test.test;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class MyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("serverstats")).setExecutor(new ServerStatsCommand());
    }
}
