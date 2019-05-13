package com.superfly.cms.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.superfly.cms.entity.Car;
import com.superfly.cms.entity.Customer;
import com.superfly.cms.entity.Fix;
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
     * 得到用户列表
     * @return
     */
    @RequestMapping(value = "/getcuslist", method = RequestMethod.GET)
    private Map<String, Object> getCustomerList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Customer> list = customerService.getCustomerList();
        modelMap.put("Customer", list);
        return modelMap;
    }

    /**
     * 得到用户列表(分页方式)
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getcuslist_p", method = RequestMethod.GET)
    private Map<String, Object> getCustomerList_p(Integer pageNum,Integer pageSize) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            //加入这句，可以直接把list的数据根据分页规则重新封装
            Page page = PageHelper.startPage(pageNum, pageSize, true);

            List<Customer> list = customerService.getCustomerList();
            //总数据条数
            modelMap.put("total", page.getTotal());
            //当前页
            modelMap.put("nowPage", pageNum);
            //数据
            modelMap.put("Customer", list);
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }


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
     * 通过顾客Id查询拥有的汽车信息
     * @param cusId
     * @return CarList
     */
    @RequestMapping(value = "/getcarsbycusid", method = RequestMethod.GET)
    private Map<String, Object> getCarsByCusId(Integer cusId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Car> carList= customerService.queryCarList(cusId);
        modelMap.put("Cars", carList);
        return modelMap;
    }
    /**
     * 通过顾客Id查询拥有的汽车信息（分页方式）
     * @param pageNum  当前页码
     * @param pageSize  页内大小
     * @param cusId  顾客Id
     * @return CarList
     */
    @RequestMapping(value = "/getcarsbycusid_p", method = RequestMethod.GET)
    private Map<String, Object> getCarsByCusId_P(Integer pageNum,Integer pageSize,Integer cusId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            //加入这句，可以直接把list的数据根据分页规则重新封装
            Page page = PageHelper.startPage(pageNum,pageSize,true);

            List<Car> carList= customerService.queryCarList(cusId);
            //总数据条数
            modelMap.put("total", page.getTotal());
            //当前页
            modelMap.put("nowPage", pageNum);
            //数据
            modelMap.put("Cars", carList);
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }

    }


    /**
     * 通过汽车Id查询汽车信息
     * @param carId
     * @return CarList
     */
    @RequestMapping(value = "/getcarbycarid", method = RequestMethod.GET)
    private Map<String, Object> getCarsByCarId(Integer carId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Car car= customerService.queryCarByCarId(carId);
        modelMap.put("Car", car);
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
     * @param jsonString json格式的字符串，car对象,包括carId
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

    /**
     * 新建维修单
     * @param jsonString contains(carId,faultId)
     * @return
     */
    @RequestMapping(value = "/addfix", method = RequestMethod.POST)
    private Map<String, Object> addFix(@RequestBody String jsonString) {
        try {
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Fix fix = JSON.toJavaObject((JSON) map.get("Fix"), com.superfly.cms.entity.Fix.class);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", customerService.addFix(fix));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }



    /**
     * 新新建维修单
     * @param jsonString contains(carId,faultId)
     * @return
     */
    @RequestMapping(value = "/addfix2", method = RequestMethod.POST)
    private Map<String, Object> addFix2(@RequestBody String jsonString) {
        try {
            System.out.println(jsonString);
            //将接收到的json转换成Map
            Map map = (Map) JSON.parse(jsonString);
            Map<String, Object> modelMap = new HashMap<String, Object>();
            modelMap.put("success", customerService.addNewFix(map));
            return modelMap;
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

}
