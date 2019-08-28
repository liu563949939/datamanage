package nist.module.datamanage.repository;

import nist.module.datamanage.entity.ResourceEntity;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<ResourceEntity, String> {
}
