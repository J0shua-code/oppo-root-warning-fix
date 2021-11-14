package com.example.warningremover;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;


public class removeWarnings implements IXposedHookLoadPackage {

    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.android.systemui"))
            return;

        findAndHookMethod("com.oppo.systemui.policy.highlight.HighlightController", lpparam.classLoader, "initPersonalHotspotMode", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult((Object) null);
            }
        });

        findAndHookMethod("com.oppo.systemui.policy.highlight.HighlightController", lpparam.classLoader, "initRootMode", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult((Object) null);
            }
        });
    }
}
