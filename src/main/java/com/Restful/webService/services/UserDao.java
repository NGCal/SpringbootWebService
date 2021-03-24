package com.Restful.webService.services;

import com.Restful.webService.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserDao {
    private static List<User> userRepository = new ArrayList<>();
    private static int currUsers = 3;

    static {
        userRepository.add(new User(1, "Sally", new Date()));
        userRepository.add(new User(2, "Ricky", new Date()));
        userRepository.add(new User(3, "Max", new Date()));

    }


    public UserDao() {
    }

    public List<User> findAll() {
        return userRepository;
    }

    public User findById(int id) {
        for (User user : userRepository) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User save(User user) {
        user.setId(++currUsers);
        userRepository.add(user);
        return user;
    }

    public User remove(int id) {
        User user = this.findById(id);
        if (user == null) {
            return null;
        }
        userRepository.remove(user);
        return user;
    }

    public User update(User user) {
        user = this.remove(user.getId());

        if (user == null) {
            return null;
        }
        this.save(user);
        return user;
    }
}
