package nist.module.datamanage.controller;

import nist.module.datamanage.entity.RoleEntity;
import nist.module.datamanage.entity.RoleModuleEntity;
import nist.module.datamanage.service.RoleModuleService;
import nist.module.datamanage.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/roleModule")
@ResponseBody
public class RoleModuleController {
    @Autowired
    private RoleModuleService roleModuleService;

    /**
     * 1.保存(修改)
     */
    @RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
    public String save(@RequestBody RoleModuleEntity roleModuleEntity){
        RoleModuleEntity roleModuleEntity1 = roleModuleService.save(roleModuleEntity);
        return ResponseUtil.writer("0","success",roleModuleEntity1);
    }


    /**
     * 2.根据roleId删除
     * @param roleModuleEntity
     * @return
     */
    @RequestMapping(value = "/del", method = {RequestMethod.GET, RequestMethod.POST})
    public String del(@RequestBody RoleModuleEntity roleModuleEntity){
        roleModuleService.del(roleModuleEntity.getRoleId());
        return ResponseUtil.writer("0","success");
    }
}

