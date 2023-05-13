package AISS.GitHubMiner.models.InputModels;

import AISS.GitHubMiner.models.Assignee;
import AISS.GitHubMiner.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

    // Watch out: User is a reserved keyword in H2
public class UserGM {

    @JsonProperty("id")
    private String id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("name")
    private String name;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("web_url")
    private String webUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public UserGM () {}

    public UserGM (User user) {
        this.id = user.getId().toString();
        this.username = user.getLogin();
        this.name = user.getName();
        this.avatarUrl = user.getAvatarUrl();
        this.webUrl = user.getUrl();

    }

    public  UserGM(Assignee assignee) {
        this.id = assignee.getId().toString();
        this.username = assignee.getLogin();
        this.name = assignee.getName();
        this.avatarUrl = assignee.getAvatarUrl();
        this.webUrl = assignee.getUrl();
    }

        @Override
        public String toString() {
            return "UserGM{" +
                    "id='" + id + '\'' +
                    ", username='" + username + '\'' +
                    ", name='" + name + '\'' +
                    ", avatarUrl='" + avatarUrl + '\'' +
                    ", webUrl='" + webUrl + '\'' +
                    '}';
        }
    }
