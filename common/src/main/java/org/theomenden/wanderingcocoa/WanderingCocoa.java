package org.theomenden.wanderingcocoa;

import dev.architectury.registry.level.entity.trade.SimpleTrade;
import dev.architectury.registry.level.entity.trade.TradeRegistry;
import io.github.jamalam360.jamlib.JamLib;
import io.github.jamalam360.jamlib.JamLibPlatform;
import io.github.jamalam360.jamlib.config.ConfigManager;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public final class WanderingCocoa {
    public static final String MOD_ID = "wanderingcocoa";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ConfigManager<WanderingCocoaConfig> CONFIG = new ConfigManager<>(MOD_ID, WanderingCocoaConfig.class);
    public static void init() {
        // Write common init code here.
        LOGGER.info("Adding Wandering Trader Trades for '{}' on '{}'",Items.EMERALD + ", " + Items.COCOA_BEANS, JamLibPlatform.getPlatform().name());
        JamLib.checkForJarRenaming(WanderingCocoa.class);

        VillagerTrades.ItemListing cocoaTrade = createTrade(Items.EMERALD,Items.COCOA_BEANS);
        VillagerTrades.ItemListing brownDyeTrade = createTrade(Items.COCOA_BEANS,Items.BROWN_DYE);

        TradeRegistry.registerTradeForWanderingTrader(false, cocoaTrade, brownDyeTrade);
        LOGGER.info("Wandering Trades Registered!");
    }

    private static VillagerTrades.ItemListing createTrade(Item tradingItem, Item rewardItem) {
        return new SimpleTrade(
            createCost(tradingItem),Optional.empty(), createReward(rewardItem), getMaximumTradesFor(rewardItem), getExperiencePointsForTrade(rewardItem), getPriceIncreaseModifierForTrade(rewardItem)
        );
    }

    private static ItemCost createCost(Item tradingItem) {
        var tradeCost = 1;

        if (tradingItem == Items.COCOA_BEANS) {
            tradeCost = CONFIG.get().costForBrownDyeInCocoaBeans;
        } else if(tradingItem == Items.EMERALD) {
            tradeCost = CONFIG.get().costForCocoaBeansInEmeralds;
        }

        return new ItemCost(tradingItem, tradeCost);
    }

    private static ItemStack createReward(Item rewardItem) {
        var rewardAmount = 1;
        if (rewardItem == Items.BROWN_DYE) {
            rewardAmount = CONFIG.get().payoutForBrownDyeTrade;
        } else if (rewardItem == Items.COCOA_BEANS) {
            rewardAmount = CONFIG.get().payoutForCocoaBeansTrade;
        }

        return new ItemStack(rewardItem, rewardAmount);
    }

    private static int getMaximumTradesFor(Item rewardItem) {
        var maxTrades = 1;
        if (rewardItem == Items.BROWN_DYE) {
            maxTrades = CONFIG.get().maximumTradesForBrownDyeTrade;
        } else if (rewardItem == Items.COCOA_BEANS) {
            maxTrades = CONFIG.get().maximumTradesForCocoaBeans;
        }

        return maxTrades;
    }

    private static int getExperiencePointsForTrade(Item rewardItem) {
        var experiencePoints = 1;
        if (rewardItem == Items.BROWN_DYE) {
            experiencePoints = CONFIG.get().experiencePointsToRewardForBrownDyeTrade;
        } else if (rewardItem == Items.COCOA_BEANS) {
            experiencePoints = CONFIG.get().experiencePointsToRewardForCocoaTrade;
        }
        return experiencePoints;
    }

    private static float getPriceIncreaseModifierForTrade(Item rewardItem) {
        var priceIncreaseModifier = 0.05f;
        if (rewardItem == Items.BROWN_DYE) {
            priceIncreaseModifier = CONFIG.get().tradeCostIncreaseForBrownDyeTrade;
        } else if (rewardItem == Items.COCOA_BEANS) {
            priceIncreaseModifier = CONFIG.get().tradeCostIncreaseForCocoaBeans;
        }

        return priceIncreaseModifier;
    }
}
