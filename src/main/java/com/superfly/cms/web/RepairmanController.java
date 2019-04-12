package com.superfly.cms.web;

import com.alibaba.fastjson.JSON;
import com.superfly.cms.entity.Repairman;
import com.superfly.cms.service.RepairmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/repairman")
public class RepairmanController {
    @Autowired
    private RepairmanService repairmanService;
    
    /**
     * 根据Id获取一个维修人员信息
     *
     * @param repairmanId
     * @return
     */
    @RequestMapping(value = "/getrepairmanbyid", method = RequestMethod.GET)
    private Map<String, Object> getRepairmanById(Integer repairmanId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Repairman repairman = repairmanService.getRepairmanById(repairmanId);
        modelMap.put("Repairman", repairman);
        return modelMap;
    }

    /**
     * 注册一个维修人员
     *
     * @param jsonString
     * @return success:true
     */
    @RequestMapping(value = "/addrepairman", method = RequestMethod.POST)
    private Map<String, Object> addRepairman(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Repairman repairman = JSON.toJavaObject((JSON) map.get("Repairman"), com.superfly.cms.entity.Repairman.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", repairmanService.addRepairman(repairman));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 通过姓名登录
     *
     * @param repairmanName
     * @param repairmanPassword
     * @return success:true else:false
     */
    @RequestMapping(value = "/loginbyname", method = RequestMethod.POST)
    private Map<String, Object> loginRepairmanByName(String repairmanName, String repairmanPassword) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", repairmanService.loginRepairmanByName(repairmanName, repairmanPassword));
        return modelMap;
    }

    /**
     * 通过手机登录
     *
     * @param repairmanPhone
     * @param repairmanPassword
     * @return success:true else:false
     */
    @RequestMapping(value = "/loginbyphone", method = RequestMethod.POST)
    private Map<String, Object> loginRepairmanByPhone(String repairmanPhone, String repairmanPassword) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", repairmanService.loginRepairmanByPhone(repairmanPhone, repairmanPassword));
        return modelMap;
    }

    /**
     * 通过邮箱登录
     *
     * @param repairmanEmail
     * @param repairmanPassword
     * @return success:true else:false
     */
    @RequestMapping(value = "/loginbyemail", method = RequestMethod.POST)
    private Map<String, Object> loginRepairmanByEmail(String repairmanEmail, String repairmanPassword) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", repairmanService.loginRepairmanByEmail(repairmanEmail, repairmanPassword));
        return modelMap;
    }
    /**
     * 更新用户信息
     *
     * @param jsonString 维修人员信息
     * @return success：true or false
     */
    @RequestMapping(value = "/modifyrepairman", method = RequestMethod.POST)
    private Map<String, Object> modifyRepairman(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Repairman repairman = JSON.toJavaObject((JSON) map.get("Repairman"), com.superfly.cms.entity.Repairman.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", repairmanService.modifyRepairman(repairman));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 注销维修人员信息
     *
     * @param repairmanId
     * @return success:true else:false
     */
    @RequestMapping(value = "/removerepairman", method = RequestMethod.GET)
    private Map<String, Object> removeRepairman(Integer repairmanId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", repairmanService.deleteRepairman(repairmanId));
        return modelMap;
    }


}
