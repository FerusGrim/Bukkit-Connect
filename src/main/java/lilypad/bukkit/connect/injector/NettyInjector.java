package lilypad.bukkit.connect.injector;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import lilypad.bukkit.connect.util.ReflectionUtils;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import net.minecraft.server.v1_8_R3.ServerConnection;
import org.bukkit.Server;

import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.util.List;

public class NettyInjector {

	@SuppressWarnings("unchecked")
	public static int injectAndFindPort(Server server, NettyInjectHandler handler) throws Exception {
		ServerConnection serverConnection = MinecraftServer.getServer().getServerConnection();
		Field field = serverConnection.getClass().getDeclaredField("g");
		field.setAccessible(true);
		List<ChannelFuture> channelFutureList = (List<ChannelFuture>) field.get(serverConnection);
		// Iterate ChannelFutures
		int commonPort = 0;
		for(ChannelFuture channelFuture : channelFutureList) {
			// Get ChannelPipeline
			ChannelPipeline channelPipeline = channelFuture.channel().pipeline();
			// Get ServerBootstrapAcceptor
			ChannelHandler serverBootstrapAcceptor = channelPipeline.last();
			// Get Old ChildHandler
			ChannelInitializer<SocketChannel> oldChildHandler = ReflectionUtils.getPrivateField(serverBootstrapAcceptor.getClass(), serverBootstrapAcceptor, ChannelInitializer.class, "childHandler");
			// Set New ChildHandler
			ReflectionUtils.setFinalField(serverBootstrapAcceptor.getClass(), serverBootstrapAcceptor, "childHandler", new NettyChannelInitializer(handler, oldChildHandler));
			// Update Common Port
			commonPort = ((InetSocketAddress) channelFuture.channel().localAddress()).getPort();
		}
		return commonPort;
	}
	
}
