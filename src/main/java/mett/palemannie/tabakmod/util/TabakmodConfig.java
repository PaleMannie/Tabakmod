package mett.palemannie.tabakmod.util;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class TabakmodConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static class Common {
        public final ForgeConfigSpec.DoubleValue spitDamage;
        public final ForgeConfigSpec.BooleanValue spitModel;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("Tabakmod");

            spitDamage = builder
                    .comment("How much damage the spit deals (default: 1.0)")
                    .defineInRange("spitDamage", 1.0, 0.0, Float.MAX_VALUE);

            spitModel = builder.comment("Enables/Disables the player spit model").define("spitModel", true);

            builder.pop();
        }
    }
}