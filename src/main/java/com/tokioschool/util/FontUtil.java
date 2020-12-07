package com.tokioschool.util;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FontUtil {

    public static void labelFontAll(String font, FontWeight fontWeight, FontPosture fontPosture , int size
            ,Color color, Label...label){
        List<Label> labels = new ArrayList<>(Arrays.asList(label));

        labels.forEach(label1 -> {
            label1.setFont(Font.font(font, fontWeight, fontPosture, size));
            label1.setTextFill(color);
        });
    }

    public static void textFieldFontAll(int size ,TextField...textField){
        List<TextField> textFields = new ArrayList<>(Arrays.asList(textField));

        textFields.forEach(textField1 -> textField1.setFont(new Font("Geordia", size)));
    }

    public static void buttonsFontAll(Button...button){
        List<Button> buttons = new ArrayList<>(Arrays.asList(button));

        buttons.forEach(button1 -> button1.setFont(new Font("Cambria", 30)));
    }
}
