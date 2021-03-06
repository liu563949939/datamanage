package nist.module.datamanage.service.po;

import nist.module.datamanage.entity.DataEntity;
import nist.module.datamanage.entity.RoleEntity;
import nist.module.datamanage.entity.po.UserRolePoEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserRolePoService {
    @PersistenceContext
    private EntityManager entityManager;

    //1.query方法
    public Map<String,Object> getDataList(RoleEntity roleEntity){
        Map<String,Object> sFhz = new HashMap<String,Object>();
        //1.获得条件
        StringBuilder sCondition = new StringBuilder("select t.jlbh,t.userId,t.roleId,t.createTime,v.name From s_user_role t,s_user v where t.userId = v.jlbh and 1 = 1");
//        StringBuilder sConditionCount = new StringBuilder("select t.jlbh,t.userId,t.roleId,t.createTime,v.name From s_user_role t,s_user v where t.userId = v.jlbh and 1 = 1");
        //2.条件处理
        if(roleEntity.getJlbh() != null && !roleEntity.getJlbh().equals("")){
            sCondition.append(" and roleId = '" + roleEntity.getJlbh() + "'");
//            sConditionCount.append(" and roleId = " + roleEntity.getJlbh());
        }
        //3.分页处理
        Integer iEnd = roleEntity.getLimit(); //结束
        Integer iStart = (roleEntity.getPage()-1)*iEnd; //开始
        sCondition.append(" limit " + String.valueOf(iStart) + ", " + String.valueOf(iEnd));
        System.out.println(sCondition.toString());
//        System.out.println(sConditionCount.toString());
        System.out.println(UserRolePoEntity.class);
        //4.语句执行
        Query query = entityManager.createNativeQuery(sCondition.toString(), UserRolePoEntity.class);
//        Query queryCount = entityManager.createNativeQuery(sConditionCount.toString());
        List<DataEntity> dataList = query.getResultList(); //查询结果
//        Object obj = queryCount.getSingleResult();
//        Long count = Long.valueOf(String.valueOf(obj));

        //5.组织返回结果
        sFhz.put("dataList",dataList);
        sFhz.put("count",0L);
        return sFhz;
    }

}
