package AISS.GitLabMiner.models.InputModels;

import AISS.GitLabMiner.models.Comment;
import AISS.GitLabMiner.models.Issue;
import AISS.GitLabMiner.services.CommentService;
import AISS.GitLabMiner.services.CommitService;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Issue")
public class IssueGM {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("ref_id")
    private String refId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    @Column(columnDefinition = "TEXT")
    private String description;
    @JsonProperty("state")
    private String state;

    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("closed_at")
    private String closedAt;
    @JsonProperty("labels")
    @ElementCollection
    private List<String> labels;
    @JsonProperty("author")
    //@NotEmpty(message = "The author of the issue cannot be empty")
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private UserGM author;
    @JsonProperty("assignee")
    @JoinColumn(name = "assignee_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private UserGM assignee;
    @JsonProperty("upvotes")
    private Integer upvotes;
    @JsonProperty("downvotes")
    private Integer downvotes;

    @JsonProperty("web_url")
    private String webUrl;

    @JsonProperty("comments")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "issueId")
    private List<CommentGM> comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public UserGM getAuthor() {
        return author;
    }

    public void setAuthor(UserGM author) {
        this.author = author;
    }

    public UserGM getAssignee() {
        return assignee;
    }

    public void setAssignee(UserGM assignee) {
        this.assignee = assignee;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public List<CommentGM> getComments() {
        return comments;
    }

    public void setComments(List<CommentGM> comments) {
        this.comments = comments;
    }

    @Autowired
    CommentService service;

    public IssueGM(Issue issue, String projectId) {

        this.id = issue.getId().toString();
        this.refId = issue.getIid().toString();
        this.title = issue.getTitle();
        this.description = issue.getDescription();
        this.state = issue.getState();
        this.createdAt = issue.getCreatedAt();
        this.updatedAt = issue.getUpdatedAt();
        this.closedAt = issue.getClosedAt().toString();
        this.labels = getLabels();
        this.author = new UserGM(issue.getAuthor());
        this.assignee = new UserGM(issue.getAssignee());
        this.upvotes = issue.getUpvotes();
        this.downvotes = issue.getDownvotes();
        this.webUrl = issue.getWebUrl();

        List<Comment> comments = service.findCommentsOfIssue(projectId, issue.getIid().toString());

        List<CommentGM> lComment = new ArrayList<>();
        for ( Comment c: comments) {
            lComment.add(new CommentGM(c));
        }

        this.comments = lComment;

    }
}


