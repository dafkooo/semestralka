package cz.cvut.fit.rujakdav.dao;
import cz.cvut.fit.rujakdav.model.Trip;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class TripDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(Trip trip)
    {
        em.persist(trip);

    }

    public List<Trip> findAll() {
        CriteriaQuery<Trip> cq = em.getCriteriaBuilder().createQuery(Trip.class);
        return em.createQuery(cq.select(cq.from(Trip.class))).getResultList();
    }

    public void merge(Trip trip){
        em.merge(trip);
    }

}

