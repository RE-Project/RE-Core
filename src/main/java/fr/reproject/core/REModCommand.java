package fr.reproject.core;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

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
            sender.sendMessage(new TextComponentString("List of mod Load in RE: Core"));
            for (int i = 0; i <= 9; i++) {
                sender.sendMessage(new TextComponentString(" id: " + i + " | ModID: " + modid[i] + " | ModName: " + modname[i]));
                if (i >= numberOfMod - 1) {
                    i = 9;
                }
            }
            sender.sendMessage(new TextComponentString("Page 1/" + numberOfPage));
        }

        //disp all page
        if (args.length == 1 && args[0] != null) {
            int max = page(parseInt(args[0]));
            if(parseInt(args[0]) <= numberOfPage) {
                sender.sendMessage(new TextComponentString("List of mod Load in RE: Core"));
                for (int i = max - 9; i <= max; i++) {
                    sender.sendMessage(new TextComponentString("id: " + i + " | ModID: " + modid[i] + " | ModName: " + modname[i]));
                    if (i >= numberOfMod - 1) {
                        i = max;
                    }
                }
                sender.sendMessage(new TextComponentString("Page " + args[0] + "/" + numberOfPage));
            } else {
                sender.sendMessage(new TextComponentString("Invalide Argument"));
            }
        }
    }
}
