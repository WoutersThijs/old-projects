package be.thijswouters.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class CommandHelp extends Command{
	
	public CommandHelp(){
		super("help", "help.use", "?", "h", "he", "hel");
	}
	
	public String message(String[] args) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
		builder.append(args[i]);
		builder.append(" ");
		}
		return builder.toString().trim();
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String [] args){
		sender.sendMessage("->{X}->=={X}_-=<>- Help -<>-_={X}==<-{X}<-");
		sender.sendMessage("/Site     » Shows our website link.");
		sender.sendMessage("/Twitter  » Shows our Twitter link.");
		sender.sendMessage("/Facebook » Shows our Facebook link.");
		sender.sendMessage("/Report   » Shows the report link.");
		sender.sendMessage("/Contact  » Shows the contact link.");
		sender.sendMessage("/Store    » Shows the store link.");
		sender.sendMessage("/Hub      » Sends you to the main server.");
		sender.sendMessage("/Vote     » Vote for us as top server!.");
		sender.sendMessage("->{X}->=={X}_-=<> - BC - <>=-_{X}==<-{X}<-");
	}	
}
