package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Developer;
import service.DeveloperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

@WebServlet(urlPatterns = "/developers")
public class DeveloperController extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //выбрать всех разработчиков определённого уровня
        if (req.getParameterMap().containsKey("grade")) {
            String developerGrade = req.getParameter("grade");
            List<Developer> developers = DeveloperService.getDeveloperService().getDevelopersForGrade(developerGrade);
            req.setAttribute("developers", developers);
            req.getRequestDispatcher("developer_list.jsp").forward(req, resp);
        }
        //выбрать всех разработиков определённого скила
        else if (req.getParameterMap().containsKey("skill")) {
            String developerSkill = req.getParameter("skill");
            List<Developer> developers = DeveloperService.getDeveloperService().getDevelopersForSkill(developerSkill);
            req.setAttribute("developers", developers);
            req.getRequestDispatcher("developer_list.jsp").forward(req, resp);
        }
        //выбрать всех разработиков определённого проекта
        else if (req.getParameterMap().containsKey("projectname")) {
            String projectName=req.getParameter("projectname");
            Set<Developer> developers= DeveloperService.getDeveloperService().getDevelopersForProjectName(projectName);
            req.setAttribute("developers",developers);
            req.getRequestDispatcher("developer_list.jsp").forward(req,resp);
        }
        //иначе ничего
        else {
            resp.setStatus(402);
        }
    }


}
