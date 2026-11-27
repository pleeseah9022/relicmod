package com.example.relicmod.client;

import com.example.relicmod.RelicMod;
import com.example.relicmod.entity.AncientGuardian;
import com.example.relicmod.registry.ModEntities;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RelicMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.ANCIENT_GUARDIAN.get(), GuardianRenderer::new);
    }

    // 바닐라 좀비 모양 모델에 커스텀 텍스처를 입힌 렌더러
    public static class GuardianRenderer extends HumanoidMobRenderer<AncientGuardian, HumanoidModel<AncientGuardian>> {
        private static final ResourceLocation TEXTURE =
                new ResourceLocation(RelicMod.MODID, "textures/entity/ancient_guardian.png");

        public GuardianRenderer(EntityRendererProvider.Context ctx) {
            super(ctx, new HumanoidModel<>(ctx.bakeLayer(ModelLayers.ZOMBIE)), 0.5f);
        }

        @Override
        public ResourceLocation getTextureLocation(AncientGuardian entity) {
            return TEXTURE;
        }
    }
}
