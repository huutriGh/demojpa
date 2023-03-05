package org.aptech.services;


import org.aptech.entites.Company;
import org.aptech.entites.Employee;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.List;

@Remote
public interface CompanyService<T extends  Serializable>   {
    public List<T> getAll();

    public T getById(long id);

    public boolean add(T employee);

    public boolean update(T employee);

    public boolean delete(long id);


}
