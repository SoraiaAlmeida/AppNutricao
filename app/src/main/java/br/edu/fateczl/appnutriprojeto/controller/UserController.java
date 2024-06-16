package br.edu.fateczl.appnutriprojeto.controller;


import android.content.Context;
import br.edu.fateczl.appnutriprojeto.model.User;
import br.edu.fateczl.appnutriprojeto.persistence.UserDAO;

public class UserController {
    private UserDAO userDAO;

    public UserController(Context context) {
        userDAO = new UserDAO(context);
    }

    public long registerUser(User user) throws Exception {
        if (user.getLogin().isEmpty() || user.getPassword().isEmpty()) {
            throw new Exception("Login e senha são obrigatórios.");
        }
        return userDAO.addUser(user);
    }

    public User loginUser(String login, String password) throws Exception {
        if (login.isEmpty() || password.isEmpty()) {
            throw new Exception("Login e senha são obrigatórios.");
        }
        User user = userDAO.getUser(login, password);
        if (user == null) {
            throw new Exception("Usuário não encontrado.");
        }
        return user;
    }

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
}
