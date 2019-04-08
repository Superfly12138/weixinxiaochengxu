package com.superfly.cms.dao;

import com.superfly.cms.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
       assertEquals(2,list.size());
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
        customer.setCusName("王五");
        customer.setCusSex("男");
        customer.setCusAge(20);
        customer.setCusPhone("134567737");
        customer.setCusAddress("上海");
        customer.setCusEmail("903046@qq.com");
//        customer.setCusRegistrationDate();
        //        System.out.println(customer);
        int effectedNum = customerDao.insertCustomer(customer);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setCusId(6);
        customer.setCusPassword("admin");
        customer.setCusName("王五");
        customer.setCusSex("男");
        customer.setCusAge(21);
        customer.setCusPhone("134567737");
        customer.setCusAddress("上海");
        customer.setCusEmail("903046@qq.com");
//        customer.setCusRegistrationDate();
        //        System.out.println(customer);
        int effectedNum = customerDao.updateCustomer(customer);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteCustomer() {
    }
}