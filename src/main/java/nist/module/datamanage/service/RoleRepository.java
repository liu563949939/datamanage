package nist.module.datamanage.service;

import nist.module.datamanage.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

import javax.management.relation.RoleNotFoundException;

public interface RoleRepository extends CrudRepository<RoleEntity, String> {
}
