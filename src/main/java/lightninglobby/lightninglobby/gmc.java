package lightninglobby.lightninglobby;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class gmc implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player && sender.hasPermission("gamemode.change")) {
            if (command.getName().equalsIgnoreCase("gms")){
                if (args.length == 0){
                    ((Player) sender).setGameMode(GameMode.CREATIVE);
                    sender.sendMessage("Gamemode changed to Creative");
                    return true;
                }
                else
                {
                    for (Player p1 : Bukkit.getOnlinePlayers())
                        if (p1.getName().equalsIgnoreCase(args[0])){
                            p1.setGameMode(GameMode.CREATIVE);
                            p1.sendMessage("Gamemode changed to Creative");
                            sender.sendMessage("Updated " + args[0] + "'s gamemode to Creative");
                            return true;
                        }
                    sender.sendMessage("Player doesn't exist");
                }
            }
        }
        else if (args.length == 1  && sender instanceof ConsoleCommandSender){
            for (Player p1 : Bukkit.getOnlinePlayers()){
                if(p1.getName().equalsIgnoreCase(args[0])){
                    p1.setGameMode(GameMode.CREATIVE);
                    p1.sendMessage("Gamemode changed to Creative");
                    sender.sendMessage("Updated " + args[0] + "'s gamemode to Creative");
                    return true;
                }
            }
        }
        return true;

    }
}
