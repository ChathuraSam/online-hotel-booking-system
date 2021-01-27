package com.hcl.ohbs.services;

import com.hcl.ohbs.dao.CustomerDAO;
import com.hcl.ohbs.entities.Customer;

public class RegisterCustomerService {
	CustomerDAO c;
    public boolean registerCustomer(String firstName, String lastname, String phone, String address, String email, String username, String password, String confirmPassword) {
        c = new CustomerDAO();
        boolean a = c.registerCustomer(new Customer(firstName, lastname, phone, address, email, username, password));
        
        return a;
    }
    
    public int getIdByUsernameAndPassword(String username, String password) {
		c = new CustomerDAO();
		return c.findIdByUsernamePassword(username, password);
	}
    
    public String getNameByUsernameAndPassword(String username, String password) {
		c = new CustomerDAO();
		return c.findNameByUsernamePassword(username, password);
	}
    
    public Customer getCustomerById(int id) {
		c = new CustomerDAO();
		return c.findCustomerById(id);
	}   
}
