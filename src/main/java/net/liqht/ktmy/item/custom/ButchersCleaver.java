package net.liqht.ktmy.item.custom;

import net.liqht.ktmy.KTMY;
import net.liqht.ktmy.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class ButchersCleaver extends Item {
    public ButchersCleaver(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        ItemStack mainHand = attacker.getEquippedStack(EquipmentSlot.MAINHAND);
        ItemStack offhand = attacker.getEquippedStack(EquipmentSlot.OFFHAND);
        if (mainHand.getItem() == this && offhand.getItem() == ModItems.SHARPENING_STONE) {
            if (attacker instanceof PlayerEntity attackerPlayer) {
                if (target instanceof PlayerEntity targetPlayer) {
                    if (!attackerPlayer.getItemCooldownManager().isCoolingDown(this)) {
                        offhand.finishUsing(attackerPlayer.getWorld(), attackerPlayer);

                        targetPlayer.playSound(KTMY.BUTCHERS_CLEAVER_SOUND_EVENT, 2.0F, 2.0F);
                        attackerPlayer.playSound(KTMY.BUTCHERS_CLEAVER_SOUND_EVENT, 2.0F, 2.0F);

                        attackerPlayer.addCritParticles(targetPlayer);
                        targetPlayer.kill();
                        attackerPlayer.getItemCooldownManager().set(this, 12000);
                    }
                }
            }
        } else if (mainHand.getItem() == this && offhand.getItem() != ModItems.SHARPENING_STONE) {
            attacker.sendMessage(Text.literal("§cYou need a Sharpening Stone to use this knife!"));
            attacker.stopUsingItem();
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("§7Used for beheading any human foe you wish"));
        } else {
            tooltip.add(Text.translatable("§ePress SHIFT for more information"));
        }
    }
}
