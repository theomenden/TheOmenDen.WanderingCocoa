package org.theomenden.wandering_cocoa.fabric.client;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.clothconfig2.api.ConfigScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import org.theomenden.wandering_cocoa.Wandering_cocoa;

@Environment(EnvType.CLIENT)
public class ModMenuCompat implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return (parent) -> {
            if(FabricLoader.getInstance().isModLoaded("cloth-config")) {
                return AutoConfig.getConfigScreen(WanderingCocoaConfig.class, parent).get();
            }

            return null;
        };
    }
}
