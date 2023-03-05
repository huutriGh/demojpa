package org.aptech.entites;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Course")
public class Course implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CourseName", columnDefinition = "nvarchar(100)")
    private String courseName;


    @ManyToOne
    //@JoinColumn(name = "employee_id", nullable = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public Course() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
