package spring.project.superfood.service;

import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.project.superfood.models.User;
import spring.project.superfood.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public boolean userExists(String email) {
        return (findUserByEmail(email)).isPresent();

    }
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }
}
