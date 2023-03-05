package org.aptech.entites;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Company")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="Id")
    private  long id;


    @Column(name = "CompanyName")
    private  String name;


    @ManyToMany(mappedBy = "company",cascade = CascadeType.ALL )
    private Set<Employee> employees;

    public Company() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
