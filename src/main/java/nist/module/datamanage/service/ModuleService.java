package nist.module.datamanage.service;

import nist.module.datamanage.entity.ModuleEntity;
import nist.module.datamanage.entity.UserEntity;
import nist.module.datamanage.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;

    @PersistenceContext
    private EntityManager entityManager;

    //1.query方法
    public Map<String,Object> getDataList(ModuleEntity moduleEntity){
        Map<String,Object> sFhz = new HashMap<String,Object>();
        //1.获得条件
        StringBuilder sCondition = new StringBuilder("select * from s_module where 1 = 1");
        StringBuilder sConditionCount = new StringBuilder("select count(*) from s_module where 1 = 1");
        //2.条件处理
        if(moduleEntity.getName() != null && !moduleEntity.getName().equals("")){
            sCondition.append(" and name like '%" + moduleEntity.getName() + "%'");
            sConditionCount.append(" and name like '" + moduleEntity.getName() + "'");
        }
        //3.分页处理
        Integer iEnd = moduleEntity.getLimit(); //结束
        Integer iStart = (moduleEntity.getPage()-1)*iEnd; //开始
        sCondition.append(" limit " + String.valueOf(iStart) + ", " + String.valueOf(iEnd));
        //4.语句执行
        Query query = entityManager.createNativeQuery(sCondition.toString(),UserEntity.class);
        Query queryCount = entityManager.createNativeQuery(sConditionCount.toString());
        List<UserEntity> dataList = query.getResultList(); //查询结果
        Object obj = queryCount.getSingleResult();
        Long count = Long.valueOf(String.valueOf(obj));

        //5.组织返回结果
        sFhz.put("dataList",dataList);
        sFhz.put("count",count);
        return sFhz;
    }

    //2.save方法
    public ModuleEntity save(ModuleEntity moduleEntity){
        return moduleRepository.save(moduleEntity);
    }

    //3.delete方法
    public void delete(ModuleEntity moduleEntity){
        moduleRepository.delete(moduleEntity);
    }
}
