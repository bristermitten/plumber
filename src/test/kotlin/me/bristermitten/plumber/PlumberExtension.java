package me.bristermitten.plumber;

import be.seeseemelk.mockbukkit.MockBukkit;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class PlumberExtension implements BeforeAllCallback, AfterAllCallback {
    private static boolean loaded = false;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (loaded) return;
        MockBukkit.mock();
        MockBukkit.load(TestPlugin.class);
        loaded = true;
    }

    @Override
    public void afterAll(ExtensionContext context) {
        if (loaded && MockBukkit.isMocked())
            MockBukkit.unload();
    }


}
