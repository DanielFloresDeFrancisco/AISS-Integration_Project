package AISS.GitLabMiner.services;
import AISS.GitLabMiner.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    String baseUri = "https://gitlab.com/api/v4/users";

    public List<User>  getListUsers() {
        User[] users = restTemplate.getForObject(baseUri, User[].class);
        return Arrays.stream(users).toList();
    }

    public List<User> getAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        String token = "glpat-qcx9bNqo6zTYxEzzJdvT";

        if (token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<User[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<User[]> response = restTemplate.exchange(baseUri, HttpMethod.GET, request, User[].class);
        List<User> users = Arrays.stream(response.getBody()).toList();
        return users;
    }

    public User getUserByUsername(String userId) {
        User user = restTemplate.getForObject(baseUri + "/" + userId, User.class);
        return user;
    }

    public User findUserById(String userId) {
        String uri = baseUri + "/" + userId;
        HttpHeaders headers = new HttpHeaders();
        String token = "glpat-qcx9bNqo6zTYxEzzJdvT";

        if (token != "") {
            headers.set("Authorization", "Bearer " + token);
        }
        HttpEntity<User> request = new HttpEntity<>(null, headers);
        ResponseEntity<User> response = restTemplate.exchange(uri, HttpMethod.GET, request, User.class);
        User user = response.getBody();
        return user;
    }

}
