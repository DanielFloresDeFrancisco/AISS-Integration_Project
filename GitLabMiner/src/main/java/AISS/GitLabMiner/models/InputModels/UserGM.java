package AISS.GitLabMiner.models.InputModels;

import AISS.GitLabMiner.models.Assignee;
import AISS.GitLabMiner.models.Author;
import AISS.GitLabMiner.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import java.util.Locale;

@Entity
@Table(name = "GMUser")     // Watch out: User is a reserved keyword in H2
public class UserGM {

    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("username")
    @NotEmpty(message = "The username cannot be empty")
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

    public UserGM( String id, String username, String name, String avatarUrl, String webUrl) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.webUrl = webUrl;

    }

    public UserGM (User user) {
        this.id = user.getId().toString();
        this.username = user.getUsername();
        this.name = user.getName();
        this.avatarUrl = user.getAvatarUrl();
        this.webUrl = user.getWebUrl();

    }

    public UserGM(Author author) {
        this.id = author.getId().toString();
        this.username = author.getUsername();
        this.name = author.getName();
        this.avatarUrl = author.getAvatarUrl();
        this.webUrl = author.getWebUrl();
    }

    public  UserGM(Assignee assignee) {
        this.id = assignee.getId().toString();
        this.username = assignee.getUsername();
        this.name = assignee.getName();
        this.avatarUrl = assignee.getAvatarUrl();
        this.webUrl = assignee.getWebUrl();
    }

    public static UserGM createAssignee(Assignee assignee) {
        UserGM sol = null;
        if (assignee != null) {
            sol = new UserGM(assignee);
        }
        return sol;
    }
}
