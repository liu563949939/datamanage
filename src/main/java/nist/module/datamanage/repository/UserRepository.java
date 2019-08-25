package nist.module.datamanage.repository;

import nist.module.datamanage.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
