package com.example.relicmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GuardianHeartItem extends Item {
    public GuardianHeartItem(Properties props) {
        super(props);
    }

    // 우클릭: 재생 + 흡수 (쿨타임 30초)
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 1));
        }
        player.getCooldowns().addCooldown(this, 600);
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    // 보조 손에 들고 있으면: 저항 I 패시브
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (!level.isClientSide && entity instanceof Player player
                && player.getOffhandItem() == stack && player.tickCount % 20 == 0) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, true, false));
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("item.relicmod.guardian_heart.tooltip1"));
        tooltip.add(Component.translatable("item.relicmod.guardian_heart.tooltip2"));
    }
}
