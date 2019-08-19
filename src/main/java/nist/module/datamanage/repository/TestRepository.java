package nist.module.datamanage.repository;

import nist.module.datamanage.entity.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<TestEntity,String> {

}
