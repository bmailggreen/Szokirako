package com.company;

public class Main {

    public static void main(String[] args) {
        GameData gd = new GameData(5, "Harry Potter");
        CharacterDisplay cdp = new CharacterDisplay();
        Game game = new Game(gd, cdp);
        game.startGame();
    }
}
