package com.tokyoschool.util;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderUtil {
    public static Border getBlack(){
        return new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(15), new BorderWidths(3)));
    }
}
