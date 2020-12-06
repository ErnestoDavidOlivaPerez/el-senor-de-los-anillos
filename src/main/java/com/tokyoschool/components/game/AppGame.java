package com.tokyoschool.components.game;

import com.tokyoschool.database.AppModel;
import com.tokyoschool.domain.BeastType;
import com.tokyoschool.domain.HeroType;
import com.tokyoschool.util.BorderUtil;
import com.tokyoschool.util.ImageUtil;
import com.tokyoschool.util.FontUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import java.io.IOException;
import java.util.ResourceBundle;

public class AppGame extends VBox {

    private final String userData;
    private final AppModel model;
    private GridPane gridPane;
    private Label labelTitle, labelName, labelType, labelLife, labelArmor;
    private TextField tfName;
    private AppHBoxOfSlider sliderLife, sliderArmor;
    private ComboBox<String> comboType;
    private Button addButton;
    private AppGameListView listView;
    private AppGameButtonsOfListView buttonsOfListView;
    private final ResourceBundle res;

    public AppGame(String userData, AppModel model, ResourceBundle res){
        super();
        this.userData = userData;
        this.model = model;
        this.res = res;

        setConfigure();
        initComponents();
    }

    private void setConfigure(){
        setAlignment(Pos.TOP_CENTER);
        setSpacing(10);

        gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(50);
        gridPane.setVgap(10);
        gridPane.setBorder(BorderUtil.getBlack());
    }

    private void initComponents()  {
        labelTitle = new Label("");
        labelTitle = new Label("");
        FontUtil.labelFontAll("Cambria", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 50, Color.WHITE, labelTitle);

        try {
            labelName = new Label(res.getString("name"), ImageUtil.getImageView("caballero (2).png"));
            labelType = new Label(res.getString("type"), ImageUtil.getImageView("guerrero.png"));
            labelLife = new Label(res.getString("life"), ImageUtil.getImageView("salud.png") );
            labelArmor = new Label(res.getString("armor"), ImageUtil.getImageView("armadura.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        DropShadow dropShadow = new DropShadow(10, Color.WHITE);

        tfName = new TextField();
        tfName.setFont(new Font("Geordia", 16));
        tfName.setUserData(userData + "Name");
        tfName.setBackground(Background.EMPTY);
        tfName.setStyle("-fx-text-fill: white");
        tfName.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(7),
                new BorderWidths(2))));
        tfName.setEffect(dropShadow);

        sliderLife = new AppHBoxOfSlider(userData + "SliderLife", userData + "TextFieldLife");
        sliderLife.setSliderMax(300);
        sliderArmor = new AppHBoxOfSlider(userData + "SliderArmor", userData + "TextFieldArmor");
        sliderArmor.setSliderMax(60);

        comboType = new ComboBox<>();
        comboType.setMinWidth(150 + sliderLife.getTextField().getMaxWidth());
        comboType.setMinHeight(35);
        comboType.setEffect(dropShadow);
        comboType.setStyle("-fx-base: black");

        FontUtil.labelFontAll("Cambria" , FontWeight.NORMAL, FontPosture.REGULAR, 30, Color.WHITE, labelName,
                labelType, labelLife, labelArmor);
        FontUtil.textFieldFontAll(16 ,tfName, sliderLife.getTextField(), sliderArmor.getTextField());

        gridPane.add(labelName, 0, 0);
        gridPane.add(labelType, 0, 1);
        gridPane.add(labelLife, 0, 2);
        gridPane.add(labelArmor, 0, 3);
        gridPane.add(tfName, 1, 0);
        gridPane.add(comboType, 1, 1);
        gridPane.add(sliderLife , 1, 2);
        gridPane.add(sliderArmor, 1, 3);

        addButton = new Button(res.getString("add"));
        addButton.setTextFill(Color.WHITE);
        addButton.setBackground(Background.EMPTY);
        addButton.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10),
                new BorderWidths(2))));
        FontUtil.buttonsFontAll(addButton);
        addButton.setUserData(userData + "AddButton");
        addButton.setEffect(dropShadow);
        addButton.setDisable(true);

        listView = new AppGameListView(model,userData + "ListView", res);
        listView.setStyle("-fx-base: black");
        buttonsOfListView = new AppGameButtonsOfListView(userData, res);

        getChildren().addAll(labelTitle, gridPane, addButton, listView, buttonsOfListView);
        comboType.setPrefWidth(tfName.getPrefWidth());
    }

    public void setTitle(String title){
        labelTitle.setText(title);
    }

    public void setComboType(int i){
        if (i == 0){
            HeroType.HUMAN.refreshLanguage(res);
            comboType.getItems().addAll(HeroType.ELF.getType(), HeroType.HOBBIT.getType(), HeroType.HUMAN.getType());
            comboType.getSelectionModel().select(0);
        }

        if (i == 1){
            BeastType.GOBLIN.refreshLanguage(res);
            comboType.getItems().addAll(BeastType.ORC.getType(), BeastType.GOBLIN.getType());
            comboType.getSelectionModel().select(0);
        }
    }

    public Button getAddButton() {
        return addButton;
    }

    public TextField getTfName() {
        return tfName;
    }

    public double getSliderLifeValue() {
        return sliderLife.getSliderValue();
    }

    public double getSliderArmorValue() {
        return sliderArmor.getSliderValue();
    }

    public String getComboType() {
        return comboType.getValue();
    }

    public TextField getTextFieldArmor(){
        return sliderArmor.getTextField();
    }

    public TextField getTextFieldLife(){
        return sliderLife.getTextField();
    }

    public AppGameListView getListView(){return listView;}

    public Slider getSliderArmor(){return sliderArmor.getSlider();}

    public Slider getSliderLife(){return sliderLife.getSlider();}

    public Button getUpButton() {
        return buttonsOfListView.getUp();
    }

    public Button getDownButton() {
        return buttonsOfListView.getDown();
    }

    public Button getDeleteButton() {
        return buttonsOfListView.getDelete();
    }

    public void reset(){
        tfName.setText("");
        comboType.getSelectionModel().select(0);
        sliderArmor.reset();
        sliderLife.reset();
    }

}
