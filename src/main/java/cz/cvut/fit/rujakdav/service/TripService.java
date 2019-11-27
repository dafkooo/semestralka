package cz.cvut.fit.rujakdav.service;

import cz.cvut.fit.rujakdav.dao.TripDao;
import cz.cvut.fit.rujakdav.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;


@Service
public class TripService {
    @Autowired
    private TripDao tripDao;

    @Transactional
    public void add(Trip customer) {
        tripDao.persist(customer);
    }

    @Transactional
    public void addAll(Collection<Trip> trips) {
        for (Trip trip : trips) {
            tripDao.persist(trip);
        }
    }

    @Transactional(readOnly = true)
    public List<Trip> listAll() {
        return tripDao.findAll();
    }

    @Transactional
    public void update(Trip trip){
        tripDao.merge(trip);
    }

}
