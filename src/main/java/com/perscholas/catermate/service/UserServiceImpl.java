package com.perscholas.catermate.service;

import com.perscholas.catermate.exception.UserNotFoundException;
import com.perscholas.catermate.model.User;
import com.perscholas.catermate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        User user;

//        try {
            user = userRepository.getById(id);
//        } catch(EntityNotFoundException e) {
//            throw new UserNotFoundException();
//        }
        return user;
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
