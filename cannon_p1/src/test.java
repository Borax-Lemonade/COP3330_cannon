package COP3330_cannon.cannon_p1.src;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import example.util.Calculator;

import org.junit.jupiter.api.Test;

public class test {

    @Test
    void Encrypt() {
        String EncryptedValue = new Encrypter().encrypt("1234");
        assertEquals("0189", EncryptedValue);
    }
}
