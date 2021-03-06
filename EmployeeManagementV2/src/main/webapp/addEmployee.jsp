<%-- 
    Document   : addEmployee
    Created on : 5 nov. 2019, 16:19:03
    Author     : Anil DEVADAS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Management Project</title>
        <style>
        body {
          font-family: Arial, Helvetica, sans-serif;
          background-color: black;
        }
        * {
          box-sizing: border-box;
        }
        /* Add padding to containers */
        .container {
          padding: 16px;
          background-color: white;
        }
        /* Full-width input fields */
        input[type=text], input[type=password] {
          width: 100%;
          padding: 15px;
          margin: 5px 0 22px 0;
          display: inline-block;
          border: none;
          background: #f1f1f1;
        }
        input[type=text]:focus, input[type=password]:focus {
          background-color: #ddd;
          outline: none;
        }
        /* Overwrite default styles of hr */
        hr {
          border: 1px solid #f1f1f1;
          margin-bottom: 25px;
        }
        /* Set a style for the submit button */
        .registerbtn {
          background-color: #4CAF50;
          color: white;
          padding: 16px 20px;
          margin: 8px 0;
          border: none;
          cursor: pointer;
          width: 100%;
          opacity: 0.9;
        }
        .registerbtn:hover {
          opacity: 1;
        }
        /* Add a blue text color to links */
        a {
          color: dodgerblue;
        }
        /* Set a grey background color and center the text of the "sign in" section */
        .signin {
          background-color: #f1f1f1;
          text-align: center;
        }
</style>
    </head>
    <body>
         <div class="container">
            <h1>Add an Employee</h1>
            <p>Please fill the form to add a new employee</p>
            <hr>
           <form method='post' name='myform' action='Controller'>
            <label for="name"><b>Name</b></label>
            <input type="text" placeholder="Enter Name" name='name'>

            <label for="firstname"><b>First Name</b></label>
            <input type="text" placeholder="Enter First Name" name='firstname'>

            <label for="telHome"><b>Home Phone</b></label>
            <input type="text" placeholder="Enter Home Phone Number" name='homephone'>
            
            <label for="telMobile"><b>Mobile Phone</b></label>
            <input type="text" placeholder="Enter Mobile Phone Number" name='mobilephone'>
            
            <label for="telMobile"><b>Mobile Pro</b></label>
            <input type="text" placeholder="Enter Professional Phone Number" name='mobilepro'>
            
            <label for="Address"><b>Address</b></label>
            <input type="text" placeholder="Enter the Address" name='address'>
            
            <label for="Address"><b>Postal Code</b></label>
            <input type="text" placeholder="Enter the Postal Code" name='postalcode'>
            
            <label for="Address"><b>City</b></label>
            <input type="text" placeholder="Enter the City" name='city'>
            
            <label for="Address"><b>Email</b></label>
            <input type="text" placeholder="Enter the Email" name='email'>
            <hr>
            <button type="submit" name="addbutton" class="registerbtn">Add Employee</button>
            
            <button type="submit" name="cancel" class="registerbtn">Cancel</button>
            </form>
        </div>
    </body>
</html>