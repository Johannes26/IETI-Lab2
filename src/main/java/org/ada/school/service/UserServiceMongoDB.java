package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.repository.UserDocument;
import org.ada.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceMongoDB
        implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        UserDocument userD = userRepository.save(new UserDocument(user));
        return new User(userD);
    }

    @Override
    public User findById(String id) {
        try {
            UserDocument userD = userRepository.findById(id).get();
            return new User(userD);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public List<User> all() {
        List<UserDocument> usersD = userRepository.findAll();
        List<User> users = new ArrayList<User>();
        for (UserDocument ud :
                usersD) {
            users.add(new User(ud));
        }
        return users;
    }

    @Override
    public boolean deleteById(String id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else return false;
    }

    @Override
    public User update(UserDto userDto, String id) {
        if (userRepository.findById(id).isPresent()) {
            UserDocument userD = userRepository.insert(new UserDocument(userDto, id));
            return new User(userD);
        } else return null;
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        List<UserDocument> usersD = userRepository.findByNameLikeOrLastNameLike(queryText,queryText);
        List<User> users = new ArrayList<User>();
        for (UserDocument ud :
                usersD) {
            users.add(new User(ud));
        }
        return users;
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        List<UserDocument> usersD = userRepository.findByCreatedAtAfter(startDate);
        List<User> users = new ArrayList<User>();
        for (UserDocument ud :
                usersD) {
            users.add(new User(ud));
        }
        return users;
    }


}

