package nist.module.datamanage.service;

import nist.module.datamanage.entity.UserRoleEntity;
import nist.module.datamanage.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public UserRoleEntity save(UserRoleEntity userRoleEntity){
        return userRoleRepository.save(userRoleEntity);
    }

    public void del(UserRoleEntity userRoleEntity){
        userRoleRepository.del(userRoleEntity.getRoleId());
    }
}
