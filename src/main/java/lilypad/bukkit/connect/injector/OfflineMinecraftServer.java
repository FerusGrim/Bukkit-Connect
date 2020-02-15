package lilypad.bukkit.connect.injector;

import com.google.common.util.concurrent.ListenableFuture;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import lilypad.bukkit.connect.util.MethodBypass;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.CommandDispatcher;
import net.minecraft.server.v1_8_R3.CommandObjectiveExecutor;
import net.minecraft.server.v1_8_R3.Convertable;
import net.minecraft.server.v1_8_R3.CrashReport;
import net.minecraft.server.v1_8_R3.DedicatedPlayerList;
import net.minecraft.server.v1_8_R3.DedicatedServer;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EnumDifficulty;
import net.minecraft.server.v1_8_R3.ExceptionWorldConflict;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.ICommandHandler;
import net.minecraft.server.v1_8_R3.ICommandListener;
import net.minecraft.server.v1_8_R3.IDataManager;
import net.minecraft.server.v1_8_R3.IUpdatePlayerListBox;
import net.minecraft.server.v1_8_R3.MojangStatisticsGenerator;
import net.minecraft.server.v1_8_R3.PlayerList;
import net.minecraft.server.v1_8_R3.PropertyManager;
import net.minecraft.server.v1_8_R3.ServerConnection;
import net.minecraft.server.v1_8_R3.ServerPing;
import net.minecraft.server.v1_8_R3.UserCache;
import net.minecraft.server.v1_8_R3.Vec3D;
import net.minecraft.server.v1_8_R3.World;
import net.minecraft.server.v1_8_R3.WorldServer;
import net.minecraft.server.v1_8_R3.WorldSettings;
import net.minecraft.server.v1_8_R3.WorldType;

import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.security.KeyPair;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

public class OfflineMinecraftServer extends DedicatedServer {

    public DedicatedServer delegate = null;

    public OfflineMinecraftServer() {
        super(null);
    }

    private static final MethodBypass initMethod = new MethodBypass("init");
    public boolean init() throws IOException {
        return (boolean) initMethod.handle(delegate);
    }

    public PropertyManager getPropertyManager() {
        return delegate.getPropertyManager();
    }

    public void setGamemode(WorldSettings.EnumGamemode worldsettings_enumgamemode) {
        delegate.setGamemode(worldsettings_enumgamemode);
    }

    public boolean getGenerateStructures() {
        return delegate.getGenerateStructures();
    }

    public WorldSettings.EnumGamemode getGamemode() {
        return delegate.getGamemode();
    }

    public EnumDifficulty getDifficulty() {
        return delegate.getDifficulty();
    }

    public boolean isHardcore() {
        return delegate.isHardcore();
    }

    private static final MethodBypass aMethod = new MethodBypass("a", CrashReport.class);
    public void a(CrashReport crashreport) {
        aMethod.handle(delegate, crashreport);
    }

    public CrashReport b(CrashReport crashreport) {
        return delegate.b(crashreport);
    }

    private static final MethodBypass zMethod = new MethodBypass("z");
    public void z() {
        zMethod.handle(delegate);
    }

    public void B() {
        delegate.B();
    }

    public boolean getAllowNether() {
        return delegate.getAllowNether();
    }

    public boolean getSpawnMonsters() {
        return delegate.getSpawnMonsters();
    }

    public void a(MojangStatisticsGenerator mojangstatisticsgenerator) {
        delegate.a(mojangstatisticsgenerator);
    }

    public void b(MojangStatisticsGenerator mojangStatisticsGenerator) {
        delegate.b(mojangStatisticsGenerator);
    }

    public boolean getSnooperEnabled() {
        return delegate.getSnooperEnabled();
    }

    public void issueCommand(String s, ICommandListener icommandlistener) {
        delegate.issueCommand(s, icommandlistener);
    }

    public void aO() {
        delegate.aO();
    }

    public boolean ae() {
        return delegate.ae();
    }

    public boolean ai() {
        return delegate.ai();
    }

    public DedicatedPlayerList aP() {
        return delegate.aP();
    }

    public int a(String s, int i) {
        return delegate.a(s, i);
    }

    public String a(String s, String s1) {
        return delegate.a(s, s1);
    }

    public boolean a(String s, boolean flag) {
        return delegate.a(s, flag);
    }

    public void a(String s, Object object) {
        delegate.a(s, object);
    }

    public void a() {
        delegate.a();
    }

    public String b() {
        return delegate.b();
    }

    public String E() {
        return delegate.E();
    }

    public int F() {
        return delegate.F();
    }

    public String G() {
        return delegate.G();
    }

    public String getVersion() {
        return delegate.getVersion();
    }

    public int I() {
        return delegate.I();
    }

    public int J() {
        return delegate.J();
    }

    public String[] getPlayers() {
        return delegate.getPlayers();
    }

    public String U() {
        return delegate.U();
    }

    public void aQ() {
        delegate.aQ();
    }

    public boolean as() {
        return delegate.as();
    }

