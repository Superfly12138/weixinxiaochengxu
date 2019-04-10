package com.superfly.cms.service.Impl;

import com.superfly.cms.dao.CustomerDao;
import com.superfly.cms.entity.Customer;
import com.superfly.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer getCustomerById(int cusId) {
        return customerDao.queryCustomerById(cusId);
    }

    @Transactional
    @Override
    public boolean addCustomer(Customer customer) {
        //判断插入的数据是否为空
        if (customer.getCusName() != null && !"".equals(customer.getCusName())) {
            if (customer.getCusPassword() != null && !"".equals(customer.getCusPassword())) {
                if (customer.getCusSex() != null && !"".equals(customer.getCusSex())) {
                    if (customer.getCusAge() != null && !"".equals(customer.getCusAge())) {
                        if (customer.getCusPhone() != null && !"".equals(customer.getCusPhone())) {
                            if (customer.getCusAddress() != null && !"".equals(customer.getCusAddress())) {
                                if (customer.getCusEmail() != null && !"".equals(customer.getCusEmail())) {
                                    //设置注册时间
                                    customer.setCusRegistrationDate(new Date());
                                    try {
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
        if (customer.getCusName() != null && !"".equals(customer.getCusName())) {
            if (customer.getCusPassword() != null && !"".equals(customer.getCusPassword())) {
                if (customer.getCusSex() != null && !"".equals(customer.getCusSex())) {
                    if (customer.getCusAge() != null && !"".equals(customer.getCusAge())) {
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
    public boolean deleteCustomer(int cusId) {
        try {
            //删除用户
            int effectedNum = customerDao.deleteCustomer(cusId);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("注销用户失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除区域信息失败:" + e.toString());
        }
    }
}
