package com.company;

import java.util.Locale;

public class GameData {
    private int guessNumber;
    private TriedCharacter[] triedCharacters;
    private String riddleText;
    private char[] actualText;


    private void initializeActualText() {
        actualText = new char[this.riddleText.length()];
        for (int i = 0; i < actualText.length; i++) {
            if(riddleText.charAt(i) == ' ') {
                actualText[i] = ' ';
            } else {
                actualText[i] = '_';
            }
        }
    }

    private void initializeTriedCharacters() {
        triedCharacters = new TriedCharacter[35];
        for (int i = (int)'a'; i <= (int)'z'; i++) {
            triedCharacters[i-(int)'a'] = new TriedCharacter((char)i);
        }
        triedCharacters[26] = new TriedCharacter('á');
        triedCharacters[27] = new TriedCharacter('é');
        triedCharacters[28] = new TriedCharacter('í');
        triedCharacters[29] = new TriedCharacter('ó');
        triedCharacters[30] = new TriedCharacter('ö');
        triedCharacters[31] = new TriedCharacter('ő');
        triedCharacters[32] = new TriedCharacter('ú');
        triedCharacters[33] = new TriedCharacter('ü');
        triedCharacters[34] = new TriedCharacter('ű');
    }


    public GameData(int guessNumber, String riddleText) {
        this.guessNumber = guessNumber;
        this.riddleText = riddleText;
        initializeActualText();
        initializeTriedCharacters();
    }

    public int getGuessNumber() {
        return guessNumber;
    }

    public char[] getRemainingCharacters() {
        int numOfCharacters = 0;
        for (int i = 0; i < triedCharacters.length; i++) {
            if(!triedCharacters[i].tried) {
                ++numOfCharacters;
            }
        }
        char[] remainingCharacters = new char[numOfCharacters];
        int actualIndex = 0;
        for (int i = 0; i < triedCharacters.length; i++) {
            if(!triedCharacters[i].tried) {
                remainingCharacters[actualIndex++] = (char) triedCharacters[i].character;
            }
        }
        return remainingCharacters;
    }

    public char[] getGuessedCharacters() {
        int numOfCharacters = 0;
        for (int i = 0; i < triedCharacters.length; i++) {
            if(triedCharacters[i].tried) {
                ++numOfCharacters;
            }
        }
        char[] guessedCharacters = new char[numOfCharacters];
        int actualIndex = 0;
        for (int i = 0; i < triedCharacters.length; i++) {
            if(triedCharacters[i].tried) {
                guessedCharacters[actualIndex++] = triedCharacters[i].character;
            }
        }
        return guessedCharacters;
    }

    public char[] getActualText() {
        return actualText;
    }

    public void setTriedCharacter(char triedCharacter) {
        for (int i = 0; i < triedCharacters.length; i++) {
            if(triedCharacters[i].character == triedCharacter) {
                triedCharacters[i].tried = true;
            }
        }
    }

    public boolean checkAndSetActualTextCharacters(char character) {
        boolean hadBeenChanged = false;
        for (int i = 0; i < riddleText.length(); i++) {
            if(character == riddleText.toLowerCase(Locale.ROOT).charAt(i)) {
                actualText[i] = riddleText.charAt(i);
                hadBeenChanged = true;
            }
        }
        return hadBeenChanged;
    }

    public void reduceGuessNumbers() {
        --guessNumber;
    }

    public boolean isRiddleTextSameAsActualText() {
        return new String(actualText).equals(riddleText);
    }
}
