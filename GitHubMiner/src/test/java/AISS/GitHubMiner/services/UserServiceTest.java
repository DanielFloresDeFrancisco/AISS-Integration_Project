package AISS.GitHubMiner.services;

import AISS.GitHubMiner.models.InputModels.UserGM;
import AISS.GitHubMiner.models.User;
import org.junit.jupiter.api.Disabled;
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

    @Test
    @DisplayName("Get all users")
    void findAllUsers() {
        List<User> users = service.getAllUsers();
        assertTrue(!users.isEmpty(), "The list of users is empty");
        System.out.println(users);
    }

    @Test
    @DisplayName("Find the my user in GitHub")
    void findAnUser() {
        String username = "DanielFloresDeFrancisco";
        User user = service.getAnUser(username);
        assertTrue(user.getLogin().equals(username));
        System.out.println(user);

    }

    @Test //Test for GM Entity
    void UserGMTest() {
        User user = service.getAnUser("DanielFloresDeFrancisco");
        UserGM sol = new UserGM(user);
        System.out.println(sol.toString());
    }
}