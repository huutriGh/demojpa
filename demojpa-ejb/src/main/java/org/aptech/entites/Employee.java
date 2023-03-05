package org.aptech.entites;


import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;
    private String fullName;
    private Date birthday;


    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;


    @ManyToMany
    @JoinTable(
            name = "Employee_Company",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private Set<Company> company;



    //@OneToMany( mappedBy = "employee")

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id")
    private Set<Course> courses;

    public Employee() {
    }

    public Set<Company> getCompany() {
        return company;
    }

    public void setCompany(Set<Company> company) {
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
