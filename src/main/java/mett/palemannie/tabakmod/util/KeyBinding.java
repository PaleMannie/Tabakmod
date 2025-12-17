package mett.palemannie.tabakmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_TABAKMOD = "key.category.tabakmod.spucken";
    public static final String KEY_SPUCKEN = "key.tabakmod.spucken";

    public static final KeyMapping SPUCKTASTE = new KeyMapping(KEY_SPUCKEN, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_T, KeyMapping.Category.register(Identifier.parse(KEY_CATEGORY_TABAKMOD)), 0);
}
