Server Statistics Application
This application is designed to run in a Minecraft server environment. It offers a simple way for permitted users to view certain server statistics by executing a command.
Features
View Online Players: You can see the number of online players.
View Server RAM Usage: Get information about the server's total and currently used memory.
Commands
The following command is supported:
/serverstats: Displays information about online players and server's memory usage.
Permissions
The following permissions must be set in the server setup:
serverstats.view: This permission allows a player to execute the /serverstats command. Without this permission, the player will be unable to view the server statistics.
Setup
To use this application, you need to install it on your Minecraft server. Please follow the standard procedure for installing third-party plugins on your specific server setup. You'll need to set the serverstats.view permission appropriately for your users.
Code Overview
The important classes in this application are:
ServerStatsCommand: This is the main class implementing the CommandExecutor interface. It defines the /serverstats command.
Here is a general overview of our plugin.yml file:

name: MyPlugin
main: org.test.test.MyPlugin
version: 1.0
commands:
  serverstats:
    description: Displays server stats
api-version: 1.13
permissions:
  serverstats.view:
    description: Allows viewing of server stats
    default: op

The plugin.yml file contains the meta-data for this plugin, declaring its main class, version, commands, api-version, and permissions.