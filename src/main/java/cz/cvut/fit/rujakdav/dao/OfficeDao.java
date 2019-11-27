package cz.cvut.fit.rujakdav.dao;
import cz.cvut.fit.rujakdav.model.Office;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class OfficeDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(Office office)
    {
        em.persist(office);

    }

    public List<Office> findAll() {
        CriteriaQuery<Office> cq = em.getCriteriaBuilder().createQuery(Office.class);
        return em.createQuery(cq.select(cq.from(Office.class))).getResultList();
    }

    public void merge(Office office){
        em.merge(office);
    }

}

