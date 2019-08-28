package nist.module.datamanage.controller;

import nist.module.datamanage.entity.DataEntity;
import nist.module.datamanage.entity.RoleEntity;
import nist.module.datamanage.service.DataService;
import nist.module.datamanage.service.RoleServcie;
import nist.module.datamanage.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/role")
@ResponseBody
public class RoleController {
    @Autowired
    private RoleServcie roleServcie;

    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
//    public String test(@RequestBody RoleEntity roleEntity){
    public String test(@Param("name") String name){
        RoleEntity roleEntity = new RoleEntity();
        Map<String,Object> result = roleServcie.getDataList(roleEntity);
        return ResponseUtil.writer("0","success",result.get("dataList"),(Long) result.get("count"));
    }

    @RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
    public String save(@RequestBody RoleEntity roleEntity){
        RoleEntity roleEntity1 = roleServcie.save(roleEntity);
        return ResponseUtil.writer("0","success",roleEntity1);
    }

    @RequestMapping(value = "/del", method = {RequestMethod.GET, RequestMethod.POST})
    public String delete(@RequestBody RoleEntity roleEntity){
        roleServcie.delete(roleEntity);
        return ResponseUtil.writer("0","success");
    }
}
