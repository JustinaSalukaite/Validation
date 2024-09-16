package com.psp.task3.service;

import com.psp.task3.exception.InvalidUserException;
import com.psp.task3.model.User;
import com.psp.task3.repository.UserRepository;
import com.psp.task3.validation.UserValidator;
import com.psp.task3.validation.ValidationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private ValidationStrategy userValidator;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        userValidator = new UserValidator();
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id).get();
    }


    public User addUser(User user) throws InvalidUserException {

        if(userValidator.validate(user)) {
            return userRepository.save(user);
        }
        else return null;
    }

    public void updateUser(int id, User user) throws InvalidUserException {

        if(userValidator.validate(user)) {
            user.setId(id);
            userRepository.save(user);
        }
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


}
