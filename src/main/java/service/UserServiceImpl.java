package service;

import dto.UserDTO;
import exceptions.InvalidUserDataException;
import exceptions.UserNotFoundException;
import model.User;
import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        if (userDTO.getFirstName() == null || userDTO.getEmail() == null) {
            throw new InvalidUserDataException("User name and email cannot be null");
        }
        User user = new User(userDTO);
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Override
    public UserDTO updateUser(String id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        if (userDTO.getFirstName() == null || userDTO.getEmail() == null) {
            throw new InvalidUserDataException("User name and email cannot be null");
        }
        user.updateFromDTO(userDTO);
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Override
    public UserDTO getUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return new UserDTO(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }
}