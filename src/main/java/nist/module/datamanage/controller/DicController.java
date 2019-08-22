package nist.module.datamanage.controller;

import nist.module.datamanage.entity.DicEntity;
import nist.module.datamanage.service.DicService;
import nist.module.datamanage.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dic")
@ResponseBody
public class DicController {
    @Autowired
    private DicService dicService;

    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
    public String getDicList(@RequestBody DicEntity dicEntity){
        List<DicEntity> dataList = dicService.getDicList(dicEntity);
        return ResponseUtil.writer("0","success",dataList);
    }
}
