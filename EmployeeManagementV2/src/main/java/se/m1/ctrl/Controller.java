/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.m1.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.m1.model.Employees;
import se.m1.model.EmployeesSB;
import se.m1.model.User;
import se.m1.model.UserSB;
import static  se.m1.utls.Constants.*;


/**
 *
 * @author Anil DEVADAS
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB
    private UserSB userSB;
    ArrayList<User> listOfUsers;
    @EJB
    private EmployeesSB employeeSB;
    ArrayList<Employees> listOfEmployees;
    Employees myEmployee;
     User userInput;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listOfUsers = new ArrayList<>();
        listOfUsers.addAll(userSB.getUsers());
        listOfEmployees = new ArrayList<>();
        listOfEmployees.addAll(employeeSB.getEmployees());
        
        if (request.getParameter("connexion") != null) {
            userInput = new User();
            userInput.setLogin(request.getParameter(FRM_LOGIN_FIELD));
            userInput.setPwd(request.getParameter(FRM_PWD_FIELD));
            
            String TheLogin = userInput.getLogin();
            String ThePwd = userInput.getPwd();
            
            if (userSB.checkCredentials(userInput)) {
                 request.getSession().setAttribute("key_User", userInput);
                request.setAttribute("empList", employeeSB.getEmployees());
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            } else {
                   request.setAttribute("errKey", ERR_MESSAGE);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }

        else if (request.getParameter("add") != null)
        {
            request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
        }

        else if (request.getParameter("detail") != null)
        {
            int employeeId = Integer.parseInt(request.getParameter(FRM_EMPLOYEE_ID));
            request.setAttribute("employee", employeeSB.getAnEmployee(employeeId));
            request.getRequestDispatcher("detailEmployee.jsp").forward(request, response);
        }
         else if (request.getParameter("delete") != null)
        {
            myEmployee = new Employees();
            myEmployee.setId(Integer.parseInt(request.getParameter(FRM_EMPLOYEE_ID)));
            employeeSB.deleteEmployee(myEmployee);
            request.setAttribute("empList", employeeSB.getEmployees());
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
        else if (request.getParameter("update") != null)
        {
            
            myEmployee = new Employees();
            
            employeeSB.getEmployees().clear();
            
            String test = request.getParameter(FRM_EMPLOYEE_ID);
            myEmployee.setId(Integer.parseInt(request.getParameter(FRM_EMPLOYEE_ID)));
            myEmployee.setName(request.getParameter(FRM_EMPLOYEE_NAME));
            myEmployee.setFirstname(request.getParameter(FRM_EMPLOYEE_FIRSTNAME));
            myEmployee.setTelhome(request.getParameter(FRM_EMPLOYEE_TELHOME));
            myEmployee.setTelmob(request.getParameter(FRM_EMPLOYEE_TELMOB));
            myEmployee.setTelpro(request.getParameter(FRM_EMPLOYEE_TELPRO));
            myEmployee.setAdress(request.getParameter(FRM_EMPLOYEE_ADDRESS));
            myEmployee.setPostalcode(request.getParameter(FRM_EMPLOYEE_POSTALCODE));
            myEmployee.setCity(request.getParameter(FRM_EMPLOYEE_CITY));
            myEmployee.setEmail(request.getParameter(FRM_EMPLOYEE_EMAIL));
            employeeSB.UpdateEmployee(myEmployee);
            List l = employeeSB.getEmployees();
            
            request.setAttribute("empList", l);


            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
        
        else if (request.getParameter("addbutton") != null)
        {
            myEmployee = new Employees();
            myEmployee.setName(request.getParameter(FRM_EMPLOYEE_NAME));
            myEmployee.setFirstname(request.getParameter(FRM_EMPLOYEE_FIRSTNAME));
            myEmployee.setTelhome(request.getParameter(FRM_EMPLOYEE_TELHOME));
            myEmployee.setTelmob(request.getParameter(FRM_EMPLOYEE_TELMOB));
            myEmployee.setTelpro(request.getParameter(FRM_EMPLOYEE_TELPRO));
            myEmployee.setAdress(request.getParameter(FRM_EMPLOYEE_ADDRESS));
            myEmployee.setPostalcode(request.getParameter(FRM_EMPLOYEE_POSTALCODE));
            myEmployee.setCity(request.getParameter(FRM_EMPLOYEE_CITY));
            myEmployee.setEmail(request.getParameter(FRM_EMPLOYEE_EMAIL));
            
            employeeSB.AddEmployee(myEmployee);
            request.setAttribute("empList", employeeSB.getEmployees());
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
        
        else if (request.getParameter("cancel") != null)
        {
            request.setAttribute("empList", employeeSB.getEmployees());
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
        
        else if (request.getParameter("logout") != null)
        {
            request.getSession().invalidate();
                request.getRequestDispatcher("goodbye.jsp").forward(request, response);
        }
        
        else if (request.getParameter("intro") != null)
        {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