    public String a(WorldSettings.EnumGamemode worldsettings_enumgamemode, boolean flag) {
        return delegate.a(worldsettings_enumgamemode, flag);
    }

    public boolean getEnableCommandBlock() {
        return delegate.getEnableCommandBlock();
    }

    public int getSpawnProtection() {
        return delegate.getSpawnProtection();
    }

    public boolean a(World world, BlockPosition blockposition, EntityHuman entityhuman) {
        return delegate.a(world, blockposition, entityhuman);
    }

    public int p() {
        return delegate.p();
    }

    public void setIdleTimeout(int i) {
        delegate.setIdleTimeout(i);
    }

    public boolean q() {
        return delegate.q();
    }

    public boolean r() {
        return delegate.r();
    }

    public boolean aB() {
        return delegate.aB();
    }

    public int aI() {
        return delegate.aI();
    }

    public int aK() {
        return delegate.aK();
    }

    private static final MethodBypass aRMethod = new MethodBypass("aR");
    public boolean aR() {
        return (boolean) aRMethod.handle(delegate);
    }

    public boolean getOnlineMode() {
        return false;
    }

    public long aS() {
        return delegate.aS();
    }

    public String getPlugins() {
        return delegate.getPlugins();
    }

    public String executeRemoteCommand(final String s) {
        return delegate.executeRemoteCommand(s);
    }

    public boolean isDebugging() {
        return delegate.isDebugging();
    }

    public void info(String s) {
        delegate.info(s);
    }

    public void warning(String s) {
        delegate.warning(s);
    }

    public void g(String s) {
        delegate.g(s);
    }

    public void h(String s) {
        delegate.h(s);
    }

    public PlayerList getPlayerList() {
        return delegate.getPlayerList();
    }

    public void run() {
        delegate.run();
    }

    public ListenableFuture<Object> postToMainThread(Runnable runnable) {
        return delegate.postToMainThread(runnable);
    }

    public boolean isMainThread() {
        return delegate.isMainThread();
    }

    public String getName() {
        return delegate.getName();
    }

    public IChatBaseComponent getScoreboardDisplayName() {
        return delegate.getScoreboardDisplayName();
    }

    public void sendMessage(IChatBaseComponent iChatBaseComponent) {
        delegate.sendMessage(iChatBaseComponent);
    }

    public boolean a(int i, String s) {
        return delegate.a(i, s);
    }

    public BlockPosition getChunkCoordinates() {
        return delegate.getChunkCoordinates();
    }

    public Vec3D d() {
        return delegate.d();
    }

    public World getWorld() {
        return delegate.getWorld();
    }

    public Entity f() {
        return delegate.f();
    }

    public boolean getSendCommandFeedback() {
        return delegate.getSendCommandFeedback();
    }

    public void a(CommandObjectiveExecutor.EnumCommandResult enumCommandResult, int i) {
        delegate.a(enumCommandResult, i);
    }

    private static final MethodBypass hMethod = new MethodBypass("h");
    public CommandDispatcher h() {
        return (CommandDispatcher) hMethod.handle(delegate);
    }

    private static final MethodBypass aStringMethod = new MethodBypass("a", String.class);
    public void a(String s) {
        aStringMethod.handle(delegate, s);
    }

    private static final MethodBypass bMethod = new MethodBypass("b", String.class);
    public synchronized void b(String s) {
        bMethod.handle(delegate, s);
    }

    private static final MethodBypass aLongMethod = new MethodBypass("a", String.class, String.class, long.class, WorldType.class, String.class);
    public void a(String s, String s1, long i, WorldType worldtype, String s2) {
        aLongMethod.handle(delegate, s, s1, i, worldtype, s2);
    }

    private static final MethodBypass kMethod = new MethodBypass("k");
    public void k() {
        kMethod.handle(delegate);
    }

    private static final MethodBypass aStringDataMethod = new MethodBypass("a", String.class, IDataManager.class);
    public void a(String s, IDataManager idatamanager) {
        aStringDataMethod.handle(delegate, s, idatamanager);
    }

    private static final MethodBypass a_Method = new MethodBypass("a_", String.class, int.class);
    public void a_(String s, int i) {
        a_Method.handle(delegate, s, i);
    }

    private static final MethodBypass sMethod = new MethodBypass("s");
    public void s() {
        sMethod.handle(delegate);
    }

    private static final MethodBypass saveChunksMethod = new MethodBypass("saveChunks", boolean.class);
    public void saveChunks(boolean flag) throws ExceptionWorldConflict {
        saveChunksMethod.handle(delegate, saveChunksMethod);
    }

    public void stop() throws ExceptionWorldConflict {
        delegate.stop();
    }

    public String getServerIp() {
        return delegate.getServerIp();
    }

    public void c(String s) {
        delegate.c(s);
    }

    public boolean isRunning() {
        return delegate.isRunning();
    }

    public void safeShutdown() {
        delegate.safeShutdown();
    }

