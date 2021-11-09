package com.psp.task3.validation;

import com.psp.task3.exception.InvalidUserException;
import com.psp.task3.model.User;
import validators.EmailValidator;
import validators.PasswordChecker;
import validators.PhoneValidator;

import java.io.FileNotFoundException;
import java.io.IOException;

public class UserValidator implements ValidationStrategy {

    private final int MIN_PASSWORD_LENGTH = 5;

    public boolean validate(User user) throws InvalidUserException {
        return validateEmail(user.getEmail()) && validatePassword(user.getPassword()) && validatePhoneNumber(user.getPhoneNumber());
    }

    private boolean validateEmail(String email) throws InvalidUserException {
        EmailValidator emailValidator = new EmailValidator();

        if(!emailValidator.checkAtSign(email)) {
            throw new InvalidUserException("@ sign is missing");
        }
        if(!emailValidator.checkSymbols(email)) {
            throw new InvalidUserException("email has invalid symbols");
        }
        if(!emailValidator.checkDomainAndTLD(email)) {
            throw new InvalidUserException("domain is invalid");
        }
        return true;
    }

    private boolean validatePassword(String password) throws InvalidUserException {
        try {
            PasswordChecker passwordChecker = new PasswordChecker();

            if(!passwordChecker.checkLength(password, MIN_PASSWORD_LENGTH)) {
                throw new InvalidUserException("password is too short");
            }
            if(!passwordChecker.checkUppercase(password)) {
                throw new InvalidUserException("password has no upper cases");
            }
            if(!passwordChecker.checkSpecialSymbols(password)) {
                throw new InvalidUserException("password has no special symbols");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private boolean validatePhoneNumber(String phoneNumber) throws InvalidUserException {
        try {
            PhoneValidator phoneValidator = new PhoneValidator();

            String tempPhoneNumber = phoneValidator.changePrefix("+370", phoneNumber);

            if (tempPhoneNumber != null) {
                phoneNumber = tempPhoneNumber;
            }

            if(!phoneValidator.checkSymbols(phoneNumber)) {
                throw new InvalidUserException("phone number has invalid symbols");
            }
            if(!phoneValidator.validateNumberByCountry(phoneNumber, "LT")){
                throw new InvalidUserException("phone number is invalid");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }


}
