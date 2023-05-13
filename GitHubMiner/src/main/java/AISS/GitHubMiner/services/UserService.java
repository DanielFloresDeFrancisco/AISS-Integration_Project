package AISS.GitHubMiner.services;

import AISS.GitHubMiner.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public List<User> getAllUsers() {
        String uri = "https://api.github.com/users";
        User[] users = restTemplate.getForObject(uri, User[].class);
        return Arrays.stream(users).toList();
    }

    public User getAnUser(String username ) {
        User user = null;
        String uri = "https://api.github.com/users/" + username;
        user = restTemplate.getForObject(uri, User.class);
        return user;
    }
}
