package AISS.GitHubMiner.models.InputModels;

import AISS.GitHubMiner.models.Comment;
import AISS.GitHubMiner.models.Commit;
import AISS.GitHubMiner.models.Issue;
import AISS.GitHubMiner.models.Repositorio;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    public ProjectGM (Repositorio repo, List<Commit> commits, List<Issue> issues, Map<Integer, List<Comment>> issueCom) {
        this.id = repo.getId().toString();
        this.name = repo.getName();
        this.webUrl = repo.getUrl();

        List<CommitGM> cSol = new ArrayList<>();
        for (Commit c: commits) {
            cSol.add(new CommitGM(c));
        }
        this.commits = cSol;

        List<IssueGM> iSol = new ArrayList<>();
        for (Issue i: issues) {
            iSol.add(new IssueGM(i, issueCom.get(i.getId())));
        }
        this.issues = iSol;
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
