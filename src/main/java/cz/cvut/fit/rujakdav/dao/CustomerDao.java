package cz.cvut.fit.rujakdav.dao;
import cz.cvut.fit.rujakdav.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class CustomerDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(Customer customer)
    {
        em.persist(customer);

    }

    public List<Customer> findAll() {
        CriteriaQuery<Customer> cq = em.getCriteriaBuilder().createQuery(Customer.class);
        return em.createQuery(cq.select(cq.from(Customer.class))).getResultList();
    }

    public void merge(Customer customer){
        em.merge(customer);
    }

}

