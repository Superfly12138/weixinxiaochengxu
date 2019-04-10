package com.superfly.cms.web;

import com.superfly.cms.entity.Customer;
import com.superfly.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/customer")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 根据Id获取一个顾客信息
     * @param cusId
     * @return
     */
    @RequestMapping(value = "/getcusbyid", method = RequestMethod.GET)
    private Map<String,Object> getCustomerById(int cusId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
       Customer customer = customerService.getCustomerById(cusId);
       modelMap.put("Customer",customer);
       return modelMap;
    }
    /**
     * 注册一个客户
     * @param customer
     * @return success:true
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private Map<String,Object> addCustomer(@RequestBody Customer customer){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",customerService.addCustomer(customer));
        return modelMap;
    }

    /**
     * 姓名登录验证
     * @param cusName
     * @param cusPassword
     * @return success:true
     */
    @RequestMapping(value = "/loginbyname", method = RequestMethod.POST)
    private Map<String,Object> loginCustomerByName(String cusName,String cusPassword){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",customerService.loginCustomerByName(cusName,cusPassword));
        return modelMap;
    }
    /**
     * 手机号登录验证
     * @param cusPhone
     * @param cusPassword
     * @return success:true
     */
    @RequestMapping(value = "/loginbyphone", method = RequestMethod.POST)
    private Map<String,Object> loginCustomerByPhone(String cusPhone,String cusPassword){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",customerService.loginCustomerByPhone(cusPhone,cusPassword));
        return modelMap;
    }
    /**
     * 邮箱登录验证
     * @param cusEmail
     * @param cusPassword
     * @return success:true
     */
    @RequestMapping(value = "/loginbyemail", method = RequestMethod.POST)
    private Map<String,Object> loginCustomerByEmail(String cusEmail,String cusPassword){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",customerService.loginCustomerByEmail(cusEmail,cusPassword));
        return modelMap;
    }

    /**
     * 更新用户信息
     * @param customer
     * @return
     */
    @RequestMapping(value = "/modifify", method = RequestMethod.POST)
    private Map<String,Object> modififyCustomer(@RequestBody Customer customer){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",customerService.modifyCustomer(customer));
        return modelMap;
    }
}
