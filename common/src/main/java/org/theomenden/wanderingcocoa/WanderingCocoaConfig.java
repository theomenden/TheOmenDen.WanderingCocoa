package org.theomenden.wanderingcocoa;

import java.util.List;
import java.util.random.RandomGenerator;
import blue.endless.jankson.Comment;
import io.github.jamalam360.jamlib.config.ConfigExtensions;
import io.github.jamalam360.jamlib.config.Slider;
import io.github.jamalam360.jamlib.config.WithinRange;
import net.minecraft.network.chat.Component;

public class WanderingCocoaConfig implements ConfigExtensions<WanderingCocoaConfig> {
    @Comment("How many emeralds you're trading: DEFAULTS between 1 and 3")
    public int costForCocoaBeansInEmeralds = RandomGenerator.getDefault()
                                                            .nextInt(1,3);

    @Comment("How many Cocoa Beans you're trading: DEFAULTS between 1 and 3")
    public int costForBrownDyeInCocoaBeans = RandomGenerator.getDefault().nextInt(1, 3);

    @Comment("How much Brown Dye you'll receive in a trade: DEFAULTS between 1 and 5")
    public int payoutForBrownDyeTrade = RandomGenerator.getDefault().nextInt(1, 5);

    @Comment("How many Cocoa Beans you'll receive in a trade: DEFAULTS between 1 and 5")
    public int payoutForCocoaBeansTrade = RandomGenerator.getDefault().nextInt(1, 5);

    @Comment("How many trades are allowed per Wandering trader for Cocoa Beans: DEFAULTS to 12")
    public int maximumTradesForCocoaBeans = 12;

    @Comment("How many trades are allowed per Wandering Trader for Brown Dye: DEFAULTS to 7")
    public int maximumTradesForBrownDyeTrade = 7;

    @Comment("How many experience points you'll receive in a trade for Cocoa Beans: DEFAULTS to 12")
    public int experiencePointsToRewardForCocoaTrade = 12;

    @Comment("How many experience points you'll receive in a trade for Brown Dye: DEFAULTS to 7")
    public int experiencePointsToRewardForBrownDyeTrade = 12;

    @Comment("The rate of cost increase for the cocoa bean trade: Defaults to 0.05, Max is 0.20")
    @WithinRange(min = 0.05f, max = 0.20f)
    @Slider
    public float tradeCostIncreaseForCocoaBeans = 0.05f;

    @Comment("The rate of cost increase for the Brown dye trade: Defaults to 0.12, Max is 0.20")
    @WithinRange(min = 0.05f, max = 0.20f)
    @Slider
    public float tradeCostIncreaseForBrownDyeTrade = 0.12f;

    @Override
    public List<Link> getLinks() {
        return List.of(
                new Link(Link.DISCORD, "https://discord.gg/MXCdCWeYGb", Component.translatable("config.wandering_cocoa.discord")),
                new Link(Link.GITHUB, "https://github.com/theomenden", Component.translatable("config.wandering_cocoa.github")),
                new Link(Link.GENERIC_LINK, "https://modrinth.com/project/wandering-cocoa", Component.translatable("config.wandering_cocoa.modrinth"))
        );
    }
}
