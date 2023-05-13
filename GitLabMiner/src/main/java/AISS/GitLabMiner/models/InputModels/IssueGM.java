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


public class IssueGM {

    @JsonProperty("id")
    private String id;

    @JsonProperty("ref_id")
    private String refId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
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
    private UserGM author;
    @JsonProperty("assignee")
    private UserGM assignee;
    @JsonProperty("upvotes")
    private Integer upvotes;
    @JsonProperty("downvotes")
    private Integer downvotes;

    @JsonProperty("web_url")
    private String webUrl;

    @JsonProperty("comments")
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

    public IssueGM () {}
    public IssueGM(Issue issue, List<Comment> lCom) {

        this.id = issue.getId().toString();
        this.refId = issue.getIid().toString();
        this.title = issue.getTitle();
        this.description = issue.getDescription();
        this.state = issue.getState();
        this.createdAt = issue.getCreatedAt();
        this.updatedAt = issue.getUpdatedAt();
        if (issue.getClosedAt() == null) {
            this.closedAt = "Open";
        } else {
            this.closedAt = issue.getClosedAt().toString();
        }
        if (issue.getLabels() == null) {
            this.labels = new ArrayList<>();
        } else {
            this.labels = issue.getLabels();
        }
        this.author = new UserGM(issue.getAuthor());
        if (issue.getAssignee() == null) {
            this.assignee = null;
        } else {
            this.assignee = new UserGM(issue.getAssignee());
        }
        this.upvotes = issue.getUpvotes();
        this.downvotes = issue.getDownvotes();
        this.webUrl = issue.getWebUrl();

        List<CommentGM> lComment = new ArrayList<>();
        for (Comment c: lCom) {
            lComment.add(new CommentGM(c));
        }

        this.comments = lComment;

    }

    @Override
    public String toString() {
        return "IssueGM{" +
                "id='" + id + '\'' +
                ", refId='" + refId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", closedAt='" + closedAt + '\'' +
                ", labels=" + labels +
                ", author=" + author +
                ", assignee=" + assignee +
                ", upvotes=" + upvotes +
                ", downvotes=" + downvotes +
                ", webUrl='" + webUrl + '\'' +
                ", comments=" + comments +
                '}';
    }
}


