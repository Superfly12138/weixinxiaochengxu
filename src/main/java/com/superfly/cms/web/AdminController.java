package com.superfly.cms.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.superfly.cms.entity.*;
import com.superfly.cms.service.AdminService;
import com.superfly.cms.service.CustomerService;
import com.superfly.cms.service.ManagerService;
import com.superfly.cms.service.RepairmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
//
//    /**
//     * 获取所有的维修信息
//     * @return
//     */
//    @RequestMapping(value = "/getfixlist", method = RequestMethod.GET)
//    private Map<String, Object> getfixlist() {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        List<Fix> fixList = repairmanService.queryFixList();
//        for (Fix item:fixList
//             ) {
//            String cusName = customerService.getCustomerById(item.getCusId()).getCusName();
//            item.setCusName(cusName);
//            String carNumber = customerService.queryCarByCarId(item.getCarId()).getCarNumber();
//            item.setCarNumber(carNumber);
//            String faultName = managerService.queryFaultDefinition(item.getFaultId()).getFaultName();
//            item.setFaultName(faultName);
//            if(item.getFixOver()==1){
//                item.setFixStatus("未完工");
//            }
//            if(item.getFixOver()==2){
//                item.setFixStatus("已完工");
//            }
//        }
//        modelMap.put("Fix", fixList);
//        return modelMap;
//    }



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


            Customer customer = customerService.getCustomerById(item.getCusId());
            Car car = customerService.queryCarByCarId(item.getCarId());
            FaultDefinition faultDefinition = managerService.queryFaultDefinition(item.getFaultId());
            RepairType repairType = adminService.getRepairTypeById(item.getRepairTypeId());
            RepairRegulations repairRegulations = managerService.queryRepairRegulations(item.getRepairId());
            RepairTeam repairTeam = managerService.queryRepairTeam(item.getRepairTeamId());
            OtherCost otherCost = managerService.queryOtherCost(item.getOtherCostId());

            item.setCusName(customer.getCusName());
            item.setCusSex(customer.getCusSex());
            item.setCusPhone(customer.getCusPhone());
            item.setCusAddress(customer.getCusAddress());

            item.setCarType(car.getCarType());
            item.setCarNumber(car.getCarNumber());

            item.setFaultName(faultDefinition.getFaultName());

            item.setRepairTypeName(repairType.getRepairTypeName());

            item.setRepairName(repairRegulations.getRepairName());
            item.setRepairMoney(repairRegulations.getRepairMoney());

            item.setRepairTeamName(repairTeam.getRepairTeamName());

            item.setOtherCostName(otherCost.getOtherCostName());

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






    /**
     * 查询所有的材料定义信息
     *
     * @return List<Material>
     */
    @RequestMapping(value = "/getmateriallist", method = RequestMethod.GET)
    private Map<String, Object> getMaterialList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Material> materialList = adminService.queryMaterialList();
        modelMap.put("Material", materialList);
        return modelMap;
    }

//    /**
//     * 查询所有的材料定义信息(分页)
//     * @param pageNum  当前页码
//     * @param pageSize  页内大小
//     * @return List<Material>
//     */
//    @RequestMapping(value = "/getfaultdefinitionlist_p", method = RequestMethod.GET)
//    private Map<String, Object> getFaultDefinitionList_p(Integer pageNum,Integer pageSize) {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        try {
//            //加入这句，可以直接把list的数据根据分页规则重新封装
//            Page page = PageHelper.startPage(pageNum,pageSize,true);
//
//            List<FaultDefinition> faultDefinitionList = managerService.queryFaultDefinitionList();
//            //总数据条数
//            modelMap.put("total", page.getTotal());
//            //当前页
//            modelMap.put("nowPage", pageNum);
//            //数据
//            modelMap.put("FaultDefinition", faultDefinitionList);
//            return modelMap;
//        } catch (Exception e) {
//            throw new RuntimeException(e.toString());
//        }
//
//
//    }

    /**
     * 根据材料Id查询材料信息
     *
     * @param materialId
     * @return Material
     */
    @RequestMapping(value = "/getmaterialbyid", method = RequestMethod.GET)
    private Map<String, Object> getMaterialById(Integer materialId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Material material = adminService.queryMaterialByMaterialId(materialId);
        modelMap.put("Material", material);
        return modelMap;
    }

    /**
     * 添加材料信息
     *
     * @param jsonString
     * @return true or false
     */
    @RequestMapping(value = "/addmaterial", method = RequestMethod.POST)
    private Map<String, Object> addMaterial(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Material material = JSON.toJavaObject((JSON) map.get("Material"), com.superfly.cms.entity.Material.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", adminService.addMaterial(material));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 更改材料的信息
     *
     * @param jsonString
     * @return true or false
     */
    @RequestMapping(value = "/modifymaterial", method = RequestMethod.POST)
    private Map<String, Object> modifyMaterial(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Material material = JSON.toJavaObject((JSON) map.get("Material"), com.superfly.cms.entity.Material.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", adminService.modifyMaterial(material));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 根据材料Id删除材料信息
     *
     * @param materialId
     * @return true or false
     */
    @RequestMapping(value = "/removematerial", method = RequestMethod.GET)
    private Map<String, Object> removeMaterial(Integer materialId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", adminService.deleteMaterial(materialId));
        return modelMap;
    }





}
