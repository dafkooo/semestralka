package cz.cvut.fit.rujakdav.service;

import cz.cvut.fit.rujakdav.dao.OfficeDao;
import cz.cvut.fit.rujakdav.model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;


@Service
public class OfficeService {
    @Autowired
    private OfficeDao officeDao;

    @Transactional
    public void add(Office customer) {
        officeDao.persist(customer);
    }

    @Transactional
    public void addAll(Collection<Office> offices) {
        for (Office office : offices) {
            officeDao.persist(office);
        }
    }

    @Transactional(readOnly = true)
    public List<Office> listAll() {
        return officeDao.findAll();
    }

    @Transactional
    public void update(Office office){
        officeDao.merge(office);
    }

}
