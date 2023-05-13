package AISS.GitLabMiner.models.InputModels;

import AISS.GitLabMiner.models.Comment;
import AISS.GitLabMiner.models.Commit;
import AISS.GitLabMiner.models.Issue;
import AISS.GitLabMiner.models.Project;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ProjectGM {


    @JsonProperty("id")
    public String id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("web_url")
    public String webUrl;
    @JsonProperty("commits")
    private List<CommitGM> commits;

    @JsonProperty("issues")
    private List<IssueGM> issues;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public List<CommitGM> getCommits() {
        return commits;
    }

    public void setCommits(List<CommitGM> commits) {
        this.commits = commits;
    }

    public List<IssueGM> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueGM> issues) {
        this.issues = issues;
    }

    public ProjectGM () {}

    public ProjectGM (Project project, List<Commit> commits, List<Issue> issues,
                      Map<Integer, List<Comment>> lCom) {
        this.id = project.getId().toString();
        this.name = project.getName();
        this.webUrl = project.getWebUrl();

        List<CommitGM> lCommits = new ArrayList<>();
        for (Commit c: commits){
            lCommits.add(new CommitGM(c));
        }
        this.commits = lCommits;

        List<IssueGM> lIssues = new ArrayList<>();
        for (Issue i: issues) {
            lIssues.add(new IssueGM(i, lCom.get(i.getId())));
        }
        this.issues = lIssues;
    }

    @Override
    public String toString() {
        return "ProjectGM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", commits=" + commits +
                ", issues=" + issues +
                '}';
    }
}
