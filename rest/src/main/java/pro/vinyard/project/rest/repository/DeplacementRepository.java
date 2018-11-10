package pro.vinyard.project.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pro.vinyard.project.rest.data.CPDeplacement;
import pro.vinyard.project.rest.data.CPEnterprise;

/**
 * @author VinYarD
 * created : 10/11/2018, 00:51
 */


@RepositoryRestResource(collectionResourceRel = "deplacement", path = "deplacement")
public interface DeplacementRepository extends PagingAndSortingRepository<CPDeplacement, Long> {


}

