package org.aptech.controllers;

import org.aptech.entites.Address;
import org.aptech.entites.Company;
import org.aptech.entites.Course;
import org.aptech.entites.Employee;
import org.aptech.enums.Action;
import org.aptech.services.CompanyBean;


import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@WebServlet(urlPatterns = "/employee")
public class EmployeeController extends HttpServlet {
    @EJB
    CompanyBean<Employee> employeeBean;
//    @EJB
//    CompanyBean<Course> courseBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (Action.ADD.toString().equalsIgnoreCase(action)) {
            Employee employee = getEmployee(request);
            if (employeeBean.add(employee)) {

                // Use for case using mappedBy
                /*
                for (Course course : employee.getCourses()) {
                    courseBean.add(course);
                }

                 */
                request.getServletContext().getRequestDispatcher("/AddEmployee.jsp").include(request, response);
                response.getWriter().write("Add Emmployee Success.");
            } else {
                response.getWriter().write("Add Emmployee Fail.");
            }

        }

    }

    private Employee getEmployee(HttpServletRequest request) {
        String fullName = request.getParameter("fullName");
        LocalDate localDate = LocalDate.parse(request.getParameter("birthday"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date birthDay = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String street = request.getParameter("street");
        String ward = request.getParameter("ward");
        String district = request.getParameter("district");
        String city = request.getParameter("city");

        Employee employee = new Employee();
        employee.setFullName(fullName);
        employee.setBirthday(birthDay);

        Address address = new Address();
        address.setStreet(street);
        address.setWard(ward);
        address.setDistrict(district);
        address.setEmployee(employee);
        address.setCity(city);
        employee.setAddress(address);

        boolean hasCompany = !request.getParameter("companyId").equals("");
        if (hasCompany) {
            long companyId = Long.parseLong(request.getParameter("companyId"));
            String companyName = request.getParameter("companyName");
            Company company = new Company();
            company.setId(companyId);
            company.setName(companyName);
            Set<Employee> employeeSet = new HashSet<>();
            employeeSet.add(employee);
            company.setEmployees(employeeSet);
            Set<Company> companySet = new HashSet<>();
            companySet.add(company);
            employee.setCompany(companySet);
        }
        String[] courses = request.getParameterValues("courseName");
        Set<Course> courseSet = new HashSet<>();
        for (String courseName : courses) {
            Course course = new Course();
            course.setCourseName(courseName);
            course.setEmployee(employee);
            courseSet.add(course);

        }
        employee.setCourses(courseSet);

        return employee;
    }


}
