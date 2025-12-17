package mett.palemannie.tabakmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.entity.custom.SpuckeEntity;
import mett.palemannie.tabakmod.util.TabakmodConfig;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LlamaSpitRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;

public class SpuckeRenderer extends EntityRenderer<SpuckeEntity, LlamaSpitRenderState> {

    private static final Identifier SPUCKE_LOCATION = Identifier.fromNamespaceAndPath(TabakMod.MODID,"textures/entity/spucke/spucke.png");
    private final SpuckeModel model;

    public SpuckeRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new SpuckeModel(context.bakeLayer(SpuckeModel.LAYER_LOCATION));
    }

    @Override
    public void submit(LlamaSpitRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, CameraRenderState cameraRenderState) {

        poseStack.pushPose();
        poseStack.translate(0f, 0.1f, 0f);
        poseStack.mulPose(Axis.YP.rotationDegrees(renderState.yRot));
        poseStack.mulPose(Axis.XP.rotationDegrees(-renderState.xRot + 180f));

        nodeCollector.submitModel(this.model, renderState, poseStack, this.model.renderType(SPUCKE_LOCATION), renderState.lightCoords, OverlayTexture.NO_OVERLAY, renderState.outlineColor, (ModelFeatureRenderer.CrumblingOverlay) null);
        poseStack.popPose();
        super.submit(renderState, poseStack, nodeCollector, cameraRenderState);

        super.submit(renderState, poseStack, nodeCollector, cameraRenderState);
    }

    public LlamaSpitRenderState createRenderState() {
        return new LlamaSpitRenderState();
    }

    public void extractRenderState(SpuckeEntity pEntity, LlamaSpitRenderState renderState, float pPartialTick) {
        super.extractRenderState(pEntity, renderState, pPartialTick);
        renderState.xRot = pEntity.getXRot(pPartialTick);
        renderState.yRot = pEntity.getYRot(pPartialTick);
    }
}