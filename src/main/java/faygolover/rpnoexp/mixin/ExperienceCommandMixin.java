package faygolover.rpnoexp.mixin;

import faygolover.rpnoexp.RpNoExp;
import net.minecraft.server.commands.ExperienceCommand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.BiConsumer;

/**
 * {@code /xp add} (и {@code /experience add}) начисляет опыт через {@code giveExperiencePoints}/{@code giveExperienceLevels} —
 * на время вызова открываем начисление. {@code /xp set} событий не шлёт и работает и так.
 */
@Mixin(ExperienceCommand.class)
public abstract class ExperienceCommandMixin {
    @Redirect(method = "addExperience",
            at = @At(value = "INVOKE", target = "Ljava/util/function/BiConsumer;accept(Ljava/lang/Object;Ljava/lang/Object;)V", remap = false))
    private static void rpnoexp$allow(BiConsumer<Object, Object> add, Object player, Object amount) {
        RpNoExp.commandDepth++;
        try {
            add.accept(player, amount);
        } finally {
            RpNoExp.commandDepth--;
        }
    }
}
