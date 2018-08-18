package fr.reproject.core;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class REModCommand extends CommandBase {

    @Override
    public String getName() {
        return "remod";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "remod <page>";
    }

    private int page(int page) {
        if(page == 1) {
            return 9;
        } else {
            return (9 + 1) * page;
        }
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        String[] modid = REModList.MODID;
        String[] modname = REModList.MODNAME;
        int numberOfMod = REModList.numberOfMod;
        int numberOfPage = numberOfMod / 10 + 1;

        //default page / page 1
        if (args.length == 0) {
            sender.sendMessage(new TextComponentString("§aList of mod Load in §dRE: Core"));
            for (int i = 0; i <= 9; i++) {
                sender.sendMessage(new TextComponentString("§a id: §e" + i + "§a | ModID: §e" + modid[i] + "§a | ModName: §e" + modname[i]));
                if (i >= numberOfMod - 1) {
                    i = 9;
                }
            }
            sender.sendMessage(new TextComponentString("§aPage 1/" + numberOfPage));
        }

        //disp all page
        if (args.length == 1 && args[0] != null) {
            int max = page(parseInt(args[0]));
            if(parseInt(args[0]) <= numberOfPage) {
                sender.sendMessage(new TextComponentString("§aList of mod Load in §dRE: Core"));
                for (int i = max - 9; i <= max; i++) {
                    sender.sendMessage(new TextComponentString("§a id: §e" + i + "§a | ModID: §e" + modid[i] + "§a | ModName: §e" + modname[i]));
                    if (i >= numberOfMod - 1) {
                        i = max;
                    }
                }
                sender.sendMessage(new TextComponentString("§aPage " + args[0] + "/" + numberOfPage));
            } else {
                sender.sendMessage(new TextComponentString("§4Invalide Argument"));
            }
        }


        /*
        if (args.length == 1 && args[0] != null) {
            //page 1
            if (parseInt(args[0]) == 1) {
                sender.sendMessage(new TextComponentString("§aList of mod Load in §dRE: Core"));
                for (int i = 0; i <= 9; i++) {
                    sender.sendMessage(new TextComponentString("§a id: §e" + i + "§a | ModID: §e" + modid[i] + "§a | ModName: §e" + modname[i]));
                    if (i >= numberOfMod - 1) {
                        i = 9;
                    }
                }
                sender.sendMessage(new TextComponentString("§aPage 1/" + numberOfPage));
            }

            //page 2
            if (parseInt(args[0]) == 2) {
                sender.sendMessage(new TextComponentString("§aList of mod Load in §dRE: Core"));
                for (int i = 9; i <= 19; i++) {
                    sender.sendMessage(new TextComponentString("§a id: §e" + i + "§a | ModID: §e" + modid[i] + "§a | ModName: §e" + modname[i]));
                    if (i >= numberOfMod - 1) {
                        i = 19;
                    }
                }
                sender.sendMessage(new TextComponentString("§aPage 2/" + numberOfPage));
            }

            //page 3
            if (parseInt(args[0]) == 3) {
                sender.sendMessage(new TextComponentString("§aList of mod Load in §dRE: Core"));
                for (int i = 19; i <= 29; i++) {
                    sender.sendMessage(new TextComponentString("§a id: §e" + i + "§a | ModID: §e" + modid[i] + "§a | ModName: §e" + modname[i]));
                    if (i >= numberOfMod - 1) {
                        i = 29;
                    }
                }
                sender.sendMessage(new TextComponentString("§aPage 3/" + numberOfPage));
            }

        }*/
    }
}
