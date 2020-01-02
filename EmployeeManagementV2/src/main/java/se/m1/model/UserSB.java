/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.m1.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import javax.persistence.Query;
/**
 *
 * @author Anil DEVADAS
 */
@Stateless
public class UserSB {

    @PersistenceContext
    EntityManager em;
    
     List<User> listUsers;
    
    public List getUsers()
    {
        Query q = em.createQuery("SELECT u FROM User u");
        return q.getResultList();
    }
    
        public boolean checkCredentials(User userInput)  {
        boolean testCheck = false;
        try{        
            
        listUsers = getUsers();

        for (User userBase : listUsers) {
            if (userBase.getLogin().equals(userInput.getLogin())
                    && userBase.getPwd().equals(userInput.getPwd())) {
                testCheck = true;
            }
        }
        }catch (Exception e)
        {
            testCheck = false;
        }
        return testCheck;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
