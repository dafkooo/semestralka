package cz.cvut.fit.rujakdav.model;

import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;
import java.util.Set;

@Entity
public class Customer
{
    @Id
    @GeneratedValue(strategy=SEQUENCE)
    private Integer id;
    private String name;
    private Integer age;
    @ManyToOne(fetch = FetchType.EAGER)
    private Office office;

    @ManyToMany(mappedBy = "customers", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Set<Trip> trips;


    public Set<Trip> trips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", office adress=" + (office == null? "null" : office.address() ) + "]";
    }

    public Customer(String name, Integer age, Office office) {
        this.name = name;
        this.age = age;
        this.office = office;
    }
    public Customer() {

    }

    public Integer id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Integer age() {
        return age;
    }
    public Office office() {
        return office;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setOffice(Office office) {
        this.office = office;
    }


}
