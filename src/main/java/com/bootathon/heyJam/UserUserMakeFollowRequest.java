package com.bootathon.heyJam;

import com.bootathon.heyJam.services.databaseServices.UserUserRelation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserUserMakeFollowRequest", value = "/UserUserMakeFollowRequest")
public class UserUserMakeFollowRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String participantUsername = request.getParameter("participant");
        try{
            if(UserUserRelation.userUserRelationCreateRequest(username,participantUsername)){
                response.getWriter().write("true");
            }else{
                response.getWriter().write("false");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
