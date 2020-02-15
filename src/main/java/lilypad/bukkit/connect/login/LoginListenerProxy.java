package lilypad.bukkit.connect.login;

import net.minecraft.server.v1_8_R3.LoginListener;
import net.minecraft.server.v1_8_R3.NetworkManager;

import java.lang.reflect.Field;

public class LoginListenerProxy {

	private static Class instance;
	private static Field packetListenerField;

	private static Class loginListenerClass;
	private static Field profileField;

	private static Class create() throws Exception {
		instance = UuidInjectorLoginListener.class;

		packetListenerField = NetworkManager.class.getDeclaredField("m");
		packetListenerField.setAccessible(true);

		loginListenerClass = LoginListener.class;
		profileField = LoginListener.class.getDeclaredField("i");
		profileField.setAccessible(true);

		return instance;
	}

	public static synchronized Class get() throws Exception {
		if (instance == null) {
			instance = create();
		}
		return instance;
	}

	public static Field getPacketListenerField() {
		return packetListenerField;
	}

	public static Class getLoginListenerClass() {
		return loginListenerClass;
	}

	public static Field getProfileField() {
		return profileField;
	}

}
