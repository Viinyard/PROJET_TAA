package pro.vinyard.project.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pro.vinyard.project.rest.data.CPLocation;
import pro.vinyard.project.rest.data.CPPhoneNumber;

/**
 * @author VinYarD
 * created : 10/11/2018, 00:51
 */


@RepositoryRestResource(collectionResourceRel = "location", path = "location")
public interface LocationRepository extends PagingAndSortingRepository<CPLocation, Long> {


}

