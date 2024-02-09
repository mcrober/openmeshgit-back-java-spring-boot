package ${package}.service;

import ${package}.model.dao.git.GitReposResponse;
import ${package}.model.dao.git.GitResponse;

import org.springframework.http.ResponseEntity;

/**
 * Service for git and deployments utility
 */
public interface GitService {

    /**
     * getRepos
     * @param token token
     * @param paas paas
     * @return GitReposResponse GitReposResponse
     */
    public GitReposResponse[] getRepos(String token,
                           String paas);

    /**
     * Get pom from git and set data
     * @param token pom uri
     * @param gitUri uri
     */
    String getDataGit(String token, String gitUri);

    /**
     * Call git and retry with develop branch if response is reference error
     * @param gitUri uri to call
     * @return response entity
     */
    ResponseEntity<GitResponse> callGitRetryingOnReferenceError(String gitUri, String token);
}
