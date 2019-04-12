package com.superfly.cms.web;

import com.alibaba.fastjson.JSON;
import com.superfly.cms.entity.*;
import com.superfly.cms.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    /**
     * 根据Id获取一个经理信息
     *
     * @param managerId
     * @return
     */
    @RequestMapping(value = "/getmanagerbyid", method = RequestMethod.GET)
    private Map<String, Object> getManagerById(Integer managerId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Manager manager = managerService.getManagerById(managerId);
        modelMap.put("Manager", manager);
        return modelMap;
    }

    /**
     * 注册一个经理
     *
     * @param jsonString
     * @return success:true
     */
    @RequestMapping(value = "/addmanager", method = RequestMethod.POST)
    private Map<String, Object> addManager(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Manager manager = JSON.toJavaObject((JSON) map.get("Manager"), com.superfly.cms.entity.Manager.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", managerService.addManager(manager));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 通过姓名登录
     *
     * @param managerName
     * @param managerPassword
     * @return success:true else:false
     */
    @RequestMapping(value = "/loginbyname", method = RequestMethod.POST)
    private Map<String, Object> loginManagerByName(String managerName, String managerPassword) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", managerService.loginManagerByName(managerName, managerPassword));
        return modelMap;
    }

    /**
     * 通过手机登录
     *
     * @param managerPhone
     * @param managerPassword
     * @return success:true else:false
     */
    @RequestMapping(value = "/loginbyphone", method = RequestMethod.POST)
    private Map<String, Object> loginManagerByPhone(String managerPhone, String managerPassword) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", managerService.loginManagerByPhone(managerPhone, managerPassword));
        return modelMap;
    }

    /**
     * 通过邮箱登录
     *
     * @param managerEmail
     * @param managerPassword
     * @return success:true else:false
     */
    @RequestMapping(value = "/loginbyemail", method = RequestMethod.POST)
    private Map<String, Object> loginManagerByEmail(String managerEmail, String managerPassword) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", managerService.loginManagerByEmail(managerEmail, managerPassword));
        return modelMap;
    }

    /**
     * 更新用户信息
     *
     * @param jsonString 经理信息
     * @return success：true or false
     */
    @RequestMapping(value = "/modifymanager", method = RequestMethod.POST)
    private Map<String, Object> modifyManager(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Manager manager = JSON.toJavaObject((JSON) map.get("Manager"), com.superfly.cms.entity.Manager.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", managerService.modifyManager(manager));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 注销经理信息
     *
     * @param managerId
     * @return success:true else:false
     */
    @RequestMapping(value = "/removemanager", method = RequestMethod.GET)
    private Map<String, Object> removeManager(Integer managerId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", managerService.deleteManager(managerId));
        return modelMap;
    }

    //故障定义部分

    /**
     * 查询所有的故障定义信息
     *
     * @return List<FaultDefinition>
     */
    @RequestMapping(value = "/getfaultdefinitionlist", method = RequestMethod.GET)
    private Map<String, Object> getFaultDefinitionList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<FaultDefinition> faultDefinitionList = managerService.queryFaultDefinitionList();
        modelMap.put("FaultDefinition", faultDefinitionList);
        return modelMap;
    }

    /**
     * 根据故障Id查询故障信息
     *
     * @param faultId
     * @return FaultDefinition
     */
    @RequestMapping(value = "/getfaultdefinitionbyid", method = RequestMethod.GET)
    private Map<String, Object> getFaultDefinitionById(Integer faultId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        FaultDefinition faultDefinition = managerService.queryFaultDefinition(faultId);
        modelMap.put("FaultDefinition", faultDefinition);
        return modelMap;
    }

    /**
     * 添加故障信息
     *
     * @param jsonString
     * @return true or false
     */
    @RequestMapping(value = "/addfaultDefinition", method = RequestMethod.POST)
    private Map<String, Object> addFaultDefinition(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            FaultDefinition faultDefinition = JSON.toJavaObject((JSON) map.get("FaultDefinition"), com.superfly.cms.entity.FaultDefinition.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", managerService.addFaultDefinition(faultDefinition));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 更改故障的信息
     *
     * @param jsonString
     * @return true or false
     */
    @RequestMapping(value = "/modifyfaultDefinition", method = RequestMethod.POST)
    private Map<String, Object> modifyFaultDefinition(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            FaultDefinition faultDefinition = JSON.toJavaObject((JSON) map.get("FaultDefinition"), com.superfly.cms.entity.FaultDefinition.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", managerService.modifyFaultDefinition(faultDefinition));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 根据故障Id删除故障信息
     *
     * @param faultId
     * @return true or false
     */
    @RequestMapping(value = "/removefaultDefinition", method = RequestMethod.GET)
    private Map<String, Object> removeFaultDefinition(Integer faultId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", managerService.deleteFaultDefinition(faultId));
        return modelMap;
    }

    /**
     * 查询所有的其它费用信息
     *
     * @return List<OtherCost>
     */
    @RequestMapping(value = "/getothercostlist", method = RequestMethod.GET)
    private Map<String, Object> getcList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<OtherCost> otherCostList = managerService.queryOtherCostList();
        modelMap.put("OtherCost", otherCostList);
        return modelMap;
    }

    /**
     * 根据其它费用Id查询其它费用信息
     *
     * @param otherCostId
     * @return OtherCost
     */
    @RequestMapping(value = "/getothercostbyid", method = RequestMethod.GET)
    private Map<String, Object> getOtherCostById(Integer otherCostId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        OtherCost otherCost = managerService.queryOtherCost(otherCostId);
        modelMap.put("OtherCost", otherCost);
        return modelMap;
    }


    /**
     * 添加其它费用信息
     *
     * @param jsonString
     * @return true or false
     */
    @RequestMapping(value = "/addothercost", method = RequestMethod.POST)
    private Map<String, Object> addOtherCost(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            OtherCost otherCost = JSON.toJavaObject((JSON) map.get("OtherCost"), com.superfly.cms.entity.OtherCost.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", managerService.addOtherCost(otherCost));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 更改其它费用的信息
     *
     * @param jsonString
     * @return true or false
     */
    @RequestMapping(value = "/modifyothercost", method = RequestMethod.POST)
    private Map<String, Object> modifyOtherCost(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            OtherCost otherCost = JSON.toJavaObject((JSON) map.get("OtherCost"), com.superfly.cms.entity.OtherCost.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", managerService.modifyOtherCost(otherCost));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 根据其它费用Id删除其它费用信息
     *
     * @param otherCostId
     * @return true or false
     */
    @RequestMapping(value = "/removeothercost", method = RequestMethod.GET)
    private Map<String, Object> removeOtherCost(Integer otherCostId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", managerService.deleteOtherCost(otherCostId));
        return modelMap;
    }

    /**
     * 查询所有的维修规定信息
     *
     * @return List<RepairRegulations>
     */
    @RequestMapping(value = "/getrepairregulationslist", method = RequestMethod.GET)
    private Map<String, Object> getRepairRegulationsList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RepairRegulations> repairRegulations = managerService.queryRepairRegulationsList();
        modelMap.put("RepairRegulations", repairRegulations);
        return modelMap;
    }

    /**
     * 根据维修规定Id查询维修规定信息
     *
     * @param repairRegulationsId
     * @return RepairRegulations
     */
    @RequestMapping(value = "/getrepairregulationsbyid", method = RequestMethod.GET)
    private Map<String, Object> getRepairRegulations(Integer repairRegulationsId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        RepairRegulations repairRegulations = managerService.queryRepairRegulations(repairRegulationsId);
        modelMap.put("RepairRegulations", repairRegulations);
        return modelMap;
    }

    /**
     * 添加维修规定信息
     *
     * @param jsonString
     * @return true or false
     */
    @RequestMapping(value = "/addrepairregulations", method = RequestMethod.POST)
    private Map<String, Object> addRepairRegulations(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            RepairRegulations repairRegulations = JSON.toJavaObject((JSON) map.get("RepairRegulations"), com.superfly.cms.entity.RepairRegulations.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", managerService.addRepairRegulations(repairRegulations));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 更改维修规定的信息
     *
     * @param jsonString
     * @return true or false
     */
    @RequestMapping(value = "/modifyrepairregulations", method = RequestMethod.POST)
    private Map<String, Object> modifyRepairRegulations(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            RepairRegulations repairRegulations = JSON.toJavaObject(
                    (JSON) map.get("RepairRegulations"),
                    com.superfly.cms.entity.RepairRegulations.class
            );
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", managerService.modifyRepairRegulations(repairRegulations));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }


    /**
     * 根据维修规定Id删除维修规定信息
     *
     * @param repairRegulationsId
     * @return true or false
     */
    @RequestMapping(value = "/removerepairregulations", method = RequestMethod.GET)
    private Map<String, Object> removeRepairRegulations(Integer repairRegulationsId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", managerService.deleteRepairRegulations(repairRegulationsId));
        return modelMap;
    }


    /**
     * 查询所有的维修班组信息
     *
     * @return List<RepairTeam>
     */
    @RequestMapping(value = "/getrepairteamlist", method = RequestMethod.GET)
    private Map<String, Object> getRepairTeamList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RepairTeam> repairTeamList = managerService.queryRepairTeamList();
        modelMap.put("RepairTeam", repairTeamList);
        return modelMap;
    }

    /**
     * 根据维修班组Id查询维修班组信息
     *
     * @param repairTeamId
     * @return RepairTeam
     */
    @RequestMapping(value = "/getrepairteambyid", method = RequestMethod.GET)
    private Map<String, Object> getRepairTeamById(Integer repairTeamId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        RepairTeam  repairTeam = managerService.queryRepairTeam(repairTeamId);
        modelMap.put("RepairTeam", repairTeam);
        return modelMap;
    }
    /**
     * 添加维修班组信息
     *
     * @param jsonString
     * @return true or false
     */
    @RequestMapping(value = "/addrepairteam", method = RequestMethod.POST)
    private Map<String, Object> addRepairTeam(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            RepairTeam repairTeam = JSON.toJavaObject((JSON) map.get("RepairTeam"), com.superfly.cms.entity.RepairTeam.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", managerService.addRepairTeam(repairTeam));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 更改维修班组的信息
     *
     * @param jsonString
     * @return true or false
     */
    @RequestMapping(value = "/modifyrepairteam", method = RequestMethod.POST)
    private Map<String, Object> modifyRepairTeam(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            RepairTeam repairTeam = JSON.toJavaObject((JSON) map.get("RepairTeam"), com.superfly.cms.entity.RepairTeam.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", managerService.modifyRepairTeam(repairTeam));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 根据维修班组Id删除维修班组信息
     *
     * @param repairTeamId
     * @return true or false
     */
    @RequestMapping(value = "/removerepairteam", method = RequestMethod.GET)
    private Map<String, Object> removeRepairTeam(Integer repairTeamId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", managerService.deleteRepairTeam(repairTeamId));
        return modelMap;
    }

}
