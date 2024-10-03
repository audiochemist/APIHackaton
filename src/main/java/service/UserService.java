package service;

import dto.UserDTO;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    UserDTO updateUser(String id, UserDTO userDTO);
    UserDTO getUser(String id);
    void deleteUser(String id);
}