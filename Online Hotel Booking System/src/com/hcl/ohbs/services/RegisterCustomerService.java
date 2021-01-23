package com.hcl.ohbs.services;

import java.sql.SQLException;

import com.hcl.ohbs.dao.CustomerDAO;
import com.hcl.ohbs.entities.Customer;

public class RegisterCustomerService {

    public boolean registerCustomer() throws ClassNotFoundException, SQLException {
        CustomerDAO c = new CustomerDAO();
        boolean a = c.registerCustomer(new Customer("sithara", "ishanthi", "0703965620", "305,dipptigoda,kelaniya", "sithara@gmail.com", "sithara", "sithara123"));
        return a;
    }
}
