package org.aptech.entites;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "Street", columnDefinition = "nvarchar(100)")
    private String street;

    @Column(name = "Ward", columnDefinition = "nvarchar(100)")
    private String ward;

    @Column(name = "District", columnDefinition = "nvarchar(100)")
    private String district;


    @Column(name = "City", columnDefinition = "nvarchar(100)")
    private String city;


    @OneToOne
    @MapsId
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
