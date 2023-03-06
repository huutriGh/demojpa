package org.aptech.controllers;

import org.aptech.entites.Address;
import org.aptech.entites.Employee;
import org.aptech.enums.Action;
import org.aptech.services.EmployeeBean;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(urlPatterns = "/employee")
public class EmployeeController extends HttpServlet {
    @EJB
    EmployeeBean<Employee> employeeBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (Action.ADD.toString().equalsIgnoreCase(action)) {
            Employee employee = getEmployee(request);
            if (employeeBean.addEntity(employee)) {
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
        return employee;
    }


}
