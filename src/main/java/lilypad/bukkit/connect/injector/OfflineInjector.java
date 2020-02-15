package lilypad.bukkit.connect.injector;

import lilypad.bukkit.connect.util.ReflectionUtils;
import net.minecraft.server.v1_8_R3.DedicatedServer;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import net.minecraft.server.v1_8_R3.ServerConnection;
import org.bukkit.Server;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;

@SuppressWarnings("restriction")
public class OfflineInjector {

	private static Object offlineMinecraftServer;

	public static void inject(Server server) throws Exception {
		Class<OfflineMinecraftServer> offlineMinecraftServerClass = OfflineMinecraftServer.class;
		ReflectionFactory reflectionFactory = ReflectionFactory.getReflectionFactory();
		Constructor<?> objectStructor = Object.class.getDeclaredConstructor();
		Constructor<?> serializeConstructor = reflectionFactory.newConstructorForSerialization(offlineMinecraftServerClass, objectStructor);
		offlineMinecraftServer = serializeConstructor.newInstance();

		DedicatedServer minecraftServer = (DedicatedServer) MinecraftServer.getServer();
		OfflineMinecraftServer offlineMinecraftServer = (OfflineMinecraftServer) OfflineInjector.offlineMinecraftServer;

		offlineMinecraftServer.delegate = minecraftServer;
		offlineMinecraftServer.server = (CraftServer) server;
		offlineMinecraftServer.processQueue = minecraftServer.processQueue;

		ServerConnection serverConnection = minecraftServer.getServerConnection();
		ReflectionUtils.setFinalField(serverConnection.getClass(), serverConnection, "f", offlineMinecraftServer);
	}

	public static Object getOfflineMinecraftServer() {
		return offlineMinecraftServer;
	}
}
