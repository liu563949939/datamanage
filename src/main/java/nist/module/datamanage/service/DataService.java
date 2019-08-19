package nist.module.datamanage.service;

import nist.module.datamanage.entity.DataEntity;
import nist.module.datamanage.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataService {
    @Autowired
    private DataRepository dataRepository;

    @PersistenceContext
    private EntityManager entityManager;

    //1.query方法
    public Map<String,Object> getDataList(DataEntity dataEntity){
        Map<String,Object> sFhz = new HashMap<String,Object>();
        //1.获得条件
        StringBuilder sCondition = new StringBuilder("select * from t_data");
        StringBuilder sConditionCount = new StringBuilder("select count(*) from t_data");
        //2.分页处理及条件
        Integer iEnd = dataEntity.getLimit(); //结束
        Integer iStart = (dataEntity.getPage()-1)*iEnd; //开始
        sCondition.append(" limit " + String.valueOf(iStart) + ", " + String.valueOf(iEnd));
        //3.最终语句
        System.out.println(sCondition.toString());
        Query query = entityManager.createNativeQuery(sCondition.toString(),DataEntity.class);
        Query queryCount = entityManager.createNativeQuery(sConditionCount.toString());
        List<DataEntity> dataList = query.getResultList(); //查询结果
        Object obj = queryCount.getSingleResult();
        Long count = Long.valueOf(String.valueOf(obj));

        //4.组织返回结果
        sFhz.put("dataList",dataList);
        sFhz.put("count",count);
        return sFhz;
    }

    //2.save方法
    public DataEntity save(DataEntity dataEntity){
        return dataRepository.save(dataEntity);
    }
}
