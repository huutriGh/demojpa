package org.aptech.services;

import org.aptech.entites.Company;
import org.aptech.entites.Employee;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

@Stateless(name = "CompanyEJB")
@LocalBean
public class CompanyBean<T extends Serializable> implements CompanyService<T> {
    private final EntityManager entityManager;
    private Class<T> type;


    public CompanyBean() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("demojpaPersistenceUnit");
        entityManager = managerFactory.createEntityManager();
    }

    @Override
    public List<T> getAll() {

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(type);
        Root<T> root = cq.from(type);
        cq.select(root);
        return this.entityManager.createQuery(cq).getResultList();
    }

    @Override
    public T getById(long id) {
        return this.entityManager.find(type, id);
    }

    @Override
    public boolean add(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
           entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean update(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(getById(id));
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }


}
