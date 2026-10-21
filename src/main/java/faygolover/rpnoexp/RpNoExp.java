package faygolover.rpnoexp;

import net.minecraft.world.entity.ExperienceOrb;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

/**
 * RP No-Exp — опыт выключен: нет сфер, опыт ни от чего не прибавляется, полоски опыта нет ({@code client/HideBar}).
 * {@code /xp} работает ({@code mixin/ExperienceCommandMixin}), тратить уровни (зачарование, наковальня) можно всегда.
 * Часть RP-семейства, RP Core не требует.
 */
@Mod(RpNoExp.MODID)
public class RpNoExp {
    public static final String MODID = "rpnoexp";

    /** Сколько вложенных {@code /xp add} сейчас выполняется (только серверный поток). Больше нуля — опыт начислять можно. */
    public static int commandDepth;

    public RpNoExp() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, NoExpConfig.SPEC);
        var bus = MinecraftForge.EVENT_BUS;
        bus.addListener(RpNoExp::onJoin);
        bus.addListener(RpNoExp::onXp);
        bus.addListener(RpNoExp::onLevel);
    }

    /** Любая сфера опыта — новая или загруженная с чанком — в мир не попадает. */
    private static void onJoin(EntityJoinLevelEvent e) {
        if (e.getEntity() instanceof ExperienceOrb && NoExpConfig.NO_ORBS.get()) e.setCanceled(true);
    }

    /** Прибавка очков — только из /xp. Убавлять можно: так тратят опыт моды. */
    private static void onXp(PlayerXpEvent.XpChange e) {
        if (e.getAmount() > 0 && blocked()) e.setCanceled(true);
    }

    /** Прибавка уровней — только из /xp. Убавлять можно: стол зачарования и наковальня снимают уровни этим же путём. */
    private static void onLevel(PlayerXpEvent.LevelChange e) {
        if (e.getLevels() > 0 && blocked()) e.setCanceled(true);
    }

    private static boolean blocked() {
        return commandDepth == 0 && NoExpConfig.NO_GAIN.get();
    }
}
