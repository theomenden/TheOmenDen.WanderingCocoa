package org.theomenden.wandering_cocoa.fabric;

import dev.architectury.registry.level.entity.trade.fabric.TradeRegistryImpl;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import org.theomenden.wandering_cocoa.Wandering_cocoa;
import net.fabricmc.api.ModInitializer;

public final class Wandering_cocoaFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Wandering_cocoa.init();
    }
}
