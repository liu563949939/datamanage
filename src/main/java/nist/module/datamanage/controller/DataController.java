package nist.module.datamanage.controller;

import nist.module.datamanage.entity.DataEntity;
import nist.module.datamanage.service.DataService;
import nist.module.datamanage.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/data")
@ResponseBody
public class DataController {
    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
    public String test(@RequestBody DataEntity dataEntity){
        Map<String,Object> result = dataService.getDataList(dataEntity);
        return ResponseUtil.writer("0","success",result.get("dataList"),(Long) result.get("count"));
    }

    @RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
    public String save(@RequestBody DataEntity dataEntity){
        DataEntity dataEntity1 = dataService.save(dataEntity);
        return ResponseUtil.writer("0","success",dataEntity1);
    }

    @RequestMapping(value = "/del", method = {RequestMethod.GET, RequestMethod.POST})
    public String delete(@RequestBody DataEntity dataEntity){
        dataService.delete(dataEntity);
        return ResponseUtil.writer("0","success");
    }
}
