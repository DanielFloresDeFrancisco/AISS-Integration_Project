package AISS.GitHubMiner.services;

import AISS.GitHubMiner.models.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RepositorioService {

    @Autowired
    RestTemplate restTemplate;

    public Repositorio findRepository(String reposName, String owner) {
        Repositorio repos = null;
        String uri = "https://api.github.com/repos/" + owner + "/" + reposName;
        repos = restTemplate.getForObject(uri, Repositorio.class);
        return repos;
    }
}
