package AISS.GitHubMiner.models.InputModels;

import AISS.GitHubMiner.models.Comment;
import AISS.GitHubMiner.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Comment")
public class CommentGM {

    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("body")
    @NotEmpty(message = "The message cannot be empty.")
    @Column(columnDefinition="TEXT")
    private String body;

    @JsonProperty("author")
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @OneToOne(cascade=CascadeType.ALL)
    private UserGM author;

    @JsonProperty("created_at")
    @NotEmpty(message = "The field created_at cannot be empty.")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserGM getAuthor() {
        return author;
    }

    public void setAuthor(UserGM author) {
        this.author = author;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


    public CommentGM (Comment comment) {
        this.id = comment.getId().toString();
        this.body = comment.getBody();
        this.author = new UserGM(comment.getUser());
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }
}
