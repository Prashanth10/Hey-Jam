package com.bootathon.heyJam;

import com.bootathon.heyJam.services.databaseServices.InstitutionEvent;
import com.bootathon.heyJam.services.otherServices.GetRequestBody;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InstitutionCreateEvent", value = "/InstitutionCreateEvent")
public class InstitutionCreateEvent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestBody = GetRequestBody.getBody(request);
        JSONObject event = new JSONObject(requestBody);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        try {
            InstitutionEvent.createEvent(
                    username,
                    event.getString("eventTitle"),
                    event.getString("eventContent"),
                    event.getString("eventExpiryDate"),
                    event.getString("eventTargetYear"),
                    event.getString("eventLinkTitle"),
                    event.getString("eventLink"),
                    event.getString("eventCreationDate")
            );
           response.getWriter().write("{}");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
