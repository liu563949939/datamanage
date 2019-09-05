package nist.module.datamanage.controller;

import nist.module.datamanage.entity.ModuleEntity;
import nist.module.datamanage.service.ModuleService;
import nist.module.datamanage.service.UserService;
import nist.module.datamanage.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/module")
@ResponseBody
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @RequestMapping(value = "/query",method = {RequestMethod.GET,RequestMethod.POST})
    public String query(@RequestBody ModuleEntity moduleEntity){
        Map<String,Object> result = moduleService.getDataList(moduleEntity);
        return ResponseUtil.writer("0","success",result.get("dataList"),(Long) result.get("count"));
    }

    @RequestMapping(value = "/save",method = {RequestMethod.GET, RequestMethod.POST})
    public String save (@RequestBody ModuleEntity moduleEntity){
        ModuleEntity moduleEntity1 = moduleService.save(moduleEntity);
        return ResponseUtil.writer("0","success", moduleEntity1);
    }

    @RequestMapping(value = "/delete",method = {RequestMethod.GET, RequestMethod.POST})
    public String delete(@RequestBody ModuleEntity moduleEntity){
        moduleService.delete(moduleEntity);
        return ResponseUtil.writer("0","success");
    }

    @RequestMapping(value = "/queryAll",method = {RequestMethod.GET,RequestMethod.POST})
    public String queryAll(@Param("roleId") String roleId){
        return ResponseUtil.writer("0","success",moduleService.getModuleListAll(roleId));
    }

}
