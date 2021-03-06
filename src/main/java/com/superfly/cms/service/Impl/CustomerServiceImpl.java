package com.superfly.cms.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.superfly.cms.dao.*;
import com.superfly.cms.entity.*;
import com.superfly.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CarDao carDao;
    @Autowired
    private OwnCusCarDao ownCusCarDao;
    @Autowired
    private FixDao fixDao;
    @Autowired
    private OwnRegulationsFixDao ownRegulationsFixDao;
    @Autowired
    private OwnMaterialFixDao ownMaterialFixDao;
    @Autowired
    private MaterialDao materialDao;

    /**
     * 查询所有的顾客信息
     *
     * @return
     */
    @Override
    public List<Customer> getCustomerList() {
        try {
            return customerDao.queryCustomer();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 查询所有的顾客信息(通过名称筛选)
     *
     * @param cusName
     * @return
     */
    @Override
    public List<Customer> getCustomerListFilterName(String cusName) {
        try {
            return customerDao.queryCustomerFilterName(cusName);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    @Override
    public Customer getCustomerById(Integer cusId) {
        try {
            return customerDao.queryCustomerById(cusId);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    @Transactional
    @Override
    public boolean addCustomer(Customer customer) {
        if (customer == null) {
            throw new RuntimeException("前端传入数据无效，添加客户失败！");
        }
        //判断插入的数据是否为空
        if (customer.getCusName() != null && !"".equals(customer.getCusName())) {
            if (customer.getCusPassword() != null && !"".equals(customer.getCusPassword())) {
                if (customer.getCusSex() != null && !"".equals(customer.getCusSex())) {
                    if (customer.getCusAge() != null) {
                        if (customer.getCusPhone() != null && !"".equals(customer.getCusPhone())) {
                            if (customer.getCusAddress() != null && !"".equals(customer.getCusAddress())) {
                                if (customer.getCusEmail() != null && !"".equals(customer.getCusEmail())) {

                                    try {
                                        //设置注册时间
                                        customer.setCusRegistrationDate(new Date());
                                        int effectedNumber = customerDao.insertCustomer(customer);
                                        if (effectedNumber > 0) {
                                            return true;
                                        } else {
                                            throw new RuntimeException("用户注册失败！");
                                        }
                                    } catch (Exception e) {
                                        throw new RuntimeException("用户注册失败！" + e.toString());
                                    }

                                } else {
                                    throw new RuntimeException("邮箱不能为空！");
                                }
                            } else {
                                throw new RuntimeException("地址不能为空！");
                            }
                        } else {
                            throw new RuntimeException("手机号不能为空！");
                        }
                    } else {
                        throw new RuntimeException("年龄不能为空！");
                    }
                } else {
                    throw new RuntimeException("性别不能为空！");
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("姓名不能为空！");
        }

    }

    @Override
    public boolean loginCustomerByName(String cusName, String cusPassword) {
        if (cusName != null && !"".equals(cusName)) {
            if (cusPassword != null && !"".equals(cusPassword)) {
                try {
                    //通过姓名登录获取password（只有一个用户名时才有效）
                    List<Customer> list = customerDao.queryCustomerByName(cusName);
                    if (list.size() < 1) {
                        throw new RuntimeException("姓名不存在！");
                    } else if (list.size() == 1) {
                        if (list.get(0).getCusPassword().equals(cusPassword)) {
                            return true;
                        } else {
                            throw new RuntimeException("密码错误！");
                        }
                    } else {
                        throw new RuntimeException("姓名存在重复，请使用其他方式登录！");
                    }

                } catch (Exception e) {
                    throw new RuntimeException("登录失败！" + e.toString());
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("姓名不能为空！");
        }
    }

    @Override
    public boolean loginCustomerByPhone(String cusPhone, String cusPassword) {
        if (cusPhone != null && !"".equals(cusPhone)) {
            if (cusPassword != null && !"".equals(cusPassword)) {
                try {
                    //通过手机号登录获取password
                    if (customerDao.queryCustomerByPhone(cusPhone) == null) {
                        throw new RuntimeException("手机号不存在！");
                    } else if (customerDao.queryCustomerByPhone(cusPhone).getCusPassword().equals(cusPassword)) {
                        return true;
                    } else {
                        throw new RuntimeException("密码错误！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("登录失败！" + e.toString());
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("手机号不能为空！");
        }
    }

    @Override
    public boolean loginCustomerByEmail(String cusEmail, String cusPassword) {
        if (cusEmail != null && !"".equals(cusEmail)) {
            if (cusPassword != null && !"".equals(cusPassword)) {
                try {
                    //通过邮箱登录获取password
                    if (customerDao.queryCustomerByEmail(cusEmail) == null) {
                        throw new RuntimeException("邮箱不存在！");
                    } else if (customerDao.queryCustomerByEmail(cusEmail).getCusPassword().equals(cusPassword)) {
                        return true;
                    } else {
                        throw new RuntimeException("密码错误！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("登录失败！" + e.toString());
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("邮箱不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyCustomer(Customer customer) {//判断更新的数据是否为空
        if (customer == null) {
            throw new RuntimeException("前端传入数据无效，添加客户失败！");
        }
        if (customer.getCusName() != null && !"".equals(customer.getCusName())) {
            if (customer.getCusPassword() != null && !"".equals(customer.getCusPassword())) {
                if (customer.getCusSex() != null && !"".equals(customer.getCusSex())) {
                    if (customer.getCusAge() != null) {
                        if (customer.getCusPhone() != null && !"".equals(customer.getCusPhone())) {
                            if (customer.getCusAddress() != null && !"".equals(customer.getCusAddress())) {
                                if (customer.getCusEmail() != null && !"".equals(customer.getCusEmail())) {

                                    try {
                                        int effectedNumber = customerDao.updateCustomer(customer);
                                        if (effectedNumber > 0) {
                                            return true;
                                        } else {
                                            throw new RuntimeException("更新失败！");
                                        }
                                    } catch (Exception e) {
                                        throw new RuntimeException("更新失败！" + e.toString());
                                    }

                                } else {
                                    throw new RuntimeException("邮箱不能为空！");
                                }
                            } else {
                                throw new RuntimeException("地址不能为空！");
                            }
                        } else {
                            throw new RuntimeException("手机号不能为空！");
                        }
                    } else {
                        throw new RuntimeException("年龄不能为空！");
                    }
                } else {
                    throw new RuntimeException("性别不能为空！");
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("姓名不能为空！");
        }

    }

    @Transactional
    @Override
    public boolean deleteCustomer(Integer cusId) {
        try {
            //删除用户
            int effectedNum = customerDao.deleteCustomer(cusId);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("注销用户失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("注销用户失败:" + e.toString());
        }
    }

    @Override
    public List<Car> queryCarList(Integer cusId) {
        try {
            //通过客户Id查询到所有的拥有信息
            List<OwnCusCar> list = ownCusCarDao.queryOwnCusCarByCusId(cusId);
            if (list.size() > 0) {
                List<Car> listCar = new ArrayList<>();
                for (OwnCusCar own : list) {
                    //通过拥有信息查询到汽车Id,通过汽车Id查询到汽车信息,放入list中
                    listCar.add(carDao.queryCarById(own.getCarId()));
                }
                return listCar;
            } else {
                return null;
            }

        } catch (Exception e) {
            throw new RuntimeException("查询失败!" + e.toString());
        }
    }

    /**
     * 通过汽车Id查询汽车
     *
     * @param carId
     * @return
     */
    @Override
    public Car queryCarByCarId(Integer carId) {
        try {
           return carDao.queryCarById(carId);

        } catch (Exception e) {
            throw new RuntimeException("查询失败!" + e.toString());
        }
    }

    /**
     * 通过汽车车牌查询汽车
     *
     * @param carNumber
     * @return
     */
    @Override
    public Car queryCarByCarNumber(String carNumber) {
        try {
            return carDao.queryCarByCarNumber(carNumber);

        } catch (Exception e) {
            throw new RuntimeException("查询失败!" + e.toString());
        }
    }

    @Transactional
    @Override
    public boolean addCar(Car car, Integer cusId) {
        //判断插入的数据是否为空
        if (car == null) {
            throw new RuntimeException("前端传入数据无效，添加汽车失败！");
        }
        if (car.getCarType() != null && !"".equals(car.getCarType())) {
            if (car.getCarNumber() != null && !"".equals(car.getCarNumber())) {
                if (cusId != null) {
                    //数据都不为空时
                    try {
                        //先插入汽车信息
                        //未插入car时，car.getCarId()为null,插入后则为id值
                        //System.out.println(car.getCarId());
                        int effectedNumber = carDao.insertCar(car);
                        if (effectedNumber > 0) { //  插入车辆信息有效

                            OwnCusCar ownCusCar = new OwnCusCar();
                            ownCusCar.setCusId(cusId);
                            ownCusCar.setCarId(car.getCarId());
                            if (ownCusCarDao.insertOwnCusCar(ownCusCar) > 0) {
                                return true;
                            } else {
                                throw new RuntimeException("添加汽车失败！");
                            }
                        } else {
                            throw new RuntimeException("添加汽车失败！");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("添加汽车失败！" + e.toString());
                    }
                } else {
                    throw new RuntimeException("用户id为空,添加汽车失败！");
                }

            } else {
                throw new RuntimeException("车牌不能为空！");
            }

        } else {
            throw new RuntimeException("汽车类型不能为空！");
        }

    }

    @Transactional
    @Override
    public boolean modifyCar(Car car) {
        //判断插入的数据是否为空
        if (car == null) {
            throw new RuntimeException("前端传入数据无效，添加汽车失败！");
        }
        if (car.getCarType() != null && !"".equals(car.getCarType())) {
            if (car.getCarNumber() != null && !"".equals(car.getCarNumber())) {
                //数据都不为空时
                try {
                    int effectedNumber = carDao.updateCar(car);
                    if (effectedNumber > 0) { //  更新车辆信息有效
                        return true;
                    } else {
                        throw new RuntimeException("更新汽车失败！effectednum<0");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("更新汽车失败！" + e.toString());
                }

            } else {
                throw new RuntimeException("车牌不能为空！");
            }

        } else {
            throw new RuntimeException("汽车类型不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteCar(Integer carId) {
        if (carId != null && carId > 0) {
            try {
                //删除汽车
                int effectedNum = carDao.deleteCar(carId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除汽车失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除汽车失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("carId不正确！");
        }
    }
    /**
     * 新建维修单信息
     *
     * @param fix
     * @return true or false
     */
    @Transactional
    @Override
    public boolean addFix(Fix fix) {
        if (fix == null) {
            throw new RuntimeException("前端传入数据无效，新建维修单失败！");
        }
        try {
            fix.setFixOrderDate(new Date());
            fix.setFixOver(1);
            int effectedNumber = fixDao.insertFix(fix);
            if (effectedNumber > 0) {
                return true;
            } else {
                throw new RuntimeException("更新失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("更新失败！" + e.toString());
        }
    }

    /**
     * 新新建维修单信息
     *
     * @param map
     * @return true or false
     */
    @Transactional
    @Override
    public boolean addNewFix(Map map) {
        if (map == null) {
            throw new RuntimeException("前端传入数据无效，新建维修单失败！");
        }
        try {
            Fix fix = JSON.toJavaObject((JSON) map.get("Fix"), com.superfly.cms.entity.Fix.class);
            Object ownRegulationsFixObject = map.get("OwnRegulationsFix");
            List<OwnRegulationsFix> ownRegulationsFixList =
                    JSONObject.parseArray(ownRegulationsFixObject.toString(), com.superfly.cms.entity.OwnRegulationsFix.class);

            Object ownMaterialFixObject = map.get("OwnMaterialFix");
            List<OwnMaterialFix> ownMaterialFixList =
                    JSONObject.parseArray(ownMaterialFixObject.toString(), com.superfly.cms.entity.OwnMaterialFix.class);

//            System.out.println(ownRegulationsFixList);
//            System.out.println(ownMaterialFixList);


            fix.setFixOrderDate(new Date());
            fix.setFixOver(1);
            int effectedNumber = fixDao.insertFix(fix);
            if (effectedNumber > 0) {
                int fixId = fix.getFixId();
                for (OwnRegulationsFix item : ownRegulationsFixList
                ) {
                    item.setFixId(fixId);
                    if (ownRegulationsFixDao.insertOwnRegulationsFix(item) <= 0) {
                        throw new RuntimeException("失败！");
                    }

                }
                for (OwnMaterialFix item2 : ownMaterialFixList
                ) {
                    item2.setFixId(fixId);

                    Material material = materialDao.queryMaterialById(item2.getMaterialId());
                    if(item2.getOwnMaterialFixNumber() > material.getMaterialNumber()){
                        throw new RuntimeException(material.getMaterialName()+"库存数量不足！");
                    }else {
                        material.setMaterialNumber(material.getMaterialNumber() - item2.getOwnMaterialFixNumber());
                    }
                    if(materialDao.updateMaterial(material) <= 0)
                    {
                        throw new RuntimeException("库存扣减失败！");
                    }
                    if (ownMaterialFixDao.insertOwnMaterialFix(item2) <= 0) {
                        throw new RuntimeException("失败！");
                    }
                }
                return true;

            } else {
                throw new RuntimeException("更新失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("失败！" + e.toString());
        }
    }
}
