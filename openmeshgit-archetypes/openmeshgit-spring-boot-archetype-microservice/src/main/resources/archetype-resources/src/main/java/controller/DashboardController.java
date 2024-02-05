package ${package}.controller;


import com.fasterxml.jackson.databind.JsonNode;
import ${package}.service.OcpService;
import ${package}.service.GitService;
import ${package}.model.dao.git.Deployment;
import ${package}.model.dao.git.GitRepos;
import ${package}.jpa.DeploymentJpaRepository;
import ${package}.jpa.GitJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
class DashboardController {

    @Autowired
    private OcpService ocpService;

    @Autowired
    private DeploymentJpaRepository deploymentRepository;

    @Autowired
    private GitService gitService;

    @Autowired
    private GitJpaRepository gitRepository;

    /**
     * framework
     * @return
     * @throws IOException
     */
    @GetMapping("/framework")
    List<Deployment> framework (@RequestHeader String token   ) throws IOException {

        List<Deployment> deployments = deploymentRepository.findAll();
        StringBuilder result = new StringBuilder();

        for (Deployment deployment : deployments) {
            log.info(deployment.getDeployName());
            GitRepos gitRepos = gitRepository.findByRepoName(deployment.getDeployName());

            if (gitRepos != null) {
                String frameworkVersion = gitService.getDataGit(token, gitRepos.getReposUrl());
                deployment.setFrameworkVersion(frameworkVersion);
                deploymentRepository.saveAndFlush(deployment);
                result.append(gitService.getDataGit(token, gitRepos.getReposUrl()  ));
            }
        }
        return deploymentRepository.findAll();
    }
}
