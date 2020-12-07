package com.tokioschool.components.game.listeners;

import com.tokioschool.AppView;
import com.tokioschool.database.AppModel;
import com.tokioschool.domain.BeastType;
import com.tokioschool.domain.HeroType;
import com.tokioschool.domain.Beast;
import com.tokioschool.domain.Hero;
import com.tokioschool.util.Filter;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AppGameActionEvent implements EventHandler<ActionEvent> {

    private final AppView view;
    private final AppModel model;
    private final ResourceBundle res;

    public AppGameActionEvent(AppView view, AppModel model, ResourceBundle res){
        this.view = view;
        this.model = model;
        this.res = res;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        String userData = node.getUserData().toString();

        switch (userData){
            case "heroAddButton":
                String name = view.getAppGameHeroes().getTfName().getText();
                int armor = (int) view.getAppGameHeroes().getSliderArmorValue();
                int life = (int) view.getAppGameHeroes().getSliderLifeValue();
                HeroType heroType = Filter.getHeroTypeFromComboBox(view.getAppGameHeroes().getComboType());
                int pos = view.getAppGameHeroes().getListView().getItems().size();

                Hero hero = new Hero();
                hero.setName(name);
                hero.setArmor(armor);
                hero.setLife(life);
                hero.setType(heroType);
                hero.setPos(pos);
                hero.setRes(res);
                HeroType.HUMAN.refreshLanguage(res);

                Label label = new Label(hero.toString());
                label.setFont(new Font(20));
                view.getAppGameHeroes().getListView().getItems().add(label);
                view.getAppGameHeroes().getListView().getHeroPosDTOS().add(hero);

                if (!view.getAppGameHeroes().getListView().getItems().isEmpty() &&
                        !view.getAppGameBeast().getListView().getItems().isEmpty())
                    view.getAppGameContainer().getAppGameFight().getFight().setDisable(false);
                break;

            case "beastAddButton":
                name = view.getAppGameBeast().getTfName().getText();
                armor = (int) view.getAppGameBeast().getSliderArmorValue();
                life = (int) view.getAppGameBeast().getSliderLifeValue();
                BeastType beastType = Filter.getBeastTypeFromComboBox(view.getAppGameBeast().getComboType());
                pos = view.getAppGameBeast().getListView().getItems().size();

                Beast beast = new Beast();
                beast.setName(name);
                beast.setArmor(armor);
                beast.setLife(life);
                beast.setType(beastType);
                beast.setPos(pos);
                beast.setRes(res);
                BeastType.GOBLIN.refreshLanguage(res);

                label = new Label(beast.toString());
                label.setFont(new Font(20));
                view.getAppGameBeast().getListView().getItems().add(label);
                view.getAppGameBeast().getListView().getBeastPosDTOS().add(beast);

                if (!view.getAppGameHeroes().getListView().getItems().isEmpty() &&
                        !view.getAppGameBeast().getListView().getItems().isEmpty())
                    view.getAppGameContainer().getAppGameFight().getFight().setDisable(false);
                break;

            case "heroUp":
                if (view.getAppGameHeroes().getListView().getSelectionModel().getSelectedIndex() > 0){
                    label = view.getAppGameHeroes().getListView().getSelectionModel().getSelectedItem();
                    int oldIndex = view.getAppGameHeroes().getListView().getSelectionModel().getSelectedIndex();
                    int newIndex = oldIndex - 1;

                    ObservableList<Label> observableList = view.getAppGameHeroes().getListView().getItems();
                    observableList.remove(oldIndex);

                    hero = view.getAppGameHeroes().getListView().getHeroPosDTOS().remove(oldIndex);
                    hero.setPos(newIndex);
                    view.getAppGameHeroes().getListView().getHeroPosDTOS().add(hero.getPos(), hero);

                    label.setText(hero.toString());
                    observableList.add(newIndex, label);

                    label = view.getAppGameHeroes().getListView().getItems().get(oldIndex);
                    hero = view.getAppGameHeroes().getListView().getHeroPosDTOS().get(oldIndex);
                    hero.setPos(oldIndex);
                    label.setText(hero.toString());

                    view.getAppGameHeroes().getListView().requestFocus();
                    view.getAppGameHeroes().getListView().getSelectionModel().select(newIndex);
                    view.getAppGameHeroes().getListView().getFocusModel().focus(newIndex);
                    view.getAppGameHeroes().getListView().scrollTo(newIndex);
                }
                break;

            case "heroDown":
                if (view.getAppGameHeroes().getListView().getSelectionModel().getSelectedIndex() <
                view.getAppGameHeroes().getListView().getItems().size() - 1){
                    label = view.getAppGameHeroes().getListView().getSelectionModel().getSelectedItem();
                    int oldIndex = view.getAppGameHeroes().getListView().getSelectionModel().getSelectedIndex();
                    int newIndex = oldIndex + 1;

                    ObservableList<Label> observableList = view.getAppGameHeroes().getListView().getItems();
                    observableList.remove(oldIndex);

                    hero = view.getAppGameHeroes().getListView().getHeroPosDTOS().remove(oldIndex);
                    hero.setPos(newIndex);
                    view.getAppGameHeroes().getListView().getHeroPosDTOS().add(hero.getPos(), hero);

                    label.setText(hero.toString());
                    observableList.add(newIndex, label);

                    label = view.getAppGameHeroes().getListView().getItems().get(oldIndex);
                    hero = view.getAppGameHeroes().getListView().getHeroPosDTOS().get(oldIndex);
                    hero.setPos(oldIndex);
                    label.setText(hero.toString());

                    view.getAppGameHeroes().getListView().requestFocus();
                    view.getAppGameHeroes().getListView().getSelectionModel().select(newIndex);
                    view.getAppGameHeroes().getListView().getFocusModel().focus(newIndex);
                    view.getAppGameHeroes().getListView().scrollTo(newIndex);
                }

                break;

            case "heroDelete":
                int index = view.getAppGameHeroes().getListView().getSelectionModel().getSelectedIndex();
                int size = view.getAppGameHeroes().getListView().getHeroPosDTOS().size();

                for (int i = index; i < size; i++){
                    hero = view.getAppGameHeroes().getListView().getHeroPosDTOS().get(i);
                    view.getAppGameHeroes().getListView().getHeroPosDTOS().get(i).setPos(hero.getPos() - 1);

                    view.getAppGameHeroes().getListView().getItems().get(i).setText(hero.toString());
                }

                view.getAppGameHeroes().getListView().getHeroPosDTOS().remove(index);
                view.getAppGameHeroes().getListView().getItems().remove(index);

                if (view.getAppGameHeroes().getListView().getItems().isEmpty()){
                    view.getAppGameHeroes().getUpButton().setDisable(true);
                    view.getAppGameHeroes().getDownButton().setDisable(true);
                    view.getAppGameHeroes().getDeleteButton().setDisable(true);
                } else {
                    view.getAppGameHeroes().getListView().requestFocus();
                }

                if (view.getAppGameHeroes().getListView().getItems().isEmpty()  ||
                        view.getAppGameBeast().getListView().getItems().isEmpty())
                    view.getAppGameContainer().getAppGameFight().getFight().setDisable(true);
                break;
            case "beastUp":
                if (view.getAppGameBeast().getListView().getSelectionModel().getSelectedIndex() > 0) {
                    label = view.getAppGameBeast().getListView().getSelectionModel().getSelectedItem();
                    int oldIndex = view.getAppGameBeast().getListView().getSelectionModel().getSelectedIndex();
                    int newIndex = oldIndex - 1;

                    ObservableList<Label> observableList = view.getAppGameBeast().getListView().getItems();
                    observableList.remove(oldIndex);

                    beast = view.getAppGameBeast().getListView().getBeastPosDTOS().remove(oldIndex);
                    beast.setPos(newIndex);
                    view.getAppGameBeast().getListView().getBeastPosDTOS().add(beast.getPos(), beast);

                    label.setText(beast.toString());
                    observableList.add(newIndex, label);

                    label = view.getAppGameBeast().getListView().getItems().get(oldIndex);
                    beast = view.getAppGameBeast().getListView().getBeastPosDTOS().get(oldIndex);
                    beast.setPos(oldIndex);
                    label.setText(beast.toString());

                    view.getAppGameBeast().getListView().requestFocus();
                    view.getAppGameBeast().getListView().getSelectionModel().select(newIndex);
                    view.getAppGameBeast().getListView().getFocusModel().focus(newIndex);
                    view.getAppGameBeast().getListView().scrollTo(newIndex);
                }
                break;

            case "beastDown":
                if (view.getAppGameBeast().getListView().getSelectionModel().getSelectedIndex() <
                        view.getAppGameBeast().getListView().getItems().size() - 1) {
                    label = view.getAppGameBeast().getListView().getSelectionModel().getSelectedItem();
                    int oldIndex = view.getAppGameBeast().getListView().getSelectionModel().getSelectedIndex();
                    int newIndex = oldIndex + 1;

                    ObservableList<Label> observableList = view.getAppGameBeast().getListView().getItems();
                    observableList.remove(oldIndex);

                    beast = view.getAppGameBeast().getListView().getBeastPosDTOS().remove(oldIndex);
                    beast.setPos(newIndex);
                    view.getAppGameBeast().getListView().getBeastPosDTOS().add(beast.getPos(), beast);

                    label.setText(beast.toString());
                    observableList.add(newIndex, label);

                    label = view.getAppGameBeast().getListView().getItems().get(oldIndex);
                    beast = view.getAppGameBeast().getListView().getBeastPosDTOS().get(oldIndex);
                    beast.setPos(oldIndex);
                    label.setText(beast.toString());

                    view.getAppGameBeast().getListView().requestFocus();
                    view.getAppGameBeast().getListView().getSelectionModel().select(newIndex);
                    view.getAppGameBeast().getListView().getFocusModel().focus(newIndex);
                    view.getAppGameBeast().getListView().scrollTo(newIndex);
                }
                break;

            case "beastDelete":
                index = view.getAppGameBeast().getListView().getSelectionModel().getSelectedIndex();
                size = view.getAppGameBeast().getListView().getBeastPosDTOS().size();

                for (int i = index; i < size; i++){
                    beast = view.getAppGameBeast().getListView().getBeastPosDTOS().get(i);
                    view.getAppGameBeast().getListView().getBeastPosDTOS().get(i).setPos(beast.getPos() - 1);

                    view.getAppGameBeast().getListView().getItems().get(i).setText(beast.toString());
                }

                view.getAppGameBeast().getListView().getBeastPosDTOS().remove(index);
                view.getAppGameBeast().getListView().getItems().remove(index);

                if (view.getAppGameBeast().getListView().getItems().isEmpty()){
                    view.getAppGameBeast().getUpButton().setDisable(true);
                    view.getAppGameBeast().getDownButton().setDisable(true);
                    view.getAppGameBeast().getDeleteButton().setDisable(true);
                } else {
                    view.getAppGameBeast().getListView().requestFocus();
                }

                if (view.getAppGameHeroes().getListView().getItems().isEmpty()  ||
                        view.getAppGameBeast().getListView().getItems().isEmpty())
                    view.getAppGameContainer().getAppGameFight().getFight().setDisable(true);
                break;

            case "fight":
                int countTurn = 1;
                try {
                    countTurn = model.getTurn();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                int totalHeroes = view.getAppGameHeroes().getListView().getItems().size();
                int totalBeast = view.getAppGameBeast().getListView().getItems().size();
                int maxFight = totalHeroes;

                List<Integer> removesHeroes = new ArrayList<>();
                List<Integer> removesBeasts = new ArrayList<>();
                String textArea;
                textArea = view.getAppGameContainer().getAppGameFight().getTextArea().getText().concat(res.getString("turn") +
                        countTurn + "\n");
                view.getAppGameContainer().getAppGameFight().getTextArea().setText(textArea);

                if (totalHeroes > totalBeast)
                    maxFight = totalBeast;

                for (int i  = 0; i < maxFight; i++) {
                    hero = view.getAppGameHeroes().getListView().getHeroPosDTOS().get(i);
                    beast = view.getAppGameBeast().getListView().getBeastPosDTOS().get(i);

                    int attackHero;
                    int attackBeast;

                    int heroOldLife = hero.getLife();
                    int beastOldLife = beast.getLife();
                    armor = hero.getArmor();

                    if (hero.getType() == HeroType.ELF && beast.getType() == BeastType.ORC) {
                        attackHero = (int) Math.floor(Math.random() * 100) + 10;
                        attackBeast = (int) Math.floor(Math.random() * 90);
                        hero.setArmor(90 * hero.getArmor() / 100);

                    } else if (hero.getType() == HeroType.HOBBIT && beast.getType() == BeastType.GOBLIN) {
                        attackHero = (int) Math.floor(Math.random() * 100) - 5;
                        attackBeast = (int) Math.floor(Math.random() * 90);

                    } else if (beast.getType() == BeastType.ORC) {
                        attackHero = (int) Math.floor(Math.random() * 100);
                        attackBeast = (int) Math.floor(Math.random() * 90);
                        hero.setArmor(90 * hero.getArmor() / 100);
                    } else {
                        attackHero = (int) Math.floor(Math.random() * 100);
                        attackBeast = (int) Math.floor(Math.random() * 90);
                    }

                    int attackHeroReduceArmor = (int) ((beast.getArmor() / 1.5) * attackHero / 100);
                    int attackBeastReduceArmor = (int) ((hero.getArmor() / 1.5) * attackBeast / 100);

                    beast.setLife(beast.getLife() - (attackHero - attackHeroReduceArmor));
                    hero.setLife(hero.getLife() - (attackBeast - attackBeastReduceArmor));
                    hero.setArmor(armor);

                    textArea = view.getAppGameContainer().getAppGameFight().getTextArea().getText().concat(
                            res.getString("fight2") + hero.getName() + " (" + res.getString("life2") + "="
                                    + heroOldLife + " " + res.getString("armor2") + "=" + hero.getArmor() +
                                    ") " + res.getString("and") + beast.getName() + " (" + res.getString("life2") + "=" +
                                    beastOldLife + " " + res.getString("armor2") + "=" + beast.getArmor() +
                                    ")\n" + hero.getName() + " " + res.getString("out") + attackHero + " " +
                                    res.getString("and_remove") + (attackHero - attackHeroReduceArmor) + " " +
                                    res.getString("of_life") + beast.getName() + "\n" + beast.getName()
                                    + " " + res.getString("out") + attackBeast + " " + res.getString("and_remove")
                                    + (attackBeast - attackBeastReduceArmor) + " " + res.getString("of_life") +
                                    hero.getName() + "\n"
                    );

                    if (hero.getLife() <= 0) {
                        textArea = textArea.concat(res.getString("death") + hero.getType().getType() + " " + hero.getName()
                                + "!\n");
                    }

                    if (beast.getLife() <= 0) {
                        textArea = textArea.concat(res.getString("death") + beast.getType().getType() + " " + beast.getName()
                                + "!\n");
                    }

                    if (beast.getLife() <= 0) {
                        size = view.getAppGameBeast().getListView().getBeastPosDTOS().size();

                        for (int j = beast.getPos() + 1; j < size; j++) {
                            beast = view.getAppGameBeast().getListView().getBeastPosDTOS().get(j);
                            view.getAppGameBeast().getListView().getItems().get(j).setText(beast.toString());
                        }
                        removesBeasts.add(i);
                    } else {
                        view.getAppGameBeast().getListView().getBeastPosDTOS().set(beast.getPos(), beast);
                        view.getAppGameBeast().getListView().getItems().get(beast.getPos()).setText(beast.toString());
                    }

                    if (hero.getLife() <= 0) {
                        size = view.getAppGameHeroes().getListView().getHeroPosDTOS().size();

                        for (int j = hero.getPos() + 1; j < size; j++) {
                            hero = view.getAppGameHeroes().getListView().getHeroPosDTOS().get(j);
                            view.getAppGameHeroes().getListView().getItems().get(j).setText(hero.toString());
                        }

                        removesHeroes.add(i);
                    } else {

                        view.getAppGameHeroes().getListView().getHeroPosDTOS().set(hero.getPos(), hero);
                        view.getAppGameHeroes().getListView().getItems().get(hero.getPos()).setText(hero.toString());
                    }

                    view.getAppGameContainer().getAppGameFight().getTextArea().setText(textArea);

                    view.getAppGameContainer().getAppGameFight().getTextArea().requestFocus();
                    String text = view.getAppGameContainer().getAppGameFight().getTextArea().getText();
                    view.getAppGameContainer().getAppGameFight().getTextArea().positionCaret(text.length());
                }

                if (!removesHeroes.isEmpty()){
                    for (int i = removesHeroes.size(); i > 0; i--){
                        view.getAppGameHeroes().getListView().getHeroPosDTOS().remove((int) removesHeroes.get(i - 1));
                        view.getAppGameHeroes().getListView().getItems().remove((int) removesHeroes.get(i - 1));

                        size = view.getAppGameHeroes().getListView().getHeroPosDTOS().size();

                        for (int j = removesHeroes.get(i - 1); j < size; j++){
                            hero = view.getAppGameHeroes().getListView().getHeroPosDTOS().get(j);
                            view.getAppGameHeroes().getListView().getHeroPosDTOS().get(j).setPos(hero.getPos() - 1);
                        }
                    }
                    removesHeroes.clear();
                }


                if (!removesBeasts.isEmpty()){
                    for (int i = removesBeasts.size(); i > 0; i--){
                        view.getAppGameBeast().getListView().getBeastPosDTOS().remove((int) removesBeasts.get(i - 1));
                        view.getAppGameBeast().getListView().getItems().remove((int) removesBeasts.get(i - 1));

                        size = view.getAppGameBeast().getListView().getBeastPosDTOS().size();

                        for (int j = removesBeasts.get(i - 1); j < size; j++ ){
                            beast =  view.getAppGameBeast().getListView().getBeastPosDTOS().get(j);
                            view.getAppGameBeast().getListView().getBeastPosDTOS().get(j).setPos(beast.getPos() - 1);
                        }
                    }
                    removesBeasts.clear();
                }

                if (view.getAppGameHeroes().getListView().getItems().isEmpty()){
                    textArea = textArea.concat("----------" + res.getString("victory_beast") + "----------");
                    view.getAppGameContainer().getAppGameFight().getTextArea().setText(textArea);
                }

                if (view.getAppGameBeast().getListView().getItems().isEmpty()){
                    textArea = textArea.concat("----------" + res.getString("victory_hero") + "----------");
                    view.getAppGameContainer().getAppGameFight().getTextArea().setText(textArea);
                }

                textArea = textArea.concat("\n");
                view.getAppGameContainer().getAppGameFight().getTextArea().setText(textArea);

                if (view.getAppGameHeroes().getListView().getItems().isEmpty() ||
                        view.getAppGameBeast().getListView().getItems().isEmpty())
                    view.getAppGameContainer().getAppGameFight().getFight().setDisable(true);

                countTurn++;
                try {
                    model.saveTurn(countTurn);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                break;

            case "exit":
                view.getAppGameContainer().getAppGameExitStage().showAndWait();
                break;
        }
    }
}
