package com.bootathon.heyJam;

import com.bootathon.heyJam.services.Components.UserInstitutionRow;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "InstitutionProfileNotifications", value = "/InstitutionProfileNotifications")
public class InstitutionProfileNotifications extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        try{
            ArrayList<UserInstitutionRow> notifications = UserInstitutionRow.getInstitutionNotifications(username);
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(notifications);
            response.getWriter().write(jsonString);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
