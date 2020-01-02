/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.m1.model;

import java.io.IOException;
import static java.lang.Math.log;
import static java.rmi.server.LogStream.log;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
/**
 *
 * @author Anil DEVADAS
 */
@Stateless
public class EmployeesSB {
@PersistenceContext
    EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List getEmployees()
    {
        Query q = em.createQuery("SELECT e FROM Employees e");
        return q.getResultList();
    }
    
     public Employees getAnEmployee(int employeeId)
     {
         Query q= em.createQuery("SELECT e FROM Employees e WHERE e.id = :id");
         return (Employees) q.setParameter("id", employeeId).getSingleResult();
       
     }
     
     public void deleteEmployee(Employees employeeID)
     {
        Query query = em.createQuery("DELETE FROM Employees e WHERE e.id = :id");
        query.setParameter("id", employeeID.getId());
        query.executeUpdate();
     }
          
    
    public void AddEmployee (Employees myEmployee)
    {
        em.persist(myEmployee);            
    }
    
    public void UpdateEmployee(Employees myEmployee)
    {
        
        Employees employee = em.find(Employees.class, myEmployee.getId());
        em.merge(myEmployee);

    }
}
