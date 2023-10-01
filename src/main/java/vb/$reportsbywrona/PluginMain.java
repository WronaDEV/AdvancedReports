package vb.$reportsbywrona;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	public static Object GLOBAL_07b408f854675cb48b0e16c6b329ef79;
	public static Object GLOBAL_6a5c9e43f016b70478e9fdf5a7d7a7dc;

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(PlayerDataManager.getInstance(), this);
	}

	@Override
	public void onDisable() {
		PlayerDataManager.getInstance().saveAllData();
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("report")) {
			try {
				if (((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null) == null)) {
					if (PluginMain
							.checkEquals(
									PlayerDataManager.getInstance().getData(
											((org.bukkit.OfflinePlayer) (Object) commandSender), "ActiveReport"),
									((java.lang.Object) (Object) false))) {
						commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&cNie posiadasz otwartych zgloszen! &7Jesli chcesz utworzyc reporta uzyj komendy &a/report create"));
					} else {
						commandSender
								.sendMessage((ChatColor.translateAlternateColorCodes('&', "&fAktywne zgloszenia: &c")
										+ String.valueOf(PlayerDataManager.getInstance().getData(
												((org.bukkit.OfflinePlayer) (Object) commandSender), "ActiveReport"))));
					}
				} else {
					if (!PluginMain.checkEquals((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null),
							"create")) {
						if (!PluginMain.checkEquals(
								(commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null), "close")) {
							if (!PluginMain.checkEquals(
									PlayerDataManager.getInstance().getData(
											((org.bukkit.OfflinePlayer) (Object) commandSender), "ActiveReport"),
									((java.lang.Object) (Object) false))) {
								PluginMain.GLOBAL_07b408f854675cb48b0e16c6b329ef79 = ((java.lang.Object) (Object) ((int) PluginMain
										.createList(commandArgs).size()));
								PluginMain.GLOBAL_6a5c9e43f016b70478e9fdf5a7d7a7dc = " ";
								for (int loopNumber1 = 0; loopNumber1 < ((int) PluginMain.createList(commandArgs)
										.size()); loopNumber1++) {
									double FINAL_loopNumber1 = loopNumber1;
									if (!PluginMain.checkEquals(GLOBAL_07b408f854675cb48b0e16c6b329ef79,
											((java.lang.Object) (Object) (0d)))) {
										PluginMain.GLOBAL_07b408f854675cb48b0e16c6b329ef79 = ((java.lang.Object) (Object) (((Number) GLOBAL_07b408f854675cb48b0e16c6b329ef79)
												.doubleValue() + (1d)));
										PluginMain.GLOBAL_6a5c9e43f016b70478e9fdf5a7d7a7dc = ((String
												.valueOf(GLOBAL_6a5c9e43f016b70478e9fdf5a7d7a7dc)
												+ (commandArgs.length > ((Number) GLOBAL_07b408f854675cb48b0e16c6b329ef79)
														.intValue()
																? commandArgs[((Number) GLOBAL_07b408f854675cb48b0e16c6b329ef79)
																		.intValue()]
																: null))
												+ "");
										org.bukkit.Bukkit.broadcastMessage(
												String.valueOf(GLOBAL_6a5c9e43f016b70478e9fdf5a7d7a7dc));
									}
								}
								org.bukkit.Bukkit.broadcastMessage((((((ChatColor.translateAlternateColorCodes('&',
										"&8[&c")
										+ String.valueOf(PlayerDataManager.getInstance().getData(
												((org.bukkit.OfflinePlayer) (Object) commandSender), "ActiveReport")))
										+ ChatColor.translateAlternateColorCodes('&', "&8] &7"))
										+ ((java.lang.String) commandSender.getName()))
										+ ChatColor.translateAlternateColorCodes('&', " &f"))
										+ String.valueOf(GLOBAL_6a5c9e43f016b70478e9fdf5a7d7a7dc)));
							}
						}
					}
				}
				if (PluginMain.checkEquals((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null),
						"close")) {
					PlayerDataManager.getInstance().setData(((org.bukkit.OfflinePlayer) (Object) commandSender),
							"ActiveReport", ((java.lang.Object) (Object) false));
					commandSender
							.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aPomyslnie zamknieto report!"));
				}
				if (PluginMain.checkEquals((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null),
						"create")) {
					if (PluginMain
							.checkEquals(
									PlayerDataManager.getInstance().getData(
											((org.bukkit.OfflinePlayer) (Object) commandSender), "ActiveReport"),
									((java.lang.Object) (Object) false))) {
						PlayerDataManager.getInstance().setData(((org.bukkit.OfflinePlayer) (Object) commandSender),
								"ActiveReport",
								((((java.lang.String) commandSender.getName()) + "-")
										+ String.valueOf(java.util.concurrent.ThreadLocalRandom.current()
												.nextInt(((int) (0001d)), ((int) (9999d))))));
						new File((((java.lang.String) null) + String.valueOf(PluginMain.getInstance().getDataFolder())),
								(String.valueOf(PlayerDataManager.getInstance()
										.getData(((org.bukkit.OfflinePlayer) (Object) commandSender), "ActiveReport"))
										+ ".report")).createNewFile();
						commandSender.sendMessage((((((ChatColor.translateAlternateColorCodes('&',
								"&fUtworzono report o ID: &c")
								+ String.valueOf(PlayerDataManager.getInstance()
										.getData(((org.bukkit.OfflinePlayer) (Object) commandSender), "ActiveReport")))
								+ "\n")
								+ ChatColor.translateAlternateColorCodes('&',
										"&7Uzyj komendy: &a/report <wiadomosc> &7aby napisac do administracji!"))
								+ "\n")
								+ ChatColor.translateAlternateColorCodes('&',
										"&7Jesli postanowisz zamknac report uzyj komendy: &a/report close")));
					} else {
						commandSender.sendMessage(
								((ChatColor.translateAlternateColorCodes('&', "&cMasz juz otworzony report o ID: &a")
										+ String.valueOf(PlayerDataManager.getInstance().getData(
												((org.bukkit.OfflinePlayer) (Object) commandSender), "ActiveReport")))
										+ ChatColor.translateAlternateColorCodes('&',
												"&c. Jesli chcesz stworzyc nowy report musisz zamknac juz otwarty!")));
					}
				}
				if (PluginMain.checkEquals((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null),
						"info")) {
					commandSender.sendMessage("Soon...!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return true;
	}

	public static void procedure(String procedure, List procedureArgs) throws Exception {
	}

	public static Object function(String function, List functionArgs) throws Exception {
		return null;
	}

	public static List createList(Object obj) {
		if (obj instanceof List) {
			return (List) obj;
		}
		List list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else if (obj instanceof Iterator) {
			((Iterator<?>) obj).forEachRemaining(list::add);
		} else {
			list.add(obj);
		}
		return list;
	}

	public static void createResourceFile(String path) {
		Path file = getInstance().getDataFolder().toPath().resolve(path);
		if (Files.notExists(file)) {
			try (InputStream inputStream = PluginMain.class.getResourceAsStream("/" + path)) {
				Files.createDirectories(file.getParent());
				Files.copy(inputStream, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PluginMain getInstance() {
		return instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void event1(org.bukkit.event.player.PlayerJoinEvent event) throws Exception {
		if ((PlayerDataManager.getInstance().getData(
				((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getPlayer())),
				"ActiveReport") == null)) {
			PlayerDataManager.getInstance().setData(
					((org.bukkit.OfflinePlayer) (Object) ((org.bukkit.entity.Player) event.getPlayer())),
					"ActiveReport", ((java.lang.Object) (Object) false));
		}
	}

	public static boolean checkEquals(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return false;
		}
		return o1 instanceof Number && o2 instanceof Number
				? ((Number) o1).doubleValue() == ((Number) o2).doubleValue()
				: o1.equals(o2);
	}
}
