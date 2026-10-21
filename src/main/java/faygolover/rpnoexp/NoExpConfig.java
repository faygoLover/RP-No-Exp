package faygolover.rpnoexp;

import net.minecraftforge.common.ForgeConfigSpec;

/** Конфиг RP No-Exp: {@code config/rpnoexp-common.toml}. Всё включено по умолчанию. */
public final class NoExpConfig {
    private NoExpConfig() {}

    private static final ForgeConfigSpec.Builder B = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue NO_ORBS;
    public static final ForgeConfigSpec.BooleanValue NO_GAIN;
    public static final ForgeConfigSpec.BooleanValue HIDE_BAR;

    static {
        NO_ORBS = B.comment("Сфер опыта нет: не выпадают из мобов, руд, печей, точила, рыбалки, разведения, пузырьков опыта.",
                        "Сферы, что уже лежат в мире, пропадают при загрузке чанка.")
                .define("no_orbs", true);
        NO_GAIN = B.comment("Опыт и уровни не прибавляются ни от чего (награды квестов, моды, которые дают опыт напрямую).",
                        "Работает только /xp add|set (/experience) — ГМ выдаёт уровни для зачарования и наковальни.",
                        "Тратить опыт можно всегда: стол зачарования и наковальня снимают уровни как обычно.")
                .define("no_gain", true);
        HIDE_BAR = B.comment("Клиент: прятать полоску опыта и число уровня над хотбаром (полоска прыжка лошади остаётся).")
                .define("hide_bar", true);
        SPEC = B.build();
    }
}
