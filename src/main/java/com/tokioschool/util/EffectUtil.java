package com.tokioschool.util;

import javafx.scene.effect.Bloom;
import javafx.scene.effect.Reflection;

public class EffectUtil {

    public static Bloom getBloom(double threshold){
        Bloom bloom = new Bloom();
        bloom.setThreshold(threshold);
        return bloom;
    }

    public static Reflection getReflection(double bottomOpacity, double fraction){
        Reflection reflection = new Reflection();
        reflection.setBottomOpacity(bottomOpacity);
        reflection.setFraction(fraction);
        return reflection;
    }
}
