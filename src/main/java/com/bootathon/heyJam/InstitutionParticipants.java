package com.bootathon.heyJam;

import com.bootathon.heyJam.services.Components.UserInstitutionParticipantsRow;
import com.bootathon.heyJam.services.databaseServices.InstitutionEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "InstitutionParticipants", value = "/InstitutionParticipants")
public class InstitutionParticipants extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String institutionProfileUniqueName = request.getParameter("institutionUniqueName");
        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(UserInstitutionParticipantsRow.userInstitutionParticipants(username,institutionProfileUniqueName));
            response.getWriter().write(jsonString);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
