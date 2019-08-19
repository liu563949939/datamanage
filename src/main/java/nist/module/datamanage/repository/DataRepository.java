package nist.module.datamanage.repository;

import nist.module.datamanage.entity.DataEntity;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<DataEntity,String> {
}
