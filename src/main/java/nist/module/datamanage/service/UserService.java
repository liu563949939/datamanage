package nist.module.datamanage.service;

import nist.module.datamanage.entity.UserEntity;
import nist.module.datamanage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    //1.query方法
    public Map<String,Object> getDataList(UserEntity userEntity){
        Map<String,Object> sFhz = new HashMap<String,Object>();
        //1.获得条件
        StringBuilder sCondition = new StringBuilder("select * from s_user where 1 = 1");
        StringBuilder sConditionCount = new StringBuilder("select count(*) from s_user where 1 = 1");
        //2.条件处理
        if(userEntity.getName() != null && !userEntity.getName().equals("")){
            sCondition.append(" and name like '%" + userEntity.getName() + "%'");
            sConditionCount.append(" and name like '" + userEntity.getName() + "'");
        }
        if(userEntity.getUsername() != null && !userEntity.getUsername().equals("")){
            sCondition.append(" and username like '%" + userEntity.getUsername() + "%'");
            sConditionCount.append((" and username like '%" + userEntity.getUsername() + "%'"));
        }
        //3.分页处理
        Integer iEnd = userEntity.getLimit(); //结束
        Integer iStart = (userEntity.getPage()-1)*iEnd; //开始
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
    public UserEntity save(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    //3.delete方法
    public void delete(UserEntity userEntity){
        userRepository.delete(userEntity);
    }

    //4.查询所有
    public List<UserEntity> getDataListAll(String roleId){
        //1.获得条件
        StringBuilder sCondition = new StringBuilder("select * from s_user where 1 = 1");

        //2.语句执行
        Query query = entityManager.createNativeQuery(sCondition.toString(),UserEntity.class);
        List<UserEntity> dataList = query.getResultList(); //查询结果

        //3.判断是否选中(包含角色)
        for(int i=0;i<dataList.size();i++){
            String sFhz = this.isExists(dataList.get(i).getJlbh(),roleId);
            if(sFhz == "1"){
                dataList.get(i).setCheckArr("1");
            }else{
                dataList.get(i).setCheckArr("0");
            }
        }
        //4.结果返回
        return dataList;
    }

    //5.判断是否已存在角色
    public String isExists(String userId, String roleId){
        String sFhz = "0";
        StringBuilder sConditionCount = new StringBuilder("select count(*) from s_user_role where userId = '" + userId + "' and roleId = '" + roleId + "'");
        Query queryCount = entityManager.createNativeQuery(sConditionCount.toString());
        Object obj = queryCount.getSingleResult();
        int i = Integer.valueOf(String.valueOf(obj));
        if(i>0){
            sFhz = "1";
        }
        return sFhz;
    }


    //6.根据用户名和密码查找
    public List<UserEntity> findByName(UserEntity userEntity){
        return userRepository.findByName(userEntity);
    }
}
