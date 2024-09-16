package com.psp.task3.validation;

import com.psp.task3.exception.InvalidUserException;
import com.psp.task3.model.User;

public interface ValidationStrategy {

    boolean validate(User user) throws InvalidUserException;
}
