package lilypad.bukkit.connect.util;

import net.minecraft.server.v1_8_R3.DedicatedServer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodBypass {

    private final String name;
    private final Class<?>[] params;

    private Method method = null;

    public MethodBypass(String name, Class<?>... params) {
        this.name = name;
        this.params = params;
    }

    public Object handle(DedicatedServer invoker, Object... params) {
        try {
            return searchForMethod(DedicatedServer.class).invoke(invoker, params);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private Method searchForMethod(Class<?> clazz) throws NoSuchMethodException {
        if (method != null) {
            return method;
        }

        try {
            method = clazz.getDeclaredMethod(this.name, this.params);
            method.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass == null) {
                throw new NoSuchMethodException();
            }
            return searchForMethod(superClass);
        }
        return this.method;
    }
}
