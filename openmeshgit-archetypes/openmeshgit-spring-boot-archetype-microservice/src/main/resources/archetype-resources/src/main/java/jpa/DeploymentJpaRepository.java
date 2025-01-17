package ${package}.jpa;

import ${package}.model.dao.git.Deployment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DeploymentJpaRepository extends JpaRepository<Deployment, Long> {

	Deployment findByDeployName(String deployName);

	void deleteById(long id) ;

}

