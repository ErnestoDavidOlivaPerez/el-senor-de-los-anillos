package com.tokioschool.util;

import java.awt.*;

public class WindowUtil {

    public static Dimension getDimension(){
        Toolkit t = Toolkit.getDefaultToolkit();
        return t.getScreenSize();
    }
}
