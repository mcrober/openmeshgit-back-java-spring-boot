package ${package}.service;


import com.fasterxml.jackson.databind.JsonNode;


import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import io.fabric8.openshift.api.model.DeploymentConfigList;
import org.barmanyrober.model.dao.git.Deployment;

/**
 * Class to obtein info from Openshift API
 */

public interface OcpService {


    /**
     * getAllDeploymentsConfig
     *
     * @param token token
     * @param paas paas
     * @param namespace namespace
     * @return DeploymentConfigList
     */
    DeploymentConfigList getAllDeploymentsConfig(String token, String paas, String namespace);

    /**
     * getAllStatefulSets
     *
     * @param token token
     * @param paas paas
     * @param namespace namespace
     * @return JsonNode
     * @throws IOException IOException
     */
    JsonNode getAllStatefulSets(String token, String paas, String namespace) throws IOException;


    /**
     * getAllDeployments
     *
     * @param token token
     * @param paas paas
     * @param namespace namespace
     * @return List<Deployment> List<Deployment>
     * @throws IOException IOException
     */
    List<Deployment> getAllDeployments (String token, String paas, String namespace) throws IOException;
}