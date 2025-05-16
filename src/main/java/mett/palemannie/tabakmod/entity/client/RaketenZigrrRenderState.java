package mett.palemannie.tabakmod.entity.client;


import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RaketenZigrrRenderState extends EntityRenderState {
    public final ItemStackRenderState item = new ItemStackRenderState();
}
