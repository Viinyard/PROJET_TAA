package pro.vinyard.project.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pro.vinyard.project.rest.data.CPAddress;
import pro.vinyard.project.rest.data.CPAttachment;

/**
 * @author VinYarD
 * created : 10/11/2018, 00:51
 */


@RepositoryRestResource(collectionResourceRel = "address", path = "address")
public interface AddressRepository extends PagingAndSortingRepository<CPAddress, Long> {


}

