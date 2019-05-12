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
import java.util.ListIterator;
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
            item.setOtherCostMoney(otherCost.getOtherCostMoney());
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
     * 查询所有的材料信息
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


    /**
     * 查询所有的材料下限信息
     *
     * @return List<Material>
     */
    @RequestMapping(value = "/getmateriallist2", method = RequestMethod.GET)
    private Map<String, Object> getMaterialList2() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Material> materialList = adminService.queryMaterialList();
        ListIterator<Material> listIterator = materialList.listIterator();

        while(listIterator.hasNext()){
            if(listIterator.next().getMaterialNumber()>10) {
                    listIterator.remove();
            }
        }

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





    /**
     * 查询所有的入库单信息
     *
     * @return List<Instock>
     */
    @RequestMapping(value = "/getinstocklist", method = RequestMethod.GET)
    private Map<String, Object> getInstockList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Instock> instockList = adminService.queryInstockList();
        modelMap.put("Instock", instockList);
        return modelMap;
    }


    /**
     * 查询所有的当天入库单信息
     *
     * @return List<Instock>
     */
    @RequestMapping(value = "/getinstocklisttoday", method = RequestMethod.GET)
    private Map<String, Object> getInstockListToday() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Instock> instockList = adminService.queryInstockListToday();
        for (Instock item:instockList
        ) {
           Material material = adminService.queryMaterialByMaterialId(item.getMaterialId());
           item.setMaterialName(material.getMaterialName());
           item.setInMoney(material.getMaterialInmoney());
           item.setOutMoney(material.getMaterialOutmoney());
        }
        modelMap.put("InstockToday", instockList);
        return modelMap;
    }

    /**
     * 根据入库单Id查询入库单信息
     *
     * @param instockId
     * @return Instock
     */
    @RequestMapping(value = "/getinstockbyid", method = RequestMethod.GET)
    private Map<String, Object> getInstockById(Integer instockId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Instock instock = adminService.queryInstockByInstockId(instockId);
        modelMap.put("Instock", instock);
        return modelMap;
    }

    /**
     * 新建入库单
     *
     * @param jsonString
     * @return true or false
     */
    @RequestMapping(value = "/addinstock", method = RequestMethod.POST)
    private Map<String, Object> addInstock(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Instock instock = JSON.toJavaObject((JSON) map.get("Instock"), com.superfly.cms.entity.Instock.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", adminService.addInstock(instock));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 更改入库单的信息
     *
     * @param jsonString
     * @return true or false
     */
    @RequestMapping(value = "/modifyinstock", method = RequestMethod.POST)
    private Map<String, Object> modifyInstock(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Instock instock = JSON.toJavaObject((JSON) map.get("Instock"), com.superfly.cms.entity.Instock.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", adminService.modifyInstock(instock));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 根据入库单Id删除入库单信息
     *
     * @param instockId
     * @return true or false
     */
    @RequestMapping(value = "/removeinstock", method = RequestMethod.GET)
    private Map<String, Object> removeInstock(Integer instockId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", adminService.deleteInstock(instockId));
        return modelMap;
    }

    /**
     * 查询所有的出库单信息
     *
     * @return List<Outstock>
     */
    @RequestMapping(value = "/getoutstocklist", method = RequestMethod.GET)
    private Map<String, Object> getOutstockList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Outstock> outstockList = adminService.queryOutstockList();
        modelMap.put("Outstock", outstockList);
        return modelMap;
    }


    /**
     * 查询所有的当天出库单信息
     *
     * @return List<Instock>
     */
    @RequestMapping(value = "/getoutstocklisttoday", method = RequestMethod.GET)
    private Map<String, Object> getOutstockListToday() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Outstock> outstockList = adminService.queryOutstockListToday();
        for (Outstock item:outstockList
        ) {
            Material material = adminService.queryMaterialByMaterialId(item.getMaterialId());
            item.setMaterialName(material.getMaterialName());
            item.setInMoney(material.getMaterialInmoney());
            item.setOutMoney(material.getMaterialOutmoney());
        }
        modelMap.put("OutstockToday", outstockList);
        return modelMap;
    }

    /**
     * 根据出库单Id查询出库单信息
     *
     * @param outstockId
     * @return Outstock
     */
    @RequestMapping(value = "/getoutstockbyid", method = RequestMethod.GET)
    private Map<String, Object> getOutstockById(Integer outstockId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Outstock outstock = adminService.queryOutstockByOutstockId(outstockId);
        modelMap.put("Outstock", outstock);
        return modelMap;
    }

    /**
     * 新建出库单
     *
     * @param jsonString
     * @return true or false
     */
    @RequestMapping(value = "/addoutstock", method = RequestMethod.POST)
    private Map<String, Object> addOutstock(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Outstock outstock = JSON.toJavaObject((JSON) map.get("Outstock"), com.superfly.cms.entity.Outstock.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", adminService.addOutstock(outstock));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 更改出库单的信息
     *
     * @param jsonString
     * @return true or false
     */
    @RequestMapping(value = "/modifyoutstock", method = RequestMethod.POST)
    private Map<String, Object> modifyOutstock(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Outstock outstock = JSON.toJavaObject((JSON) map.get("Outstock"), com.superfly.cms.entity.Outstock.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", adminService.modifyOutstock(outstock));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 根据出库单Id删除出库单信息
     *
     * @param outstockId
     * @return true or false
     */
    @RequestMapping(value = "/removeoutstock", method = RequestMethod.GET)
    private Map<String, Object> removeOutstock(Integer outstockId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", adminService.deleteOutstock(outstockId));
        return modelMap;
    }


}
