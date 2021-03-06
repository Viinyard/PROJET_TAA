package pro.vinyard.project.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pro.vinyard.project.rest.data.CPAttachment;
import pro.vinyard.project.rest.data.CPCar;

/**
 * @author VinYarD
 * created : 10/11/2018, 00:51
 */


@RepositoryRestResource(collectionResourceRel = "attachment", path = "attachment")
public interface AttachmentRepository extends PagingAndSortingRepository<CPAttachment, Long> {


}

