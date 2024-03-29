package org.mod.cwcharges.mixins;

import net.minecraft.item.Item;
import net.minecraft.item.WindChargeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static org.mod.cwcharges.CustomizableWindCharges.getCooldown;

@Mixin(WindChargeItem.class)
public class WindChargeItemMixin {

    @ModifyArg(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/ItemCooldownManager;set(Lnet/minecraft/item/Item;I)V"), method = "use")
    public int use$modify(Item item, int duration) {
        return getCooldown();
    }

}