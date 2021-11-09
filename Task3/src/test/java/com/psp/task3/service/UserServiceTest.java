package com.psp.task3.service;

import com.psp.task3.exception.InvalidUserException;
import com.psp.task3.model.User;
import com.psp.task3.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void testFindAll() {
        User user = new User();
        List<User> users = new ArrayList<>();
        users.add(user);

        when(userRepository.findAll()).thenReturn(users);

        List<User> foundUsers = userService.findAll();

        verify(userRepository).findAll();

        assertEquals(1, foundUsers.size());
    }

    @Test
    void testFindById() {
        User user = new User();
        when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));

        User userFound = userRepository.findById(1).get();

        verify(userRepository).findById(Mockito.anyInt());
        assertNotNull(userFound);
    }


    @Test
    void testAddUser() {
        User user = new User(1, "Name", "Surname", "+37062369874", "namesurname@gmail.com", "address", "p@ssworD");
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        User userAdded = null;
        try {
            userAdded = userService.addUser(user);
        } catch (InvalidUserException e) {
            fail();
        }
        verify(userRepository).save(Mockito.any(User.class));
        assertNotNull(userAdded);
    }


    @Test
    void testUpdateUser() {
        User user = new User(1, "Name", "Surname", "+37062369874", "namesurname@gmail.com", "address", "p@ssworD");
        try {
            userService.updateUser(1, user);
        } catch (InvalidUserException e) {
            fail();
        }
        verify(userRepository).save(Mockito.any(User.class));
    }

    @Test
    void testDeleteUser() {
        userService.deleteUser(1);
        verify(userRepository).deleteById(Mockito.anyInt());
    }
}
