package testTradeArena.cep_api.utilsTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import testTradeArena.cep_api.utils.Utils;

public class UtilsTest {

    @Test
    void isCepFormatValid_ValidNumbers_ShouldReturnTrue() {
        String cep = "12345678";
        assertTrue(Utils.isCepFormatValid(cep));
    }

    @Test
    void isCepFormatValid_NonNumericCharacters_ShouldReturnFalse() {
        String cep = "12A45678";
        assertFalse(Utils.isCepFormatValid(cep));
    }

    @Test
    void isCepFormatValid_SpecialCharacters_ShouldReturnFalse() {
        String cep = "123-4567";
        assertFalse(Utils.isCepFormatValid(cep));
    }

    @Test
    void isCepFormatValid_EmptyCep_ShouldReturnFalse() {
        String cep = "";
        assertFalse(Utils.isCepFormatValid(cep));
    }

    @Test
    void isCepFormatValid_WithSpaces_ShouldReturnFalse() {
        String cep = "12 345678";
        assertFalse(Utils.isCepFormatValid(cep));
    }

    @Test
    void isCepLengthValid_WithValidLength_ShouldReturnTrue() {
        String cep = "12345678";
        assertTrue(Utils.isCepLengthValid(cep));
    }

    @Test
    void isCepLengthValid_WithShortLength_ShouldReturnFalse() {
        String cep = "1234567";
        assertFalse(Utils.isCepLengthValid(cep));
    }

    @Test
    void isCepLengthValid_WithLongLength_ShouldReturnFalse() {
        String cep = "123456789";
        assertFalse(Utils.isCepLengthValid(cep));
    }

    @Test
    void isCepLengthValid_WithEmptyCep_ShouldReturnFalse() {
        String cep = "";
        assertFalse(Utils.isCepLengthValid(cep));
    }
}
