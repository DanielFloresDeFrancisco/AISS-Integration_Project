package AISS.GitLabMiner.models.InputModels;

import AISS.GitLabMiner.models.Commit;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "Commit")
public class CommitGM {

    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;

    @JsonProperty("message")
    @Column(columnDefinition="TEXT")
    private String message;
    @JsonProperty("author_name")
    @NotEmpty(message = "Author name cannot be empty.")
    private String authorName;
    @JsonProperty("author_email")
    private String authorEmail;
    @JsonProperty("authored_date")
    @NotEmpty(message = "Author date cannot be empty.")
    private String authoredDate;
    @JsonProperty("committer_name")
    @NotEmpty(message = "Committer name cannot be empty.")
    private String committerName;
    @JsonProperty("committer_email")
    private String committerEmail;

    @JsonProperty("committed_date")
    @NotEmpty(message = "Committer date cannot be empty.")
    private String committedDate;

    @JsonProperty("web_url")
    @NotEmpty(message = "URL cannot be empty." +
            "")
    private String webUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthoredDate() {
        return authoredDate;
    }

    public void setAuthoredDate(String authoredDate) {
        this.authoredDate = authoredDate;
    }

    public String getCommitterName() {
        return committerName;
    }

    public void setCommitterName(String committerName) {
        this.committerName = committerName;
    }

    public String getCommitterEmail() {
        return committerEmail;
    }

    public void setCommitterEmail(String committerEmail) {
        this.committerEmail = committerEmail;
    }

    public String getCommittedDate() {
        return committedDate;
    }

    public void setCommittedDate(String committedDate) {
        this.committedDate = committedDate;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public CommitGM(String id, String title, String message, String authorName, String authorEmail,
                    String authoredDate, String committerName, String committerEmail, String committedDate, String webUrl) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.authoredDate = authoredDate;
        this.committerName = committerName;
        this.committerEmail = committerEmail;
        this.committedDate = committedDate;
        this.webUrl = webUrl;
    }

    public CommitGM (Commit commit) {
          this.id = commit.getId();
          this.title= commit.getTitle();
          this.message = commit.getMessage();
          this.authorName = commit.getAuthorName();
          this.authorEmail = commit.getAuthorEmail();
          this.authoredDate = commit.getAuthoredDate();
          this.committerName = commit.getCommitterName();
          this.committerEmail = commit.getCommitterEmail();
          this.committedDate = commit.getCommittedDate();
          this.webUrl = commit.getWebUrl();
    }
}
