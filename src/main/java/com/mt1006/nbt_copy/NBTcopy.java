package com.mt1006.nbt_copy;

import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.*;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(NBTcopy.MOD_ID)
public class NBTcopy
{
	public static final String MOD_ID = "nbt_copy";
	public static final String VERSION = "1.0.1";
	public static final String FOR_VERSION = "1.21";
	public static final String FOR_LOADER = "NeoForge";
	public static final Logger LOGGER = LogUtils.getLogger();
	public static boolean skipButton = false;

	public NBTcopy()
	{
		LOGGER.info("{} - Author: mt1006", getFullName());
	}

	public static String getFullName()
	{
		return "NBTcopy v" + VERSION + " for Minecraft " + FOR_VERSION + " [" + FOR_LOADER + "]";
	}

	public static MutableComponent withCopyButton(Component component, String textToCopy)
	{
		ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, textToCopy);
		HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("nbt_copy.copy_button_info"));
		return component.copy().append(Component.translatable("nbt_copy.copy_button")
				.setStyle(Style.EMPTY.withClickEvent(clickEvent).withHoverEvent(hoverEvent)));
	}
}
