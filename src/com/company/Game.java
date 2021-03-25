package com.company;

import java.util.Scanner;

public class Game {
    GameData gameData;
    CharacterDisplay characterDisplay;
    Scanner scanner;

    public Game(GameData gameData, CharacterDisplay characterDisplay) {
        this.gameData = gameData;
        this.characterDisplay = characterDisplay;
        this.scanner = new Scanner(System.in);
    }

    public void nextTurn() {
        System.out.println("Please guess a character: ");
        char guessedChar = scanner.next().charAt(0);

        //Check if we already guessed this character
        char[] guessedChars = gameData.getGuessedCharacters();
        for (int i = 0; i < guessedChars.length; i++) {
            if(guessedChar == guessedChars[i]) {
                System.out.println("You have already guessed this character!");
                System.out.println();
                return;
            }
        } //End of check

        gameData.setTriedCharacter(guessedChar);
        boolean found = gameData.checkAndSetActualTextCharacters(guessedChar);
        if(!found) {
            gameData.reduceGuessNumbers();
        }
    }

    public void startGame() {
        characterDisplay.display(gameData);

        while(gameData.getGuessNumber() != 0 && !gameData.isRiddleTextSameAsActualText()) {
            nextTurn();
            characterDisplay.display(gameData);
        }

        if(gameData.getGuessNumber() == 0) {
            System.out.println("You have lost!");
        }

        if(gameData.isRiddleTextSameAsActualText()) {
            System.out.println("You have won!");
        }
    }

}
