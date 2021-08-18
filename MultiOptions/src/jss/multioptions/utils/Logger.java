package jss.multioptions.utils;

import jss.multioptions.MultiOptions;

public class Logger {

    private MultiOptions plugin;
    private EventUtils eventsUtils = new EventUtils(plugin);

    public Logger(MultiOptions plugin) {
        super();
        this.plugin = plugin;
    }

    public void Log(Level level, Object object) {
        if (object == null) {
            return;
        }
        switch (level) {
            case ERROR:
                Utils.sendColorMessage(eventsUtils.getConsoleSender(), "&e[&cERROR&e]&7" + " " + object);
                break;
            case WARNING:
                Utils.sendColorMessage(eventsUtils.getConsoleSender(), "&e[&dWARNING&e]&7" + " " + object);
                break;
            case INFO:
                Utils.sendColorMessage(eventsUtils.getConsoleSender(), "&e[&9INFO&e]&7" + " " + object);
                break;
            case OUTLINE:
                Utils.sendColorMessage(eventsUtils.getConsoleSender(), "&e[&bOUTLINE&e]&7" + " " + object);
                break;
            case SUCCESS:
                Utils.sendColorMessage(eventsUtils.getConsoleSender(), "&e[&aSUCCESS&e]&7" + " " + object);
                break;
            case DEBUG:
                Utils.sendColorMessage(eventsUtils.getConsoleSender(), "&e[&dDEBUG&e]&7" + " " + object);
                break;
        }
    }

    public void Log(Level level, String msg) {
        if (msg == null) {
            return;
        }
        switch (level) {
            case ERROR:
                Utils.sendColorMessage(eventsUtils.getConsoleSender(), "&e[&cERROR&e]&7" + " " + msg);
                break;
            case WARNING:
                Utils.sendColorMessage(eventsUtils.getConsoleSender(), "&e[&dWARNING&e]&7" + " " + msg);
                break;
            case INFO:
                Utils.sendColorMessage(eventsUtils.getConsoleSender(), "&e[&9INFO&e]&7" + " " + msg);
                break;
            case OUTLINE:
                Utils.sendColorMessage(eventsUtils.getConsoleSender(), "&e[&bOUTLINE&e]&7" + " " + msg);
                break;
            case SUCCESS:
                Utils.sendColorMessage(eventsUtils.getConsoleSender(), "&e[&aSUCCESS&e]&7" + " " + msg);
                break;
            case DEBUG:
                Utils.sendColorMessage(eventsUtils.getConsoleSender(), "&e[&dDEBUG&e]&7" + " " + msg);
                break;
        }

    }
	
	public enum Level{
		ERROR, WARNING, INFO, SUCCESS, OUTLINE, DEBUG;
	}
	
}