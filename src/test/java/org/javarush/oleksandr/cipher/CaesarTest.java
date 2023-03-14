package org.javarush.oleksandr.cipher;

import org.javarush.oleksandr.constants.Constants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class CaesarTest {

    private static Caesar CAESAR_EN;
    private static Caesar CAESAR_RU;

    @BeforeAll
    static void beforeAll() {
        CAESAR_EN = new Caesar(Constants.ALPHABET_EN);
        CAESAR_RU = new Caesar(Constants.ALPHABET_RU);
    }

    @ParameterizedTest
    @CsvSource({
            "A, 1, B",
            "a, 1, b",
            "' ', 1, a ",
            "'Hello world!*', 5, 'Mjqqte,twqic*'"

    })
    @DisplayName("Should encrypt a string with given key with english alphabet")
    void encrypt_positive(String input, int key, String expected) {
        String result = CAESAR_EN.encrypt(input, key);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "'Hello world!', -5, 'Mjqqte,twqic'",

    })
    @DisplayName("Should throw IndexOutOfBoundsException when passed -5 as argument")
    void encrypt_negative(String input, int key, String expected) {
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> CAESAR_EN.encrypt(input, key));
    }


    @Test
    void decrypt() {
        String result = CAESAR_EN.decrypt("B", 1);

        assertEquals("A", result);
    }


    @ParameterizedTest
    @CsvSource({
            "1, 35",
            "5, 31"
    })
    void decrypt_spy(int key, int processedKey){
        Caesar cipher = spy(new Caesar(Constants.ALPHABET_EN));
        when(cipher.encrypt(anyString(), anyInt())).thenReturn("");

        String mockText = "MockText";

        cipher.decrypt(mockText, key);

        verify(cipher, times(1)).encrypt(eq(mockText), eq(processedKey));
    }
}