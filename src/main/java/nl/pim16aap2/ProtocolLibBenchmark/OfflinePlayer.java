package nl.pim16aap2.ProtocolLibBenchmark;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class OfflinePlayer implements org.bukkit.OfflinePlayer
{
    private final String name;
    private final UUID uuid;
    private final long firstPlayed;
    private final long lastPlayed;
    private final boolean op;
    private final boolean banned;
    private final boolean playedBefore;
    private final boolean online;
    private final boolean whitelisted;

    public OfflinePlayer(final String name, final UUID uuid, final long firstPlayed, final long lastPlayed,
                         final boolean op, final boolean banned, final boolean playedBefore, final boolean online,
                         final boolean whitelisted)
    {
        this.name = name;
        this.uuid = uuid;
        this.firstPlayed = firstPlayed;
        this.lastPlayed = lastPlayed;
        this.op = op;
        this.banned = banned;
        this.playedBefore = playedBefore;
        this.online = online;
        this.whitelisted = whitelisted;

    }

    @Override
    public boolean isOnline()
    {
        return online;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public UUID getUniqueId()
    {
        return uuid;
    }

    @Override
    public boolean isBanned()
    {
        return banned;
    }

    @Override
    public boolean isWhitelisted()
    {
        return whitelisted;
    }

    @Override
    public long getFirstPlayed()
    {
        return firstPlayed;
    }

    @Override
    public long getLastPlayed()
    {
        return lastPlayed;
    }

    @Override
    public boolean hasPlayedBefore()
    {
        return playedBefore;
    }

    @Override
    public boolean isOp()
    {
        return op;
    }


    @Override
    public void setWhitelisted(boolean value)
    {

    }

    @Override
    public Player getPlayer()
    {
        return null;
    }

    @Override
    public Location getBedSpawnLocation()
    {
        return null;
    }

    @Override
    public void incrementStatistic(Statistic statistic)
        throws IllegalArgumentException
    {

    }

    @Override
    public void decrementStatistic(Statistic statistic)
        throws IllegalArgumentException
    {

    }

    @Override
    public void incrementStatistic(Statistic statistic, int amount)
        throws IllegalArgumentException
    {

    }

    @Override
    public void decrementStatistic(Statistic statistic, int amount)
        throws IllegalArgumentException
    {

    }

    @Override
    public void setStatistic(Statistic statistic, int newValue)
        throws IllegalArgumentException
    {

    }

    @Override
    public int getStatistic(Statistic statistic)
        throws IllegalArgumentException
    {
        return 0;
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material)
        throws IllegalArgumentException
    {

    }

    @Override
    public void decrementStatistic(Statistic statistic, Material material)
        throws IllegalArgumentException
    {

    }

    @Override
    public int getStatistic(Statistic statistic, Material material)
        throws IllegalArgumentException
    {
        return 0;
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material, int amount)
        throws IllegalArgumentException
    {

    }

    @Override
    public void decrementStatistic(Statistic statistic, Material material, int amount)
        throws IllegalArgumentException
    {

    }

    @Override
    public void setStatistic(Statistic statistic, Material material, int newValue)
        throws IllegalArgumentException
    {

    }

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType)
        throws IllegalArgumentException
    {

    }

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType)
        throws IllegalArgumentException
    {

    }

    @Override
    public int getStatistic(Statistic statistic, EntityType entityType)
        throws IllegalArgumentException
    {
        return 0;
    }

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType, int amount)
        throws IllegalArgumentException
    {

    }

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType, int amount)
    {

    }

    @Override
    public void setStatistic(Statistic statistic, EntityType entityType, int newValue)
    {

    }

    @Override
    public Map<String, Object> serialize()
    {
        return null;
    }

    @Override
    public void setOp(boolean value)
    {

    }
}
