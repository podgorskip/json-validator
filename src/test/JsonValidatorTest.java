package test;

import main.JsonValidator;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JsonValidatorTest {
    @Test
    public void testInvalidJsonWithAsterisk() {
        assertFalse(JsonValidator.validate("src/test/resources/test-json1.json"));
    }

    @Test
    public void testValidJsonWithoutAsterisk() {
        assertTrue(JsonValidator.validate("src/test/resources/test-json2.json"));
    }

    @Test
    public void testInvalidJsonWithAsteriskAndUnnecessaryWhitespaces() {
        assertFalse(JsonValidator.validate("src/test/resources/test-json3.json"));
    }

    @Test
    public void testValidJsonWithoutAsteriskAndUnnecessaryWhitespaces() {
        assertTrue(JsonValidator.validate("src/test/resources/test-json4.json"));
    }

    @Test
    public void testValidJsonWithManyAsterisks() {
        assertTrue(JsonValidator.validate("src/test/resources/test-json5.json"));
    }

    @Test
    public void testFileNotFound() {
        assertThrows(RuntimeException.class, () -> JsonValidator.validate("doesnt-exist.json"));
    }

    @Test
    public void testEmptyFile() {
        assertTrue(JsonValidator.validate("src/test/resources/test-json6.json"));
    }


}