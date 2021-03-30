package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameDataTest {

    @Test
    void correctInitialGuessNumber() {
        GameData gd = new GameData(10, "Harry Potter");
        assertEquals(10, gd.getGuessNumber());
    }

    @Test
    void correctActualTextAfterInitialisation() {
        GameData gd = new GameData(10, "Harry Potter");
        assertEquals("_____ ______", new String(gd.getActualText()) );
    }

    @Test
    void correctRemainingCharactersAfterInitialisation() {
        GameData gd = new GameData(10, "Harry Potter");
        assertEquals("abcdefghijklmnopqrstuvwxyzáéíóöőúüű", new String(gd.getRemainingCharacters()));
    }

    @Test
    void correctRemainingCharactersAfterTriedA() {
        GameData gd = new GameData(10, "Harry Potter");
        gd.setTriedCharacter('a');
        assertEquals("bcdefghijklmnopqrstuvwxyzáéíóöőúüű", new String(gd.getRemainingCharacters()));
    }

    @Test
    void correctGuessedCharactersAfterInitialisation() {
        GameData gd = new GameData(10, "Harry Potter");
        assertEquals("", new String(gd.getGuessedCharacters()));
    }

    @Test
    void correctGuessedCharactersAfterGuessingP() {
        GameData gd = new GameData(10, "Harry Potter");
        gd.setTriedCharacter('p');
        assertEquals("p", new String(gd.getGuessedCharacters()));
    }

}