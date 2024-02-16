# Server Statistics Application

This Minecraft plugin provides a simple way for authorized users (players) to view certain server statistics.

## Features

- **Online Players Count**: Displays the current number of online players.
- **Server RAM Usage**: Provides information about the total memory and the currently used memory of the server.

## Command

- `/serverstats`: This command brings up the server statistics.  

## Permissions

- `serverstats.view`: This permission allows a player to execute the `/serverstats` command. Without this permission, the player will not be able to view the server statistics.

## Setup 

To integrate this plugin, you need to install it onto your Minecraft server following the standard procedures for installing third-party plugins. Make sure to set the `serverstats.view` permission for the respective users.

## Code Details

- The `ServerStatsCommand.java` file implements the `CommandExecutor` interface which essentially defines the `/serverstats` command.

### plugin.yml

The plugin.yml file is a configuration file that contains necessary metadata about the plugin.