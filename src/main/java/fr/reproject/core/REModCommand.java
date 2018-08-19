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
            sender.sendMessage(new TextComponentString("\u00A7a+--List of mod Load in \u00A72RE: Core\u00A7a--+"));
            for (int i = 0; i <= 9; i++) {
                sender.sendMessage(new TextComponentString("\u00A7aid: \u00A7e" + i + "\u00A7a | ModID: \u00A7e" + modid[i] + "\u00A7a | ModName: \u00A7e" + modname[i]));
                if (i >= numberOfMod - 1) {
                    i = 9;
                }
            }
            if(numberOfPage < 10)
                sender.sendMessage(new TextComponentString("\u00A7a+----------Page 1/" + numberOfPage + "----------+"));
            else sender.sendMessage(new TextComponentString("\u00A7a+----------Page 1/" + numberOfPage + "---------+"));
        }

        //disp all page
        if (args.length == 1 && args[0] != null) {
            int max = page(parseInt(args[0]));
            if(parseInt(args[0]) <= numberOfPage) {
                sender.sendMessage(new TextComponentString("\u00A7a+--List of mod Load in \u00A72RE: Core\u00A7a--+"));
                for (int i = max - 9; i <= max; i++) {
                    sender.sendMessage(new TextComponentString("\u00A7aid: \u00A7e" + i + "\u00A7a | ModID: \u00A7e" + modid[i] + "\u00A7a | ModName: \u00A7e" + modname[i]));
                    if (i >= numberOfMod - 1) {
                        i = max;
                    }
                }
                if(numberOfPage < 10)
                    sender.sendMessage(new TextComponentString("\u00A7a+----------Page 1/" + numberOfPage + "----------+"));
                else sender.sendMessage(new TextComponentString("\u00A7a+----------Page 1/" + numberOfPage + "---------+"));
            } else {
                sender.sendMessage(new TextComponentString("\u00A74Invalide Argument"));
            }
        }
    }
}
