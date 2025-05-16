package mett.palemannie.tabakmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.entity.custom.RaketenZigrrEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class RaketenZigrrRenderer extends EntityRenderer<RaketenZigrrEntity, RaketenZigrrRenderState> {

    private static final ResourceLocation ZIG_LOCATION = ResourceLocation.fromNamespaceAndPath(TabakMod.MODID,"textures/entity/raketenzigarre/raketenzigarre.png");
    private final RaketenZigrrModel model;

    public RaketenZigrrRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new RaketenZigrrModel(context.bakeLayer(RaketenZigrrModel.LAYER_LOCATION));
    }


    public void render(RaketenZigrrRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight) {

        pPoseStack.pushPose();

        pPoseStack.translate(0f, 0.4f, 0f);

        pPoseStack.mulPose(Axis.YP.rotationDegrees(pRenderState.yRot));
        pPoseStack.mulPose(Axis.XP.rotationDegrees(-pRenderState.xRot + 180f));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(180f));

        this.model.setupAnim(pRenderState);
        VertexConsumer vertexconsumer = pBufferSource.getBuffer(this.model.renderType(ZIG_LOCATION));
        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY);
        pPoseStack.popPose();
        super.render(pRenderState, pPoseStack, pBufferSource, pPackedLight);
    }

    public RaketenZigrrRenderState createRenderState() {
        return new RaketenZigrrRenderState();
    }

    public void extractRenderState(RaketenZigrrEntity pEntity, RaketenZigrrRenderState renderState, float pPartialTick) {
        super.extractRenderState(pEntity, renderState, pPartialTick);
        renderState.xRot = pEntity.getXRot(pPartialTick);
        renderState.yRot = pEntity.getYRot(pPartialTick);
    }
}