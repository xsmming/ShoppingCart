package onlineShop.service;

import onlineShop.dao.CustomerDao;
import onlineShop.model.Cart;
import onlineShop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CustomerService会在前端用户点击了创建customer以后，被dispatcher分配过来的
 * 负责业务逻辑：添加缓存，添加limit，等等...
 * */
@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        Cart cart = new Cart();
        customer.setCart(cart);
        customer.getUser().setEnabled(true);
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerByEmail(String email) {
        return customerDao.getCustomerByEmail(email);
    }
}
