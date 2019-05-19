package com.rental.daoImpl;

import com.rental.dao.CustomerStatusDao;
import com.rental.entity.Customer;
import com.rental.entity.CustomerStatus;
import com.rental.entity.UserRole;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerStatusDaoImpl implements CustomerStatusDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<CustomerStatus> getCustomerStatuses() {
        Session session = this.sessionFactory.openSession();
        Criteria crit = session.createCriteria(CustomerStatus.class);
        List<CustomerStatus> allCustomerStatuses = crit.list();
        return allCustomerStatuses;
    }
}
