package onlineShop.dao;

import onlineShop.model.Authorities;
import onlineShop.model.Customer;
import onlineShop.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;  // 可以直接拿到

    public void addCustomer(Customer customer) {
        Session session = null;
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmailId(customer.getUser().getEmailId());

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Customer getCustomerByEmail(String email) {
        User user = new User();
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(User.class);
            user = (User)criteria.add(Restrictions.eq("emailId",email)).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user != null ? user.getCustomer():null;
    }
}
