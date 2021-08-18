package old.jss.multioptions;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import jss.multioptions.Metrics;
import jss.multioptions.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class MultiOptions extends JavaPlugin {
  PluginDescriptionFile jss = getDescription();
  
  public String name = this.jss.getName();
  
  public String version = this.jss.getVersion();
  
  public boolean placeholders = false;
  
  private static MultiOptions plugin;
  
  private final CommandSender c = Bukkit.getConsoleSender();
  
  private String statusdebug = getConfig().getString("Config.Debug.Enabled");
  
  public Metrics metrics;
  
 // private Map<String, Lang> availableLocales = new HashMap<>();
  
  public boolean useLegacyversions = false;
  
  public String nmsversion;
  
  public String latestversion;
  
 // public FileManager manager = new FileManager(this);
  
  public String[] folders_list = new String[] { "data", "players", "modules", "test" };
  
  public String[] files_list = new String[] { "config.yml", "worlds.yml", "player.yml", "regions.yml" };
  
  public String[] debug = new String[] { "folder", "config", "yml", "error", "events", "inventory", "commands" };
  
  public File worldfile;
  
  public FileConfiguration worldconfig;
  
  public File playerfile;
  
  public FileConfiguration playerconfig;
  
  public File corefile;
  
  public FileConfiguration coreconfig;
  
  //public Map<String, PlayerManager> pm = new HashMap<>();
  
  public ArrayList<String> isplayer_vanish = new ArrayList<>();
  
  public static final String NMS_VERSION = Bukkit.getServer().getClass().getPackage().getName().substring(23);
  
  public boolean vault = false;
  
  public boolean protocol = false;
  
  public boolean debug_settings = true;
  
  public void onEnable() {
    Utils.setEnabled(this.version);
    Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &b[&eDebug&b]&d " + this.statusdebug);
    saveDefaultConfig();
    plugin = this;
    //DefaultLang.loadConfig(this);
    this.metrics = new Metrics(this, 4583);
    SetupConfig();
    //PluginConfig.LoadDefaultConfig(this);
    //this.manager.createFolder(this.folders_list[0]);
    SetupWorldFile();
    CheckVersion();
    SetupCommands();
    SetupEvents();
    SetupSoftDepends();
   /* UpdateChecker update = new UpdateChecker(this);
    update.Update(this.c);
    if (this.debug_settings) {
      getConfig().set("Config.Debug.Enabled", Boolean.valueOf(true));
    } else if (!this.debug_settings) {
      getConfig().set("Config.Debug.Enabled", Boolean.valueOf(false));
    }*/ 
  }
  
  public void onDisable() {
    Utils.setDisabled(Utils.getPrefix());
    this.metrics = null;
    plugin = null;
    this.placeholders = false;
  }
  
  public boolean getPlaceHolderState() {
    return this.placeholders;
  }
  
  public void SetupCommands() {
    setDebugLoad("load", "Commands", true);
  }
  
  public void SetupEvents() {
    setDebugLoad("load", "Events", true);
    //ClearChatTask cctask = new ClearChatTask(plugin);
   // cctask.runClearChat();
  }
  
  public void SetupConfig() {
    File config = new File(getDataFolder(), "config.yml");
    if (!config.exists()) {
      getConfig().options().copyDefaults(true);
      saveDefaultConfig();
    } 
    setDebug("file", "Config");
  }
  
  public void SetupWorldFile() {
    this.worldfile = new File(getDataFolder() + File.separator + this.folders_list[0], "worlds.yml");
    if (!this.worldfile.exists()) {
      getWorldConfig().options().copyDefaults(true);
      saveWorldConfig();
    } 
  }
  
  public FileConfiguration getWorldConfig() {
    if (this.worldconfig == null)
      reloadWorldConfig(); 
    return this.worldconfig;
  }
  
  public void reloadWorldConfig() {
    if (this.worldconfig == null)
      this.worldfile = new File(getDataFolder() + File.separator + this.folders_list[0], "worlds.yml"); 
    this.worldconfig = (FileConfiguration)YamlConfiguration.loadConfiguration(this.worldfile);
    try {
      Reader defConfigStream = new InputStreamReader(getResource("worlds.yml"), "UTF8");
      if (defConfigStream != null) {
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        this.worldconfig.setDefaults((Configuration)defConfig);
      } 
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } 
  }
  
  public void saveDefaultWorldConfig() {
    if (this.worldfile == null)
      this.worldfile = new File(getDataFolder() + File.separator + this.folders_list[0], "worlds.yml"); 
    if (!this.worldfile.exists())
      saveResource("worlds.yml", false); 
  }
  
  public void saveWorldConfig() {
    if (this.worldconfig == null || this.worldfile == null) {
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + "&c not exist worlds.yml !");
      return;
    } 
    try {
      this.worldconfig.save(this.worldfile);
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void SetupCoreFile() {
    this.corefile = new File(getDataFolder() + File.separator + this.folders_list[0], "core.MultiOptions");
    if (!this.corefile.exists()) {
      getCoreConfig().options().copyDefaults(true);
      saveCoreConfig();
    } 
  }
  
  public FileConfiguration getCoreConfig() {
    if (this.coreconfig == null)
      reloadCoreConfig(); 
    return this.coreconfig;
  }
  
  public void saveCoreConfig() {
    if (this.coreconfig == null || this.corefile == null) {
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + "&c not exist core file !");
      return;
    } 
    try {
      this.coreconfig.save(this.corefile);
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public void reloadCoreConfig() {
    if (this.coreconfig == null)
      this.corefile = new File(getDataFolder() + File.separator + this.folders_list[0], "core.MultiOptions"); 
    this.coreconfig = (FileConfiguration)YamlConfiguration.loadConfiguration(this.corefile);
    try {
      Reader defConfigStream = new InputStreamReader(getResource("core.MultiOptions"), "UTF8");
      if (defConfigStream != null) {
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        this.coreconfig.setDefaults((Configuration)defConfig);
      } 
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } 
  }
  
  public void CheckVersion() {
    this.nmsversion = Bukkit.getServer().getClass().getPackage().getName();
    this.nmsversion = this.nmsversion.substring(this.nmsversion.lastIndexOf(".") + 1);
    if (this.nmsversion.equalsIgnoreCase("v1_8_R1") || this.nmsversion.equalsIgnoreCase("v1_7_")) {
      this.useLegacyversions = true;
      if (this.useLegacyversions) {}
       // Utils.sendColorMessage(this.c, (myLocale()).Check_Version); 
    } 
    if (getConfig().getString("Config.Debug.Enabled").equals("true") && (
      Bukkit.getVersion().contains("1.8") || Bukkit.getVersion().contains("1.9")))
      if (getConfig().getString("Config.Debug.Lang").equals("en")) {
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &bThe server version is " + Bukkit.getVersion());
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &c[Possible mistakes]: ");
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &c- Sound error ");
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &c- Items error ");
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &a[Solution]: ");
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &a- Change the sounds to the corresponding version");
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &a- Change the item id to the corresponding version");
      } else if (getConfig().getString("Config.Debug.Lang").equals("es")) {
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &bLas version del servidor es " + Bukkit.getVersion());
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &c[Posibles Errores]: ");
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &c- Error en los sonidos ");
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &c- Error en los items ");
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &a[Solucion]: ");
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &a- Cambiar el sonidos a la version correspondiente");
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &a- Cambiar la id del item  a la version correspondiente");
      }  
  }
  
  public void setDebug(String type, String name) {
    String str;
    switch ((str = type).hashCode()) {
      case -1268966290:
        if (!str.equals("folder"))
          break; 
        if (getConfig().getString("Config.Debug.Enabled").equals("true"))
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &dLoad Folder: &5" + name); 
        break;
      case 98618:
        if (!str.equals("cmd"))
          break; 
        if (getConfig().getString("Config.Debug").equals("true"))
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &9Cmd: " + name); 
        break;
      case 104433:
        if (!str.equals("inv"))
          break; 
        if (getConfig().getString("Config.Debug.Enabled").equals("true"))
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &dOpen Inventory: " + name); 
        break;
      case 108417:
        if (!str.equals("msg"))
          break; 
        if (getConfig().getString("Config.Debug").equals("true"))
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &dMsg: " + name); 
        break;
      case 3143036:
        if (!str.equals("file"))
          break; 
        if (getConfig().getString("Config.Debug.Enabled").equals("true"))
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &dLoad File: &a" + name + ".yml"); 
        break;
      case 3242771:
        if (!str.equals("item"))
          break; 
        if (getConfig().getString("Config.Debug").equals("true"))
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &dItem: " + name); 
        break;
      case 3314158:
        if (!str.equals("lang"))
          break; 
        if (getConfig().getString("Config.Debug.Enabled").equals("true"))
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &dLoad File: &b" + name); 
        break;
      case 96784904:
        if (!str.equals("error"))
          break; 
        if (getConfig().getString("Config.Debug").equals("true"))
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &cError: &b" + name); 
        break;
    } 
  }
  
  public void setDebugLoad(String type, String name, boolean statu) {
    String str;
    switch ((str = type).hashCode()) {
      case 3327206:
        if (!str.equals("load"))
          break; 
        if (getConfig().getString("Config.Debug.Enabled").equals("true"))
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &c| &b[&eDebug&b] &dLoad " + name + ": &e" + statu); 
        break;
    } 
  }
  
  public void SetupSoftDepends() {
    if (setupPlaceHolderAPI()) {
      Utils.sendColorMessage(this.c, "&e[&b" + this.name + "&e]&5 <|============================================|>");
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &ePlaceHolderAPI:&b" + " " + this.placeholders);
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &eVars PlaceHolderAPI:&a true");
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &bMultiOptionsExpansion:&a true");
      Utils.sendColorMessage(this.c, "&e[&b" + this.name + "&e]&5 <|============================================|>");
     // (new MultiOptionsExpansion(this)).register();
    } else {
      Utils.sendColorMessage(this.c, "&e[&b" + this.name + "&e]&5 <|============================================|>");
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &ePlaceHolderAPI:&b" + " " + this.placeholders);
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &eVars PlaceHolderAPI:&c false");
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " &5<| &bMultiOptionsExpansion:&c false");
      Utils.sendColorMessage(this.c, "&e[&b" + this.name + "&e]&5 <|============================================|>");
    } 
  }
  
  public static void sendPacket(Player player, Object obj) {
    try {
      Object handle = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
      Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
      playerConnection.getClass().getMethod("sendPacket", new Class[] { getNMSClass("Packet") }).invoke(playerConnection, new Object[] { obj });
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public static Class<?> getNMSClass(String packet) {
    String versionserver = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    try {
      return Class.forName("net.minecraft.server." + versionserver + "." + packet);
    } catch (ClassCastException|ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    } 
  }
  
  public static Object getCraftPlayer(Player player) {
    try {
      return Class.forName("org.bukkit.craftbukkit." + NMS_VERSION + ".entity.CraftPlayer").getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
    } catch (IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|NoSuchMethodException|SecurityException|ClassNotFoundException ex) {
      throw new Error(ex);
    } 
  }
  
  public int getPing(Player player) {
    try {
      Object craftplayer = getCraftPlayer(player);
      return ((Integer)craftplayer.getClass().getField("ping").get(craftplayer)).intValue();
    } catch (IllegalArgumentException|IllegalAccessException|NoSuchFieldException|SecurityException ex) {
      throw new Error(ex);
    } 
  }
  
  public static MultiOptions getPlugin() {
    return plugin;
  }
 
  
  public ArrayList<String> getVanishPlayer() {
    return this.isplayer_vanish;
  }
  
  public void setVanishPlayer(String state) {
    this.isplayer_vanish.add(state);
  }
  
  public boolean removeVanishPlayer(String state) {
    if (this.isplayer_vanish.contains(state)) {
      this.isplayer_vanish.remove(state);
      return true;
    } 
    return false;
  }
  
//  public void setPlayerList(HashMap<String, PlayerManager> arg) {
//    this.pm = arg;
//  }
//  
//  public Lang myLocale() {
//    return this.availableLocales.get(Settings.defaultLanguage);
//  }
//  
//  public Map<String, Lang> getAvailableLocales() {
//    return this.availableLocales;
//  }
//  
//  public void setAvailableLocales(HashMap<String, Lang> availableLocales) {
//    this.availableLocales = availableLocales;
//  }
  
  public boolean setupPlaceHolderAPI() {
    if (getServer().getPluginManager().isPluginEnabled("PlaceholderAPI"))
      this.placeholders = true; 
    return this.placeholders;
  }
  
  public void sendTitle(Player player, float fadeIn, float stay, float fadeOut, String title, String subtitle) {
//    //TitleSendEvent titleSendEvent = new TitleSendEvent(player, title, subtitle);
//    Bukkit.getPluginManager().callEvent((Event)titleSendEvent);
//    if (titleSendEvent.isCancelled())
//      return; */
    try {
      if (title != null) {
        title = Utils.color(title);
        Object e = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TIMES").get(null);
        Object chatTitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + title + "\"}" });
        Constructor<?> subtitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class });
        Object titlePacket = subtitleConstructor.newInstance(new Object[] { e, chatTitle, Float.valueOf(fadeIn), Float.valueOf(stay), Float.valueOf(fadeOut) });
        sendPacket(player, titlePacket);
        e = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
        chatTitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + title + "\"}" });
        subtitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent") });
        titlePacket = subtitleConstructor.newInstance(new Object[] { e, chatTitle });
        sendPacket(player, titlePacket);
      } 
      if (subtitle != null) {
        subtitle = Utils.color(subtitle);
        Object e = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TIMES").get(null);
        Object chatSubtitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + title + "\"}" });
        Constructor<?> subtitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class });
        Object subtitlePacket = subtitleConstructor.newInstance(new Object[] { e, chatSubtitle, Float.valueOf(fadeIn), Float.valueOf(stay), Float.valueOf(fadeOut) });
        sendPacket(player, subtitlePacket);
        e = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
        chatSubtitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + subtitle + "\"}" });
        subtitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class });
        subtitlePacket = subtitleConstructor.newInstance(new Object[] { e, chatSubtitle, Float.valueOf(fadeIn), Float.valueOf(stay), Float.valueOf(fadeOut) });
        sendPacket(player, subtitlePacket);
      } 
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
  }
  
  public void clearTitle(Player player) {
    sendTitle(player, 0.0F, 0.0F, 0.0F, "", "");
  }
  
  public void sendActionBar(Player player, String message) {
    if (!player.isOnline())
      return; 
//    ActionBarSendEvent actionBarMessageEvent = new ActionBarSendEvent(player, message);
//    Bukkit.getPluginManager().callEvent((Event)actionBarMessageEvent);
//    if (actionBarMessageEvent.isCancelled())
//      return; 
    try {
      Object packet;
      Class<?> craftPlayerClass = Class.forName("org.bukkit.craftbukkit." + this.nmsversion + ".entity.CraftPlayer");
      Object craftPlayer = craftPlayerClass.cast(player);
      Class<?> packetPlayOutChatClass = Class.forName("net.minecraft.server." + this.nmsversion + ".PacketPlayOutChat");
      Class<?> packetClass = Class.forName("net.minecraft.server." + this.nmsversion + ".Packet");
      if (this.useLegacyversions) {
        Class<?> chatSerializerClass = Class.forName("net.minecraft.server." + this.nmsversion + ".ChatSerializer");
        Class<?> iChatBaseComponentClass = Class.forName("net.minecraft.server." + this.nmsversion + ".IChatBaseComponent");
        Method m3 = chatSerializerClass.getDeclaredMethod("a", new Class[] { String.class });
        Object cbc = iChatBaseComponentClass.cast(m3.invoke(chatSerializerClass, new Object[] { "{\"text\": \"" + message + "\"}" }));
        packet = packetPlayOutChatClass.getConstructor(new Class[] { iChatBaseComponentClass, byte.class }).newInstance(new Object[] { cbc, Byte.valueOf((byte)2) });
      } else {
        Class<?> chatComponentTextClass = Class.forName("net.minecraft.server." + this.nmsversion + ".ChatComponentText");
        Class<?> iChatBaseComponentClass = Class.forName("net.minecraft.server." + this.nmsversion + ".IChatBaseComponent");
        try {
          Class<?> chatMessageTypeClass = Class.forName("net.minecraft.server." + this.nmsversion + ".ChatMessageType");
          Object[] chatMessageTypes = chatMessageTypeClass.getEnumConstants();
          Object chatMessageType = null;
          byte b;
          int i;
          Object[] arrayOfObject1;
          for (i = (arrayOfObject1 = chatMessageTypes).length, b = 0; b < i; ) {
            Object obj = arrayOfObject1[b];
            if (obj.toString().equals("GAME_INFO"))
              chatMessageType = obj; 
            b++;
          } 
          Object chatCompontentText = chatComponentTextClass.getConstructor(new Class[] { String.class }).newInstance(new Object[] { message });
          packet = packetPlayOutChatClass.getConstructor(new Class[] { iChatBaseComponentClass, chatMessageTypeClass }).newInstance(new Object[] { chatCompontentText, chatMessageType });
        } catch (ClassNotFoundException cnfe) {
          Object chatCompontentText = chatComponentTextClass.getConstructor(new Class[] { String.class }).newInstance(new Object[] { message });
          packet = packetPlayOutChatClass.getConstructor(new Class[] { iChatBaseComponentClass, byte.class }).newInstance(new Object[] { chatCompontentText, Byte.valueOf((byte)2) });
        } 
      } 
      Method craftPlayerHandleMethod = craftPlayerClass.getDeclaredMethod("getHandle", new Class[0]);
      Object craftPlayerHandle = craftPlayerHandleMethod.invoke(craftPlayer, new Object[0]);
      Field playerConnectionField = craftPlayerHandle.getClass().getDeclaredField("playerConnection");
      Object playerConnection = playerConnectionField.get(craftPlayerHandle);
      Method sendPacketMethod = playerConnection.getClass().getDeclaredMethod("sendPacket", new Class[] { packetClass });
      sendPacketMethod.invoke(playerConnection, new Object[] { packet });
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
  }
}


/* Location:              C:\Users\Alumno\Downloads\MultiOptions[3.0.0-8A].jar!\jss\multioptions\MultiOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */