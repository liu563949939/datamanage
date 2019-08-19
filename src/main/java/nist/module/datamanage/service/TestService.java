package nist.module.datamanage.service;

import nist.module.datamanage.entity.TestEntity;
import nist.module.datamanage.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    @PersistenceContext
    private EntityManager entityManager;

    //save方法
    public void saveTest(TestEntity testEntity){
        TestEntity testEntity1 = testRepository.save(testEntity);
    }

    //query方法
    public Map<String,Object> getTestList(TestEntity testEntity){
        Map<String,Object> sFhz = new HashMap<String,Object>();
        //1.获得条件
        StringBuilder sCondition = new StringBuilder("select * from test");
        StringBuilder sConditionCount = new StringBuilder("select count(*) from test");
        //2.分页处理及条件
        Integer iEnd = testEntity.getLimit(); //结束
        Integer iStart = (testEntity.getPage()-1)*iEnd; //开始
        sCondition.append(" limit " + String.valueOf(iStart) + ", " + String.valueOf(iEnd));
        //3.最终语句
        System.out.println(sCondition.toString());
        Query query = entityManager.createNativeQuery(sCondition.toString(),TestEntity.class);
        Query queryCount = entityManager.createNativeQuery(sConditionCount.toString());
        List<TestEntity> dataList = query.getResultList(); //查询结果
        Object obj = queryCount.getSingleResult();
        Long count = Long.valueOf(String.valueOf(obj));

        //4.组织返回结果
        sFhz.put("dataList",dataList);
        sFhz.put("count",count);
        return sFhz;
    }

}
