package AISS.GitHubMiner.models.InputModels;

import AISS.GitHubMiner.models.Commit;
import AISS.GitHubMiner.models.Issue;
import AISS.GitHubMiner.models.Repositorio;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Project")
public class ProjectGM {

    @Id
    @JsonProperty("id")
    public String id;

    @JsonProperty("name")
    @NotEmpty(message = "The name of the project cannot be empty")
    public String name;

    @JsonProperty("web_url")
    @NotEmpty(message = "The URL of the project cannot be empty")
    public String webUrl;
    @JsonProperty("commits")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId")
    private List<CommitGM> commits;

    @JsonProperty("issues")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId")
    private List<IssueGM> issues;

    public ProjectGM() {
        commits = new ArrayList<>();
        issues = new ArrayList<>();
    }

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

    public ProjectGM (Repositorio repo, List<Commit> commits, List<Issue> issues) {
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
            iSol.add(new IssueGM(i, repo.getOwner().getLogin(), repo.getName()));
        }
        this.issues = iSol;
    }
}
