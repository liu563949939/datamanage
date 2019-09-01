package nist.module.datamanage.repository;

import nist.module.datamanage.entity.ModuleEntity;
import org.springframework.data.repository.CrudRepository;

public interface ModuleRepository extends CrudRepository<ModuleEntity, String> {
}
