import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {

    EmailValidator emailValidator;

    EmailValidatorTest() {
        ArrayList<String> tlds = new ArrayList<>();
        tlds.add("tld");
        emailValidator = new EmailValidator(tlds);
    }


    @Test
    void Validate_EmailDoesNotContainAtSign_ShouldReturnFalse() {
        assertFalse(emailValidator.validate("inter.dom.tld"));
    }


    @Test
    void Validate_EmailContainsSpecialCharacters_ShouldReturnFalse() {
        assertFalse(emailValidator.validate("%$#ab$@dom.tld"));
    }


    @Test
    void Validate_EmailDoesNotHaveTopLevelDomain_ShouldReturnFalse() {
        assertFalse(emailValidator.validate("someone@dom"));
    }

    @Test
    void Validate_EmailDoesNotHaveDomainBeforeTopLevelDomain_ShouldReturnFalse() {
        assertFalse(emailValidator.validate("someone@.tld"));
    }

    @Test
    void Validate_EmailAdheresToTheRules_ShouldReturnTrue() {
        assertTrue(emailValidator.validate("someone@dom.tld"));
    }

}
