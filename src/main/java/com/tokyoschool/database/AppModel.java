package com.tokyoschool.database;

import com.tokyoschool.domain.Beast;
import com.tokyoschool.domain.Hero;
import com.tokyoschool.util.Filter;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppModel {

    private final String dbName1 = "save1.db";
    private final String dbName2 = "save2.db";
    private final String dbName3 = "save3.db";
    private final String dbLanguage = "language.db";
    private int save;
    private final String contain = "saves";
    private Connection connection;
    private final String sqliteServer = "jdbc:sqlite:";

    public AppModel(){
    }

    public void connect() {
        if (!new File(contain + File.separator + dbLanguage).exists()){
            try {
                connection = DriverManager.getConnection(sqliteServer + contain + File.separator + dbLanguage);
                createTableLanguage();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        switch (save){
            case 1:
                File myDataBase = new File(contain + File.separator + dbName1);

                if (myDataBase.exists()) {
                    try {
                        connection = DriverManager.getConnection(sqliteServer + contain + File.separator + dbName1);
                    } catch (SQLException sqle) {
                        sqle.printStackTrace();
                    }
                } else {
                    try {
                        connection = DriverManager.getConnection(sqliteServer + contain + File.separator + dbName1);
                        createTableHero();
                        createTableBeast();
                        createTableName();
                        createTableTurn();
                    } catch (SQLException sqle) {
                        sqle.printStackTrace();
                    }
                }
                break;

            case 2:
                myDataBase = new File(contain + File.separator + dbName2);

                if (myDataBase.exists()) {
                    try {
                        connection = DriverManager.getConnection(sqliteServer + contain + File.separator + dbName2);
                    } catch (SQLException sqle) {
                        sqle.printStackTrace();
                    }
                } else {
                    try {
                        connection = DriverManager.getConnection(sqliteServer + contain + File.separator + dbName2);
                        createTableHero();
                        createTableBeast();
                        createTableName();
                        createTableTurn();
                    } catch (SQLException sqle) {
                        sqle.printStackTrace();
                    }
                }
                break;

            case 3:
                myDataBase = new File(contain + File.separator + dbName3);

                if (myDataBase.exists()) {
                    try {
                        connection = DriverManager.getConnection(sqliteServer + contain + File.separator + dbName3);
                    } catch (SQLException sqle) {
                        sqle.printStackTrace();
                    }
                } else {
                    try {
                        connection = DriverManager.getConnection(sqliteServer + contain + File.separator + dbName3);
                        createTableHero();
                        createTableBeast();
                        createTableName();
                        createTableTurn();
                    } catch (SQLException sqle) {
                        sqle.printStackTrace();
                    }
                }
                break;
        }
    }

    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void createTableHero(){
        String sql = "CREATE TABLE hero(name TEXT, armor INT, life INT, type TEXT, pos INT)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createTableBeast(){
        String sql = "CREATE TABLE beast(name TEXT, armor INT, life INT, type TEXT, pos INT)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createTableName(){
        String sql = "CREATE TABLE name(name Text)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public void createTableTurn(){
        String sql = "CREATE TABLE turn(turn INT)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void createTableLanguage(){
        String sql = "CREATE TABLE language(language text)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            saveLanguage("es");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void addHero(Hero hero) throws SQLException {
        String sql = "INSERT INTO hero(name, armor, life, type, pos) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, hero.getName());
        statement.setInt(2, hero.getArmor());
        statement.setInt(3, hero.getLife());
        statement.setString(4, hero.getType().getType());
        statement.setInt(5, hero.getPos());
        statement.executeUpdate();
    }

    public void addBeast(Beast beast) throws SQLException{
        String sql = "INSERT INTO beast(name, armor, life, type, pos) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, beast.getName());
        statement.setInt(2, beast.getArmor());
        statement.setInt(3, beast.getLife());
        statement.setString(4, beast.getType().getType());
        statement.setInt(5, beast.getPos());
        statement.executeUpdate();
    }

    public List<Hero> getHeroes() throws SQLException {
        List<Hero> heroes = new ArrayList<>();
        String sql = "SELECT * FROM hero ORDER BY pos";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            if (Filter.getHeroTypeFromComboBox(resultSet.getString(4)) != null){
                Hero hero = new Hero();
                hero.setName(resultSet.getString(1));
                hero.setArmor(resultSet.getInt(2));
                hero.setLife(resultSet.getInt(3));
                hero.setType(Filter.getHeroTypeFromComboBox(resultSet.getString(4)));
                hero.setPos(resultSet.getInt(5));
                heroes.add(hero);
            }
        }
        return heroes;
    }

    public List<Beast> getBeast() throws SQLException{
        List<Beast> beasts = new ArrayList<>();
        String sql = "SELECT * FROM beast ORDER BY pos";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            if (Filter.getBeastTypeFromComboBox(resultSet.getString(4)) != null){
                Beast beast = new Beast();
                beast.setName(resultSet.getString(1));
                beast.setArmor(resultSet.getInt(2));
                beast.setLife(resultSet.getInt(3));
                beast.setType(Filter.getBeastTypeFromComboBox(resultSet.getString(4)));
                beast.setPos(resultSet.getInt(5));
                beasts.add(beast);
            }
        }
        return beasts;
    }

    public String getName() throws SQLException{
        String name = "";
        String sql = "SELECT * FROM name";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            name = resultSet.getString(1);
        }
        return name;
    }

    public int getTurn() throws SQLException{
        int turn = 1;
        String sql = "SELECT * FROM turn";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            turn = resultSet.getInt(1);
        }
        return turn;
    }

    public String getLanguage() throws SQLException{
        connection = DriverManager.getConnection(sqliteServer + contain + File.separator + dbLanguage);
        String sql = "SELECT * FROM language";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        String language = null;

        while (resultSet.next()){
            language = resultSet.getString(1);
        }
        return language;
    }

    public void save(List<Hero> heroes, List<Beast> beasts) throws SQLException{
        String sqlRefresh = "DELETE FROM hero";
        PreparedStatement statement = connection.prepareStatement(sqlRefresh);
        statement.executeUpdate();

        sqlRefresh = "DELETE FROM beast";
        statement = connection.prepareStatement(sqlRefresh);
        statement.execute();

        heroes.forEach(hero -> {
            try {
                addHero(hero);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        });

        beasts.forEach(beast -> {
            try {
                addBeast(beast);
            } catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        });
    }

    public void saveName(String name) throws SQLException{
        String sqlRefresh = "DELETE FROM name";
        PreparedStatement statement = connection.prepareStatement(sqlRefresh);
        statement.executeUpdate();

        String sql = "INSERT INTO name(name) VALUES(?)";
        statement = connection.prepareStatement(sql);

        statement.setString(1, name);
        statement.executeUpdate();
    }

    public void saveTurn(int turn) throws SQLException{
        String sqlRefresh = "DELETE FROM turn";
        PreparedStatement statement = connection.prepareStatement(sqlRefresh);
        statement.executeUpdate();

        String sql = "INSERT INTO turn(turn) VALUES(?)";
        statement = connection.prepareStatement(sql);

        statement.setInt(1, turn);
        statement.executeUpdate();
    }

    public void saveLanguage(String language) throws SQLException{
        connection = DriverManager.getConnection(sqliteServer + contain + File.separator + dbLanguage);
        String sql = "DELETE FROM language";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();

        sql = "INSERT INTO language(language) VALUES (?)";
        statement = connection.prepareStatement(sql);

        statement.setString(1, language);
        statement.executeUpdate();
    }

    public void reset() throws SQLException{
        String sql = "DELETE FROM hero";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();

        sql = "DELETE FROM beast";
        statement = connection.prepareStatement(sql);
        statement.executeUpdate();

        sql = "DELETE FROM name";
        statement = connection.prepareStatement(sql);
        statement.executeUpdate();

        sql = "DELETE FROM turn";
        statement = connection.prepareStatement(sql);
        statement.executeUpdate();
    }

    public void setSave(int save){
        this.save = save;
    }

    public boolean isConnect(){
        return new File(contain + File.separator + dbName1).exists() || new File(contain +
                File.separator + dbName2).exists() || !new File(contain + File.separator + dbName3).exists();
    }

    public boolean isSave1(){
         return new File(contain + File.separator + dbName1).exists();
    }

    public boolean isSave2(){
        return new File(contain + File.separator + dbName2).exists();
    }

    public boolean isSave3(){
        return new File(contain + File.separator + dbName3).exists();
    }

    public boolean isLanguage(){return new File(contain + File.separator + dbLanguage).exists();}
}
