package AISS.GitLabMiner.services;

import AISS.GitLabMiner.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;

    String baseUri = "https://gitlab.com/api/v4/projects";

    public List<Project> getAllProjects() {
        Project[] p = restTemplate.getForObject(baseUri, Project[].class);
        return Arrays.stream(p).toList();
    }

    public Project getOneProject(String projectId) {
        Project p = restTemplate.getForObject(baseUri + "/" + projectId, Project.class);
        return p;
    }
}
