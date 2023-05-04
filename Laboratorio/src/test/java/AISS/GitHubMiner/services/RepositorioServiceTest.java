package AISS.GitHubMiner.services;

import AISS.GitHubMiner.models.Repositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RepositorioServiceTest {

    @Autowired
    RepositorioService service;

    @Test
    void findRepository() {
        Repositorio repos = service.findRepository("Hello-World", "octocat");
        System.out.println(repos);
    }
}