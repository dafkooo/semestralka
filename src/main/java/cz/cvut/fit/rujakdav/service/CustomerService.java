package cz.cvut.fit.rujakdav.service;

import cz.cvut.fit.rujakdav.dao.CustomerDao;
import cz.cvut.fit.rujakdav.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;


@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Transactional
    public void add(Customer customer) {
        customerDao.persist(customer);
    }

    @Transactional
    public void addAll(Collection<Customer> customers) {
        for (Customer customer : customers) {
            customerDao.persist(customer);
        }
    }

    @Transactional(readOnly = true)
    public List<Customer> listAll() {
        return customerDao.findAll();
    }

    @Transactional
    public void update(Customer customer){
        customerDao.merge(customer);
    }

}
