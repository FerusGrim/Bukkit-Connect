package lilypad.bukkit.connect.login;

import lilypad.bukkit.connect.ConnectPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class LoginListener implements Listener {

	private ConnectPlugin connectPlugin;
	private LoginPayloadCache payloadCache;

	public LoginListener(ConnectPlugin connectPlugin, LoginPayloadCache payloadCache) {
		this.connectPlugin = connectPlugin;
		this.payloadCache = payloadCache;
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
		LoginPayload payload = payloadCache.getByName(event.getName());
		if (payload == null) {
			event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, "LilyPad: Internal server error");
			return;
		}
	}
}
