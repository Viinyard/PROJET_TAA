package pro.vinyard.project.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pro.vinyard.project.rest.data.CPEnterprise;
import pro.vinyard.project.rest.data.CPLocation;

/**
 * @author VinYarD
 * created : 10/11/2018, 00:51
 */


@RepositoryRestResource(collectionResourceRel = "enterprise", path = "enterprise")
public interface EnterpriseRepository extends PagingAndSortingRepository<CPEnterprise, Long> {


}

