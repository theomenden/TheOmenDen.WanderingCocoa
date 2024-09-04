package org.theomenden.wanderingcocoa.fabric;

import org.theomenden.wanderingcocoa.WanderingCocoa;
import net.fabricmc.api.ModInitializer;

public final class WanderingCocoaFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        WanderingCocoa.init();
    }
}
