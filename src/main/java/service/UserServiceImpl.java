package service;

import dto.UserDTO;
import exceptions.ResourceNotFoundException;
import model.User;
import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = new User(userDTO);
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Override
    public UserDTO updateUser(String id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.updateFromDTO(userDTO);
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Override
    public UserDTO getUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return new UserDTO(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}