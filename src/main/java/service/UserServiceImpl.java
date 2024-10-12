package service;

import dto.UserDTO;
import exceptions.InvalidUserDataException;
import exceptions.UserNotFoundException;
import model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        if (userDTO.getFirstName() == null || userDTO.getFirstName().isEmpty() || userDTO.getEmail() == null) {
            throw new InvalidUserDataException("User first name and email cannot be null or empty");
        }
        User user = modelMapper.map(userDTO, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(String id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        if (userDTO.getFirstName() == null || userDTO.getFirstName().isEmpty() || userDTO.getEmail() == null) {
            throw new InvalidUserDataException("User first name and email cannot be null or empty");
        }
        modelMapper.map(userDTO, user);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO getUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
    }
}