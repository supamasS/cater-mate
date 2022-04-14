package org.supamassirichotiyakul.catermate.security;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    User findByEmail(String email);
    User save(UserRegistrationDto registration);
    User updateUserById(UserRegistrationDto dto, long id);

    User getUserById(long id);
    void deleteUserById(long id);
}

