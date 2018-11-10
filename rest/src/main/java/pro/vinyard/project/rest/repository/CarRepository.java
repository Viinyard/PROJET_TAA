package pro.vinyard.project.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pro.vinyard.project.rest.data.CPCar;
import pro.vinyard.project.rest.data.CPDeplacement;

/**
 * @author VinYarD
 * created : 10/11/2018, 00:51
 */


@RepositoryRestResource(collectionResourceRel = "car", path = "car")
public interface CarRepository extends PagingAndSortingRepository<CPCar, Long> {


}

