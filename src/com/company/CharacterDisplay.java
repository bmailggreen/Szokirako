package com.company;

public class CharacterDisplay {

    private String getStringFromCharacterArray(char[] characters, char separatorChar) {
        String text = "";
        for (int i = 0; i < characters.length; i++) {
            text += (characters[i] + "" + separatorChar);
        }
        return text;
    }

    private String getStringFromCharacterArray(char[] characters) {
        String text = "";
        for (int i = 0; i < characters.length; i++) {
            text += (characters[i]);
        }
        return text;
    }

    public void display(GameData gameData) {
        System.out.println("The game state:");
        System.out.println();
        System.out.println("The remaining guesses: " + gameData.getGuessNumber());
        System.out.println();
        System.out.println("Remaining characters: " +
                getStringFromCharacterArray(gameData.getRemainingCharacters(), ' '));
        System.out.println();
        System.out.println("Guessed characters: " +
                getStringFromCharacterArray(gameData.getGuessedCharacters(), ' '));
        System.out.println();
        System.out.println();
        System.out.println(gameData.getActualText());
    }
}
