import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordCheckerTest {

    PasswordChecker passwordChecker = new PasswordChecker(6);

    @Test
    void Validate_PasswordIsShorterThanRequiredLength_ShouldReturnFalse() {
        assertFalse(passwordChecker.validate("Pass@"));
    }

    @Test
    void Validate_PasswordDoesNotContainUppercaseCharacters_ShouldReturnFalse() {
        assertFalse(passwordChecker.validate("pass@"));
    }

    @Test
    void Validate_PasswordDoesNotContainSpecialCharacter_ShouldReturnFalse() {
        assertFalse(passwordChecker.validate("Pass"));
    }

    @Test
    void Validate_PasswordAdheresToTheRules_ReturnsTrue() {
        assertTrue(passwordChecker.validate("Password@"));
    }

}