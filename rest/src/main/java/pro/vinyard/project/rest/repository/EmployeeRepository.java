package pro.vinyard.project.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pro.vinyard.project.rest.data.CPEmployee;

/**
 * @author VinYarD
 * created : 14/03/2018, 01:56
 */

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends PagingAndSortingRepository<CPEmployee, Long> {


}
