package net.snofox.minecraft.snolib;

import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;

/**
 * Created by Josh on 2018-09-15
 */
public class EntitySubmergedEvent extends EntityEvent {
    private static final HandlerList handlers = new HandlerList();
    private final boolean submerged;

    public EntitySubmergedEvent(final Entity what, final boolean submerged) {
        super(what);
        this.submerged = submerged;
    }

    public boolean isSubmerged() {
        return submerged;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
