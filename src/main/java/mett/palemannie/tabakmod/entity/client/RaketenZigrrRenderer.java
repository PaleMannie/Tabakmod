package mett.palemannie.tabakmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mett.palemannie.tabakmod.entity.custom.RaketenZigrrEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;

public class RaketenZigrrRenderer extends EntityRenderer<RaketenZigrrEntity, RaketenZigrrRenderState> {

    private final ItemModelResolver itemModelResolver;

    public RaketenZigrrRenderer(EntityRendererProvider.Context p_174114_) {
        super(p_174114_);
        this.itemModelResolver = p_174114_.getItemModelResolver();
    }

    public void render(RaketenZigrrRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());

            pPoseStack.mulPose(Axis.ZP.rotationDegrees(90.0F));
            pPoseStack.mulPose(Axis.YP.rotationDegrees(-45.0F));
            pPoseStack.mulPose(Axis.XP.rotationDegrees(270.0F));


        pRenderState.item.render(pPoseStack, pBufferSource, pPackedLight, OverlayTexture.NO_OVERLAY);
        pPoseStack.popPose();
        super.render(pRenderState, pPoseStack, pBufferSource, pPackedLight);
    }

    public RaketenZigrrRenderState createRenderState() {
        return new RaketenZigrrRenderState();
    }

    public void extractRenderState(RaketenZigrrEntity p_362725_, RaketenZigrrRenderState p_362243_, float p_362924_) {
        super.extractRenderState(p_362725_, p_362243_, p_362924_);
        this.itemModelResolver.updateForNonLiving(p_362243_.item, p_362725_.getItem(), ItemDisplayContext.GROUND, p_362725_);
    }
}
