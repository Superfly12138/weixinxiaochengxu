package com.superfly.cms.dao;

import com.superfly.cms.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CustomerDaoTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void queryCustomer() {
       List<Customer> list =  customerDao.queryCustomer();
       assertEquals(10,list.size());
    }

    @Test
    public void queryCustomerById() {
        Customer customer = customerDao.queryCustomerById(6);
        assertEquals("王五",customer.getCusName());
    }

    @Test
    public void insertCustomer() {
        Customer customer = new Customer();
        customer.setCusPassword("admin");
        customer.setCusName("666");
        customer.setCusSex("男");
        customer.setCusAge(20);
        customer.setCusPhone("1345677374");
        customer.setCusAddress("上海");
        customer.setCusEmail("9030476@qq.com");
        customer.setCusRegistrationDate(new Date());
        //        System.out.println(customer);
        int effectedNum = customerDao.insertCustomer(customer);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setCusId(9);
        customer.setCusPassword("admin");
        customer.setCusName("王五");
        customer.setCusSex("男");
        customer.setCusAge(21);
        //注册时间不建议更新
//      customer.setCusRegistrationDate(new Date());
        int effectedNum = customerDao.updateCustomer(customer);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteCustomer() {
        int effectedNum = customerDao.deleteCustomer(8);
        assertEquals(1,effectedNum);
    }
}