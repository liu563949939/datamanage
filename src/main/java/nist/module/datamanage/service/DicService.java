package nist.module.datamanage.service;

import nist.module.datamanage.entity.DicEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class DicService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<DicEntity> getDicList(DicEntity dicEntity){
        StringBuilder sCondition = new StringBuilder("select * from s_dic where 1 = 1");

        if(dicEntity.getName() != null && !dicEntity.getName().equals("")){
            sCondition.append(" and name = '" + dicEntity.getName() + "'");
        }
        System.out.println(sCondition.toString());
        Query query = entityManager.createNativeQuery(sCondition.toString(), DicEntity.class);
        return query.getResultList(); //查询结果
    }
}
