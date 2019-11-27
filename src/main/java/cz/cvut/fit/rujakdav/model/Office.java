package cz.cvut.fit.rujakdav.model;

import cz.cvut.fit.rujakdav.model.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
public class Office
{
    @Id
    private String address;
    private String manager;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "office")
    private List<Customer> customers;

    @Override
    public String toString() {
        String str = "Office [adress=" + address + ", manager=" + manager ;
        if(!customers.isEmpty()){
            str += ", customers=" + customers();
        }
        return str + "]";
    }

    public Office(String address, String manager) {
        this.address = address;
        this.manager = manager;
    }

    public Office() {
    }

    public String address() {
        return address;
    }

    public String manager() {
        return manager;
    }

    public List<Customer> customers() {
        return customers;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
