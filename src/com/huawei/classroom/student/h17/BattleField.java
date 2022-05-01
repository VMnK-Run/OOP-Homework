package com.huawei.classroom.student.h17;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class BattleField {
    private static List<Player> players = new ArrayList<>();
    public static List<GameObject> gameObjects = new ArrayList<>();
    public static List<String> results = new ArrayList<>();

    public BattleField() {
        players = null;
    }

    public static void init(String fileName) {
        List<String[]> rules;
        rules = readIn(fileName);
        for(String[] rule: rules) {
            if(rule[0].equals(EnumObjectType.base.toString())) {
                switch (rule[1]) {
                    case "health" -> Params.baseHealth = Integer.parseInt(rule[2]);
                    case "range" -> Params.baseRange = Integer.parseInt(rule[2]);
                    case "strength" -> Params.baseStrength = Integer.parseInt(rule[2]);
                }
            } else if (rule[0].equals(EnumObjectType.heavyTank.toString())) {
                switch (rule[1]) {
                    case "health" -> Params.heavyTankHealth = Integer.parseInt(rule[2]);
                    case "range" -> Params.heavyTankRange = Integer.parseInt(rule[2]);
                    case "strength" -> Params.heavyTankStrength = Integer.parseInt(rule[2]);
                }
            } else if (rule[0].equals(EnumObjectType.mediumTank.toString())) {
                switch (rule[1]) {
                    case "health" -> Params.mediumTankHealth = Integer.parseInt(rule[2]);
                    case "range" -> Params.mediumTankRange = Integer.parseInt(rule[2]);
                    case "strength" -> Params.mediumTankStrength = Integer.parseInt(rule[2]);
                }
            } else if (rule[0].equals(EnumObjectType.rifleSoldier.toString())) {
                switch (rule[1]) {
                    case "health" -> Params.rifleSoldierHealth = Integer.parseInt(rule[2]);
                    case "range" -> Params.rifleSoldierRange = Integer.parseInt(rule[2]);
                    case "strength" -> Params.rifleSoldierStrength = Integer.parseInt(rule[2]);
                }
            } else if (rule[0].equals(EnumObjectType.RPGSoldier.toString())) {
                switch (rule[1]) {
                    case "health" -> Params.RPGSoldierHealth = Integer.parseInt(rule[2]);
                    case "range" -> Params.RPGSoldierRange = Integer.parseInt(rule[2]);
                    case "strength" -> Params.RPGSoldierStrength = Integer.parseInt(rule[2]);
                }
            } else if (rule[0].equals(EnumObjectType.dog.toString())) {
                switch (rule[1]) {
                    case "health" -> Params.dogHealth = Integer.parseInt(rule[2]);
                    case "range" -> Params.dogRange = Integer.parseInt(rule[2]);
                    case "strength" -> Params.dogStrength = Integer.parseInt(rule[2]);
                }
            } else if (rule[0].equals(EnumObjectType.barrack.toString())) {
                switch (rule[1]) {
                    case "health" -> Params.barrackHealth = Integer.parseInt(rule[2]);
                    case "range" -> Params.barrackRange = Integer.parseInt(rule[2]);
                    case "strength" -> Params.barrackStrength = Integer.parseInt(rule[2]);
                }
            } else if (rule[0].equals(EnumObjectType.warFactory.toString())) {
                switch (rule[1]) {
                    case "health" -> Params.warFactoryHealth = Integer.parseInt(rule[2]);
                    case "range" -> Params.warFactoryRange = Integer.parseInt(rule[2]);
                    case "strength" -> Params.warFactoryStrength = Integer.parseInt(rule[2]);
                }
            }
        }
    }

    public static void createPlayer(String name) {
        if(name == null) return;
        Player newPlayer = new Player(name);
        players.add(newPlayer);
    }

    public static List<Player> getAllPlayer() {
        return players;
    }


    public static GameBase createGameBase(Player player, int x, int y) {
        GameBase newGameBase = new GameBase(player, x, y);
        newGameBase.setType(EnumObjectType.base.toString());
        gameObjects.add(newGameBase);
        return newGameBase;
    }

    public static List<String[]> readIn(String fileName) {
        List<String[]> result = new ArrayList<>();
        try(Reader reader = new FileReader(fileName);
            LineNumberReader lineReader = new LineNumberReader(reader)) {
            String line = lineReader.readLine();
            while(line != null) {
                if(line.trim().length() != 0 && line.trim().charAt(0) != '#') {
                    result.add(line.trim().split("[\\.=]"));
                }
                line = lineReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
