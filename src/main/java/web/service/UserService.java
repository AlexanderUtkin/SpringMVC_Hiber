package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public String saveUser(User user);
    public User getUserById(Long id);
    public void updateUser(User user);
    public void deleteUser(Long id);
}