    private static final MethodBypass apingMethod = new MethodBypass("a", ServerPing.class);
    public void a(ServerPing serverping) {
        apingMethod.handle(delegate, serverping);
    }

    public File y() {
        return delegate.y();
    }

    private static final MethodBypass AMethod = new MethodBypass("A");
    public void A() throws ExceptionWorldConflict {
        AMethod.handle(delegate);
    }

    private static final MethodBypass tickSchedulerMethod = new MethodBypass("tickScheduler");
    public void tickScheduler() {
        tickSchedulerMethod.handle(delegate);
    }

    public void a(IUpdatePlayerListBox iupdateplayerlistbox) {
        delegate.a(iupdateplayerlistbox);
    }

    public void C() {
        delegate.C();
    }

    public File d(String s) {
        return delegate.d(s);
    }

    public WorldServer getWorldServer(int i) {
        return delegate.getWorldServer(i);
    }

    public GameProfile[] L() {
        return delegate.L();
    }

    public String getServerModName() {
        return delegate.getServerModName();
    }

    public List<String> tabCompleteCommand(ICommandListener icommandlistener, String s, BlockPosition blockposition) {
        return delegate.tabCompleteCommand(icommandlistener, s, blockposition);
    }

    public boolean O() {
        return delegate.O();
    }

    public ICommandHandler getCommandHandler() {
        return delegate.getCommandHandler();
    }

    public KeyPair Q() {
        return delegate.Q();
    }

    public int R() {
        return delegate.R();
    }

    public void setPort(int i) {
        delegate.setPort(i);
    }

    public String S() {
        return delegate.S();
    }

    public void i(String s) {
        delegate.i(s);
    }

    public boolean T() {
        return delegate.T();
    }

    public void setWorld(String s) {
        delegate.setWorld(s);
    }

    public void a(KeyPair keypair) {
        delegate.a(keypair);
    }

    public void a(EnumDifficulty enumdifficulty) {
        delegate.a(enumdifficulty);
    }

    public boolean X() {
        return delegate.X();
    }

    public void b(boolean flag) {
        delegate.b(flag);
    }

    public void c(boolean flag) {
        delegate.c(flag);
    }

    public Convertable getConvertable() {
        return delegate.getConvertable();
    }

    public void aa() {
        delegate.aa();
    }

    public String getResourcePack() {
        return delegate.getResourcePack();
    }

    public String getResourcePackHash() {
        return delegate.getResourcePackHash();
    }

    public void setResourcePack(String s, String s1) {
        delegate.setResourcePack(s, s1);
    }

    public void setOnlineMode(boolean flag) {
        delegate.setOnlineMode(flag);
    }

    public boolean getSpawnAnimals() {
        return delegate.getSpawnAnimals();
    }

    public void setSpawnAnimals(boolean flag) {
        delegate.setSpawnAnimals(flag);
    }

    public boolean getSpawnNPCs() {
        return delegate.getSpawnNPCs();
    }

    public void setSpawnNPCs(boolean flag) {
        delegate.setSpawnNPCs(flag);
    }

    public boolean getPVP() {
        return delegate.getPVP();
    }

    public void setPVP(boolean flag) {
        delegate.setPVP(flag);
    }

    public boolean getAllowFlight() {
        return delegate.getAllowFlight();
    }

    public void setAllowFlight(boolean flag) {
        delegate.setAllowFlight(flag);
    }

    public String getMotd() {
        return delegate.getMotd();
    }

    public void setMotd(String s) {
        delegate.setMotd(s);
    }

    public int getMaxBuildHeight() {
        return delegate.getMaxBuildHeight();
    }

    public void c(int i) {
        delegate.c(i);
    }

    public boolean isStopped() {
        return delegate.isStopped();
    }

    public void a(PlayerList playerlist) {
        delegate.a(playerlist);
    }

    public ServerConnection getServerConnection() {
        return delegate.getServerConnection();
    }

    public ServerConnection aq() {
        return delegate.aq();
    }

    public int at() {
        return delegate.at();
    }

    public void au() {
        delegate.au();
    }

    public void setForceGamemode(boolean flag) {
        delegate.setForceGamemode(flag);
    }

    public boolean getForceGamemode() {
        return delegate.getForceGamemode();
    }

    public Proxy ay() {
        return delegate.ay();
    }

    public int getIdleTimeout() {
        return delegate.getIdleTimeout();
    }

    public MinecraftSessionService aD() {
        return delegate.aD();
    }

    public GameProfileRepository getGameProfileRepository() {
        return delegate.getGameProfileRepository();
    }

    public UserCache getUserCache() {
        return delegate.getUserCache();
    }

    public ServerPing aG() {
        return delegate.aG();
    }

    public void aH() {
        delegate.aH();
    }

    public Entity a(UUID uuid) {
        return delegate.a(uuid);
    }

    public <V> ListenableFuture<V> a(Callable<V> callable) {
        return delegate.a(callable);
    }

    public long aL() {
        return delegate.aL();
    }

    public Thread aM() {
        return delegate.aM();
    }
}
