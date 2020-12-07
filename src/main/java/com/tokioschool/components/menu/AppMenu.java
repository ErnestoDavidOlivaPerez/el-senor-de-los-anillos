package com.tokioschool.components.menu;

import com.tokioschool.util.BorderUtil;
import com.tokioschool.util.EffectUtil;
import com.tokioschool.util.FontUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class AppMenu extends HBox {

    private Label labelButton;
    private final String title;
    private final String userData;

    public AppMenu(String title, String userData){
        super();
        this.title = title;
        this.userData = userData;

        setConfigure();
        initComponents();
    }

    private void setConfigure(){
        setAlignment(Pos.CENTER);
    }

    private void initComponents(){
        labelButton = new Label(title);
        labelButton.setUserData(userData);
        labelButton.setBorder(BorderUtil.getBlack());
        FontUtil.labelFontAll("Cambria", FontWeight.NORMAL, FontPosture.ITALIC, 80, Color.WHITE, labelButton);
        labelButton.setAlignment(Pos.CENTER);
        labelButton.setMinWidth(600);
        labelButton.setPadding(new Insets(20));

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setSpread(0.3);
        Bloom bloom = EffectUtil.getBloom(0.8);
        bloom.setInput(dropShadow);
        labelButton.setEffect(bloom);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(labelButton);

        getChildren().add(stackPane);
    }

    public Label getLabelButton(){return labelButton;}

}
