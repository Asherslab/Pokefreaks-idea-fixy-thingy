package com.idea;

import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.ModMetadata;

import java.util.Collections;

public class IdeaMod extends DummyModContainer
{

    public static final String ID   = "idea";
    public static final String NAME = "IdeaMod";
    public static final String VERSION  = "1.0-SNAPSHOT";
    private static IdeaMod instance;

    public IdeaMod()
    {
        super(new ModMetadata());
        ModMetadata meta = getMetadata();
        meta.modId = ID;
        meta.name = NAME;
        meta.version = VERSION;
        meta.credits = "";
        meta.authorList = Collections.singletonList("Asherslab");
        meta.description = "Stuff";
        meta.url = "";
        meta.screenshots = new String[0];
        meta.logoFile = "";

        instance = this;
    }

    @Override
    public Disableable canBeDisabled()
    {
        return Disableable.NEVER;
    }

    public static IdeaMod getInstance()
    {
        return instance;
    }

    @Override
    public String getVersion()
    {
        return VERSION;
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    public String getModId()
    {
        return ID;
    }
}
