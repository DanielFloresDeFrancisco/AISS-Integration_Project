package AISS.GitLabMiner.services;

import AISS.GitLabMiner.models.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProjectServiceTest {

    @Autowired
    ProjectService service;

    @Test
    void getAllProjects() {
        List<Project> projects = service.getAllProjects();
        assertTrue(!projects.isEmpty());
        System.out.println(projects.size());
    }

    @Test
    void getOneProject() {
        Project p = service.getOneProject("10993694");
        System.out.println(p.toString());
    }
}