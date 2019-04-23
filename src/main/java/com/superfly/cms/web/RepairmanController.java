package com.superfly.cms.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.superfly.cms.entity.Car;
import com.superfly.cms.entity.Fix;
import com.superfly.cms.entity.Repairman;
import com.superfly.cms.service.RepairmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
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

    //维修部分
    /**
     * 查询所有的维修信息
     *
     * @return List<fix>
     */
    @RequestMapping(value = "/getfixlist", method = RequestMethod.GET)
    private Map<String, Object> getFixList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Fix> fixList = repairmanService.queryFixList();
        modelMap.put("Fix", fixList);
        return modelMap;
    }
    /**
     * 查询所有的维修信息(分页)
     * @param pageNum  当前页码
     * @param pageSize  页内大小
     * @return List<fix>
     */
    @RequestMapping(value = "/getfixlist_p", method = RequestMethod.GET)
    private Map<String, Object> getFixList_p(Integer pageNum,Integer pageSize) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            //加入这句，可以直接把list的数据根据分页规则重新封装
            Page page = PageHelper.startPage(pageNum,pageSize,true);

            List<Fix> fixList = repairmanService.queryFixList();
            //总数据条数
            modelMap.put("total", page.getTotal());
            //当前页
            modelMap.put("nowPage", pageNum);
            //数据
            modelMap.put("Fix", fixList);
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }
//    @RequestMapping(value = "/getfixlist_p", method = RequestMethod.GET)
//    private Map<String, Object> getFixList_p(Integer pageNum,Integer pageSize) {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        try {
//            //加入这句，可以直接把list的数据根据分页规则重新封装
//            Page page = PageHelper.startPage(pageNum,pageSize,true);
//
//            List<Fix> fixList = repairmanService.queryFixList();
//            //总数据条数
//            modelMap.put("total", page.getTotal());
//            //当前页
//            modelMap.put("nowPage", pageNum);
//            //数据
//            modelMap.put("Fix", fixList);
//            return modelMap;
//        } catch (Exception e) {
//            throw new RuntimeException(e.toString());
//        }
//    }

    /**
     * 根据维修Id查询维修信息
     * @param fixId
     * @return
     */
    @RequestMapping(value = "/getfixbyid", method = RequestMethod.GET)
    private Map<String, Object> getFixById(Integer fixId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Fix fix = repairmanService.queryFixByFixId(fixId);
        modelMap.put("Fix", fix);
        return modelMap;
    }
    /**
     * 通过维修人员所在维修组编号查询维修信息
     * @param repairTeamId
     * @return
     */
    @RequestMapping(value = "/getfixbyrepairteamid", method = RequestMethod.GET)
    private Map<String, Object> getFixByRepairTeamId(Integer repairTeamId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Fix> fixList= repairmanService.queryFixByRepairTeamId(repairTeamId);
        modelMap.put("Fix", fixList);
        return modelMap;
    }
    /**
     * 接受维修单（要求存在于维修班组,前端传入的数据有，包括fixId在内的所有信息）
     * @param jsonString
     * @return
     */
    @RequestMapping(value = "/acceptfix", method = RequestMethod.POST)
    private Map<String, Object> acceptFix(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Fix fix = JSON.toJavaObject((JSON) map.get("Fix"), com.superfly.cms.entity.Fix.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", repairmanService.acceptFix(fix));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 完成维修单 前端传入的数据有，包括fixId在内的所有信息）
     * @param jsonString
     * @return
     */
    @RequestMapping(value = "/finishfix", method = RequestMethod.POST)
    private Map<String, Object> finishFix(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Fix fix = JSON.toJavaObject((JSON) map.get("Fix"), com.superfly.cms.entity.Fix.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", repairmanService.finishFix(fix));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }
}
