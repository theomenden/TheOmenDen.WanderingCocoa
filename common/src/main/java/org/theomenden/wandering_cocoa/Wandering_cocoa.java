package org.theomenden.wandering_cocoa;

import com.google.common.collect.Lists;
import dev.architectury.registry.level.entity.trade.SimpleTrade;
import dev.architectury.registry.level.entity.trade.TradeRegistry;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.random.RandomGenerator;

public final class Wandering_cocoa {
    public static final String MOD_ID = "wandering_cocoa";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final VillagerTrades.ItemListing CocoaTrade = new SimpleTrade(new ItemCost(Items.EMERALD, RandomGenerator.getDefault().nextInt(1, 3)), Optional.empty(), new ItemStack(Items.COCOA_BEANS, RandomGenerator.getDefault().nextInt(1, 5)), 12, 2, 0.05f);
    private static final VillagerTrades.ItemListing BrownDyeTrade = new SimpleTrade(new ItemCost(Items.COCOA_BEANS, 1), Optional.empty(), new ItemStack(Items.BROWN_DYE, RandomGenerator.getDefault().nextInt(1, 5)), 7, 1, 0.12f);
    public static void init() {
        // Write common init code here.
        LOGGER.info("Adding Cocoa Trades");
        TradeRegistry.registerTradeForWanderingTrader(false, CocoaTrade, BrownDyeTrade);
        LOGGER.info("Cocoa Trades Registered");
    }
}
