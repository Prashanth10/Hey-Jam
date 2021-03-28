package com.bootathon.heyJam;

import com.bootathon.heyJam.services.databaseServices.InstitutionSurvey;
import com.bootathon.heyJam.services.otherServices.GetRequestBody;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InstitutionCreateSurvey", value = "/InstitutionCreateSurvey")
public class InstitutionCreateSurvey extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestBody = GetRequestBody.getBody(request);
        JSONObject survey = new JSONObject(requestBody);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        try{
            InstitutionSurvey.createSurvey(username,
                    survey.getString("surveyTitle"),
                    survey.getString("surveyContent"),
                    survey.getString("surveyExpiryDate"),
                    survey.getString("surveyTarget"),
                    survey.getString("surveyOptionA"),
                    survey.getString("surveyOptionB"),
                    survey.getString("surveyCreationDate"));
            response.getWriter().write("{}");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
