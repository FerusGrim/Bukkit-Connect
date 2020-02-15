package lilypad.bukkit.connect.login;

import net.minecraft.server.v1_8_R3.LoginListener;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import net.minecraft.server.v1_8_R3.NetworkManager;

public class UuidInjectorLoginListener extends LoginListener {

    public Runnable injectUuidCallback;

    public UuidInjectorLoginListener(MinecraftServer minecraftserver, NetworkManager networkmanager) {
        super(minecraftserver, networkmanager);
    }

    public void initUUID() {
        injectUuidCallback.run();
    }
}
