package nist.module.datamanage.controller;

import nist.module.datamanage.entity.TestEntity;
import nist.module.datamanage.service.TestService;
import nist.module.datamanage.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
    public String test(@RequestBody TestEntity testEntity){
        Map<String,Object> result = testService.getTestList(testEntity);
        return ResponseUtil.writer("1","success",result.get("dataList"),(Long) result.get("count"));
    }
}
