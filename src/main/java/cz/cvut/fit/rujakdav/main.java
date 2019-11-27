package cz.cvut.fit.rujakdav;

import cz.cvut.fit.rujakdav.model.Customer;
import cz.cvut.fit.rujakdav.model.Office;
import cz.cvut.fit.rujakdav.model.Trip;
import cz.cvut.fit.rujakdav.service.CustomerService;
import cz.cvut.fit.rujakdav.service.OfficeService;
import cz.cvut.fit.rujakdav.service.TripService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class main {
    public static void main(String args[]) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        CustomerService customerService = ctx.getBean(CustomerService.class);
        OfficeService officeService = ctx.getBean(OfficeService.class);
        TripService tripService = ctx.getBean(TripService.class);

        Office o1 = new Office("Humenne", "Honza");
        Office o2 = new Office("Praha", "Zapotocky");
        officeService.add(o1);
        officeService.add(o2);
        Customer c1 = new Customer("Peter", 25,o1);
        Customer c2 = new Customer("Bruno",58, o2);

        customerService.add(c1);

        customerService.add(c2);

        Trip t1=new Trip("25.8.2020","New York");
        Trip t2=new Trip("18.10.2021","Moskva");



        tripService.add(t1);
        tripService.add(t2);


        t1.setCustomers(new HashSet<>(Arrays.asList(c1, c2)));
        t2.setCustomers(new HashSet<>(Arrays.asList(c1, c2)));

        tripService.update(t2);
        tripService.update(t1);


        System.out.println("All customers. " + customerService.listAll());
        System.out.println("All offices. " + officeService.listAll());
        System.out.println("All trips. " + tripService.listAll());
        for (Trip s : tripService.listAll()){
            System.out.println(s+": "+s.customers());
        }

        ctx.close();
    }
}
