package nist.module.datamanage.service;

import nist.module.datamanage.entity.RoleModuleEntity;
import nist.module.datamanage.repository.RoleModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleModuleService {
    @Autowired
    private RoleModuleRepository roleModuleRepository;

    public RoleModuleEntity save(RoleModuleEntity roleModuleEntity){
        return roleModuleRepository.save(roleModuleEntity);
    }

    public void del(String roleId){
        roleModuleRepository.del(roleId);
    }
}
