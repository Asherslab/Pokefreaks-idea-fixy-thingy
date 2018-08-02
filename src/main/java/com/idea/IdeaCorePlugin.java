package com.idea;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.TransformerExclusions({"com.idea."})
@IFMLLoadingPlugin.SortingIndex(1001)
@IFMLLoadingPlugin.MCVersion("1.12.2")
public class IdeaCorePlugin implements IFMLLoadingPlugin
{
    public IdeaCorePlugin()
    {
        MixinBootstrap.init();

        MixinEnvironment.getDefaultEnvironment();

        Mixins.addConfiguration("mixins.idea.json");
    }

    @Override
    public String[] getASMTransformerClass()
    {
        return new String[] {};
    }

    @Override
    public String getModContainerClass()
    {
        return "com.idea.IdeaMod";
    }

    @Nullable
    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(final Map<String, Object> data)
    {

    }

    @Override
    public String getAccessTransformerClass()
    {
        return null;
    }
}
