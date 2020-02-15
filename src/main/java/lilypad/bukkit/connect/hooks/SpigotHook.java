package lilypad.bukkit.connect.hooks;

import org.spigotmc.SpigotConfig;

public class SpigotHook {

      public SpigotHook() {
            SpigotConfig.saveUserCacheOnStopOnly = true;
      }

      public boolean isSpigot() {
            return true;
      }

      public String getWhitelistMessage() {
            return SpigotConfig.whitelistMessage;
      }

      public String getServerFullMessage() {
            return SpigotConfig.serverFullMessage;
      }

}
