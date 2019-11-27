package cz.cvut.fit.rujakdav.model;

import cz.cvut.fit.rujakdav.model.Customer;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.*;

@Entity
public class Trip
{
    @Id
    @GeneratedValue(strategy=SEQUENCE)
    private Integer id;
    private String date;
    private String destination;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "Trip_Customer", joinColumns = {@JoinColumn(name = "name")}, inverseJoinColumns = {@JoinColumn(name = "id")})
    private Set<Customer> customers;

    @Override
    public String toString() {
        return "Trip [id=" + id + ", date=" + date + ", destination=" + destination + "]";
    }

    public Trip(String date, String destination) {
        this.date = date;
        this.destination = destination;
    }
    public Trip() {
    }
    public Integer id() {
        return id;
    }

    public String date() {
        return date;
    }

    public String destination() {
        return destination;
    }

    public Set<Customer> customers() { return customers; }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setCustomers(Set<Customer> customers) { this.customers = customers; }
}



