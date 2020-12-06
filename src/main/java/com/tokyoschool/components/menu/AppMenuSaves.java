package com.tokyoschool.components.menu;

import com.tokyoschool.util.EffectUtil;
import com.tokyoschool.util.FontUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class AppMenuSaves extends VBox {

    private Label save;

    public AppMenuSaves(){
        super();

        setAlignment(Pos.CENTER);
        initComponents();
    }

    private void initComponents(){
        save = new Label("Nueva Partida...");
        save.setUserData("save");
        save.setPadding(new Insets(20));
        FontUtil.labelFontAll("Cambria", FontWeight.NORMAL, FontPosture.ITALIC, 40, Color.WHITE, save);
        save.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(6),
                new BorderWidths(2))));
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3);
        Reflection reflection = EffectUtil.getReflection(0, 0.6);
        reflection.setTopOffset(15);
        reflection.setInput(dropShadow);
        Bloom bloom = EffectUtil.getBloom(0.9);
        bloom.setInput(reflection);
        save.setEffect(bloom);

        getChildren().addAll(save);
    }

    public Label getSave(){
        return save;
    }
}
