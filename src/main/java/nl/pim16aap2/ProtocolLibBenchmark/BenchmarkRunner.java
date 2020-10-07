package nl.pim16aap2.ProtocolLibBenchmark;

import com.comphenix.protocol.events.SerializedOfflinePlayer;
import com.comphenix.protocol.injector.server.TemporaryPlayerFactory;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class BenchmarkRunner
{
    private static final OfflinePlayer offlinePlayer;

    private static final String name = "playerName";
    private static final UUID uuid = UUID.randomUUID();
    private static final long firstPlayed = 1000L;
    private static final long lastPlayed = firstPlayed + 100L;
    private static final boolean op = false;
    private static final boolean banned = false;
    private static final boolean online = false;
    private static final boolean playedBefore = true;
    private static final boolean whitelisted = true;
    private static final SerializedOfflinePlayer serializedOfflinePlayer;
    private static final TemporaryPlayerFactory temporaryPlayerFactory = new TemporaryPlayerFactory();

    static
    {
        offlinePlayer = new nl.pim16aap2.ProtocolLibBenchmark.OfflinePlayer(name, uuid, firstPlayed, lastPlayed, op,
                                                                            banned, playedBefore, online, whitelisted);
        serializedOfflinePlayer = new SerializedOfflinePlayer(offlinePlayer);
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchmarkGetProxyPlayer()
    {
        serializedOfflinePlayer.getProxyPlayer();
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchmarkForwardedMethods(ProxyPlayer proxyPlayer)
    {
        proxyPlayer.player.getName();
        proxyPlayer.player.getUniqueId();
        proxyPlayer.player.getFirstPlayed();
        proxyPlayer.player.getLastPlayed();
        proxyPlayer.player.isOp();
        proxyPlayer.player.isBanned();
        proxyPlayer.player.hasPlayedBefore();
        proxyPlayer.player.isOnline();
        proxyPlayer.player.isWhitelisted();
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchmarkStubbedMethods(ProxyPlayer proxyPlayer)
    {
        try
        {
            proxyPlayer.player.getDisplayName();
        }
        catch (Throwable t)
        {
            // Ignore
        }
        try
        {
            proxyPlayer.player.getCompassTarget();
        }
        catch (Throwable t)
        {
            // Ignore
        }
        try
        {
            proxyPlayer.player.isSneaking();
        }
        catch (Throwable t)
        {
            // Ignore
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchmarkTemporaryPlayerFactor()
    {
        temporaryPlayerFactory.createTemporaryPlayer(null);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchmarkNativeNew()
    {
        new TestClass(uuid);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchmarkNativeAccess()
    {
        offlinePlayer.getName();
        offlinePlayer.getUniqueId();
        offlinePlayer.getFirstPlayed();
        offlinePlayer.getLastPlayed();
        offlinePlayer.isOp();
        offlinePlayer.isBanned();
        offlinePlayer.hasPlayedBefore();
        offlinePlayer.isOnline();
        offlinePlayer.isWhitelisted();
    }

    public static void main(String[] args)
        throws Exception
    {
        org.openjdk.jmh.Main.main(args);
    }

    @State(Scope.Benchmark)
    public static class ProxyPlayer
    {
        Player player = serializedOfflinePlayer.getProxyPlayer();
    }

    public static class TestClass
    {
        private final UUID uuid;

        public TestClass(final UUID uuid)
        {
            this.uuid = uuid;
        }

        public UUID getUuid()
        {
            return uuid;
        }
    }
}
