package org.theomenden.wandering_cocoa;

import java.util.random.RandomGenerator;
import blue.endless.jankson.Comment;
import io.github.jamalam360.jamlib.config.ConfigExtensions;
import io.github.jamalam360.jamlib.config.ConfigManager;
import io.github.jamalam360.jamlib.config.HiddenInGui;
import io.github.jamalam360.jamlib.config.MatchesRegex;
import io.github.jamalam360.jamlib.config.RequiresRestart;
import io.github.jamalam360.jamlib.config.Slider;
import io.github.jamalam360.jamlib.config.WithinRange;
public class WanderingCocoaConfig implements ConfigExtensions<WanderingCocoaConfig> {
    public int costForCocoaBeansInEmeralds = RandomGenerator.getDefault()
                                                            .nextInt(1,3);
    public int costForBrownDyeInCocoaBeans = RandomGenerator.getDefault().nextInt(1, 3);

    public int payoutForBrownDyeTrade = RandomGenerator.getDefault().nextInt(1, 5);

    public long experiencePointsToRewardForTrade = 12;
}
