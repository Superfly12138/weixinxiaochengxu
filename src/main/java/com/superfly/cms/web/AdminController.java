package com.superfly.cms.web;

import com.superfly.cms.entity.Fix;
import com.superfly.cms.entity.RepairType;
import com.superfly.cms.service.AdminService;
import com.superfly.cms.service.CustomerService;
import com.superfly.cms.service.ManagerService;
import com.superfly.cms.service.RepairmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private RepairmanService repairmanService;
    @Autowired
    private ManagerService managerService;

    /**
     * 登录
     * @param adminName
     * @param adminPassword
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private Map<String, Object> login(String adminName, String adminPassword) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", adminService.loginAdminByName(adminName,adminPassword));
        return modelMap;
    }

    /**
     * 获取维修类别列表
     * @return
     */
    @RequestMapping(value = "/getrepairtypelist", method = RequestMethod.GET)
    private Map<String, Object> getrepairtypelist() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RepairType> repairTypeList= adminService.getRepairTypeList();
        modelMap.put("RepairType", repairTypeList);
        return modelMap;
    }

    /**
     * 获取所有的维修信息
     * @return
     */
    @RequestMapping(value = "/getfixlist", method = RequestMethod.GET)
    private Map<String, Object> getfixlist() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Fix> fixList = repairmanService.queryFixList();
        for (Fix item:fixList
             ) {
            String cusName = customerService.getCustomerById(item.getCusId()).getCusName();
            item.setCusName(cusName);
            String carNumber = customerService.queryCarByCarId(item.getCarId()).getCarNumber();
            item.setCarNumber(carNumber);
            String faultName = managerService.queryFaultDefinition(item.getFaultId()).getFaultName();
            item.setFaultName(faultName);
            if(item.getFixOver()==1){
                item.setFixStatus("未完工");
            }
            if(item.getFixOver()==2){
                item.setFixStatus("已完工");
            }
        }
        modelMap.put("Fix", fixList);
        return modelMap;
    }


}
