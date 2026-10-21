package faygolover.rpnoexp.client;

import faygolover.rpnoexp.NoExpConfig;
import faygolover.rpnoexp.RpNoExp;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** Полоска опыта с числом уровня не рисуется. Полоска прыжка лошади — отдельный слой, остаётся. */
@Mod.EventBusSubscriber(modid = RpNoExp.MODID, value = Dist.CLIENT)
public final class HideBar {
    private HideBar() {}

    @SubscribeEvent
    public static void onOverlay(RenderGuiOverlayEvent.Pre e) {
        if (e.getOverlay() == VanillaGuiOverlay.EXPERIENCE_BAR.type() && NoExpConfig.HIDE_BAR.get()) e.setCanceled(true);
    }
}
