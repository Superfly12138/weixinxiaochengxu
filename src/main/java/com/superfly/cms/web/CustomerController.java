package com.superfly.cms.web;

import com.alibaba.fastjson.JSON;
import com.superfly.cms.entity.Car;
import com.superfly.cms.entity.Customer;
import com.superfly.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/customer")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 根据Id获取一个顾客信息
     *
     * @param cusId
     * @return
     */
    @RequestMapping(value = "/getcusbyid", method = RequestMethod.GET)
    private Map<String, Object> getCustomerById(Integer cusId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Customer customer = customerService.getCustomerById(cusId);
        modelMap.put("Customer", customer);
        return modelMap;
    }

    /**
     * 注册一个客户
     *
     * @param jsonString
     * @return success:true
     */
    @RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
    private Map<String, Object> addCustomer(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Customer customer = JSON.toJavaObject((JSON) map.get("Customer"), com.superfly.cms.entity.Customer.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", customerService.addCustomer(customer));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 姓名登录验证
     *
     * @param cusName
     * @param cusPassword
     * @return success:true
     */
    @RequestMapping(value = "/loginbyname", method = RequestMethod.POST)
    private Map<String, Object> loginCustomerByName(String cusName, String cusPassword) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", customerService.loginCustomerByName(cusName, cusPassword));
        return modelMap;
    }

    /**
     * 手机号登录验证
     *
     * @param cusPhone
     * @param cusPassword
     * @return success:true
     */
    @RequestMapping(value = "/loginbyphone", method = RequestMethod.POST)
    private Map<String, Object> loginCustomerByPhone(String cusPhone, String cusPassword) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", customerService.loginCustomerByPhone(cusPhone, cusPassword));
        return modelMap;
    }

    /**
     * 邮箱登录验证
     *
     * @param cusEmail
     * @param cusPassword
     * @return success:true
     */
    @RequestMapping(value = "/loginbyemail", method = RequestMethod.POST)
    private Map<String, Object> loginCustomerByEmail(String cusEmail, String cusPassword) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", customerService.loginCustomerByEmail(cusEmail, cusPassword));
        return modelMap;
    }

    /**
     * 更新用户信息
     *
     * @param jsonString 顾客信息
     * @return success：true or false
     */
    @RequestMapping(value = "/modifycustomer", method = RequestMethod.POST)
    private Map<String, Object> modifyCustomer(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Customer customer = JSON.toJavaObject((JSON) map.get("Customer"), com.superfly.cms.entity.Customer.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", customerService.modifyCustomer(customer));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 注销用户
     *
     * @param cusId
     * @return
     */
    @RequestMapping(value = "/removecustomer", method = RequestMethod.GET)
    private Map<String, Object> removeCustomer(Integer cusId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", customerService.deleteCustomer(cusId));
        return modelMap;
    }

    /**
     * 添加一辆车
     *
     * @param jsonString json格式的字符串，包括car对象和cusId
     * @return success:true or false
     */
    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    private Map<String, Object> addCar(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
//            map的value为JSONNbject对象，所以应转换成Car对象。
//            System.out.println(map.get("Car") instanceof JSONObject);
//            先将map中的car取出,然后转换成java中的Car对象
            Car car = JSON.toJavaObject((JSON) map.get("Car"), com.superfly.cms.entity.Car.class);
            Integer integer = (Integer) map.get("cusId");
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", customerService.addCar(car, integer));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 更新用户的车辆信息
     *
     * @param jsonString json格式的字符串，包括car对象和cusId
     * @return success:true or false
     */
    @RequestMapping(value = "/modififyCar", method = RequestMethod.POST)
    private Map<String, Object> modififyCar(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
//            先将map中的car取出,然后转换成java中的Car对象
            Car car = JSON.toJavaObject((JSON) map.get("Car"), com.superfly.cms.entity.Car.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", customerService.modifyCar(car));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 删除用户的车辆
     *
     * @param carId
     * @return
     */
    @RequestMapping(value = "/removecar", method = RequestMethod.GET)
    private Map<String, Object> removeCar(Integer carId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", customerService.deleteCar(carId));
        return modelMap;
    }

}
