package AISS.GitLabMiner.services;

import AISS.GitLabMiner.models.InputModels.UserGM;
import AISS.GitLabMiner.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService service;

    @Test //Should fail
    @DisplayName("Get List of User without token")
    void getListUsersNoToken() {
        List<User> users = service.getListUsers();
        assertTrue(users.isEmpty(), "You need a token");
        System.out.println(users.size());
    }

    @Test //Should fail
    @DisplayName("Get User without token")
    void getUserByIdNoToken() {
        User user = service.getUserByUsername("14404225");
        assertTrue(user != null, "You need a token");
        System.out.println(user);
    }

    @Test
    @DisplayName("Get List of User with token")
    void findUsers() {
        List<User> users = service.getAllUsers();
        assertTrue(!users.isEmpty());
        System.out.println(users);
    }

    @Test
    @DisplayName("Get User with token")
    void findUserById() {
        User user = service.findUserById("3593390");
        assertTrue(user.getId() == 3593390, "Wrong user");
        System.out.println(user.toString());
    }


    @Test  // Test for GM Entity
    void UserGMTest() {
        User user = service.findUserById("3593390");
        UserGM sol = new UserGM(user);
        System.out.println(sol.toString());
    }
}