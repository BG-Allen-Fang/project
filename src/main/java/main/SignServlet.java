package main;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "SignServlet", urlPatterns = "/SignServlet")
public class SignServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("register") != null){
            File fileName = new File("C:\\Users\\Solare\\IdeaProjects\\project\\src\\main\\webapp\\uploads\\users.txt");
            String name = request.getParameter("reg-name");
            String email = request.getParameter("reg-email");
            String pass = request.getParameter("reg-pass");
            String pass2 = request.getParameter("reg-pass2");
            String message;
            String status;

//            Check for email exist
            Scanner fileScanner = new Scanner(fileName);
            int lineID = 0;
            Boolean emailExist = false;
            Boolean allOK = true;
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                lineID++;
                System.out.println(line);
                if(line.contains(email)){
                    emailExist = true;
                }
            }
            if(emailExist){
                allOK = false;
                message = "Entered email is registered";
                status = "red";
                request.setAttribute("status", status);
                request.setAttribute("message", message);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
//            Check for pass correctness
            if(!pass.equals(pass2)){
                allOK = false;
                message = "Entered passwords incorrect try again";
                status = "red";
                request.setAttribute("status", status);
                request.setAttribute("message", message);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
//            Register and input in file user
            else if(allOK == true) {
                String userInfo = "\nEmail: "+email+"\nName: "+name+"\nPass: "+pass;
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                writer.append(userInfo);
                writer.append("\n--------------------------------");
                writer.close();
                message = "Successfully signed up!";
                status = "green";
                request.setAttribute("status", status);
                request.setAttribute("message", message);
            }
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        if(request.getParameter("login") != null){
            File fileName = new File("C:\\Users\\Solare\\IdeaProjects\\project\\src\\main\\webapp\\uploads\\users.txt");
            String email = request.getParameter("login-email");
            String pass = "Pass: "+request.getParameter("login-pass");
            String message = "";
            String status = "";

//            Check for email exist
            Scanner fileScanner = new Scanner(fileName);
            String userName = "";
            int lineID = 0;
            int finded_line = -1;
            String finded_pass = "";
            Boolean emailExist = false;
            Boolean allOK = true;
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                lineID++;
                if(line.contains(email)){
                    emailExist = true;
                    finded_line = lineID+2;
                }
                if(lineID == finded_line){
                    finded_pass = line;
                }
                if(lineID == finded_line-1){
                    userName = line;
                }
            }
            if(!emailExist){
                allOK = false;
                status = "red";
                message = "Entered email is not registered!";
            }
            else {
//                Check pass
                if(!finded_pass.equals(pass)){
                    allOK = false;
                    status = "red";
                    message = "Entered password is incorrect!";
                }
//                If pass correct
                else {
                    userName = userName.substring(6, userName.length());
                    HttpSession session = request.getSession();
                    session.setAttribute("userName", userName);
                    session.setAttribute("userEmail", email);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
            request.setAttribute("status", status);
            request.setAttribute("message", message);
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("logout") != null){
            HttpSession session = request.getSession();
            session.invalidate();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
