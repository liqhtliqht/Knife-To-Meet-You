package net.liqht.ktmy.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SharpeningStone extends Item {
    public SharpeningStone(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("§7Used with the Butcher's Cleaver in the off-hand"));
        } else {
            tooltip.add(Text.translatable("§ePress SHIFT for more information"));
        }
    }
}
