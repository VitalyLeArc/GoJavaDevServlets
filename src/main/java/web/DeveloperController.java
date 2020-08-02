package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Developer;
import domain.enums.EnumSex;
import service.DeveloperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
            String projectName = req.getParameter("projectname");
            Set<Developer> developers = DeveloperService.getDeveloperService().getDevelopersForProjectName(projectName);
            req.setAttribute("developers", developers);
            req.getRequestDispatcher("developer_list.jsp").forward(req, resp);
        } else if (req.getParameterMap().containsKey("id")) {
            Long id = Long.parseLong(req.getParameter("id"));
            Developer developer = DeveloperService.getDeveloperService().getDeveloperById(id);
            req.setAttribute("developers", developer);
            req.getRequestDispatcher("developer_info.jsp").forward(req, resp);
        }
        //иначе ничего
        else {
            List<Developer> developers = DeveloperService.getDeveloperService().getAllDevelopers();
            System.out.println(developers.toString());
            req.setAttribute("developers", developers);
            req.getRequestDispatcher("developer_list.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameterMap().containsKey("idedit")){
            doPut(req,resp);
        }
        else if(req.getParameterMap().containsKey("iddelete")){
            doDelete(req,resp);
        }
        else if (req.getParameterMap().containsKey("name")) {
            String name = req.getParameter("name");
            BigDecimal salary = BigDecimal.valueOf(Long.parseLong(req.getParameter("salary")));
            EnumSex sex = req.getParameter("sex").equals("male") ? EnumSex.MALE : EnumSex.FEMALE;
            DeveloperService.getDeveloperService()
                    .addNewDeveloper(new Developer(name, salary, sex));
            resp.sendRedirect("/taskservlet/developers");
        }
        else {
            resp.setStatus(404);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           Developer developer = DeveloperService.getDeveloperService()
                    .getDeveloperById(Long.parseLong(req.getParameter("idedit")));
            if(req.getParameter("name")!=null){
                developer.setName(req.getParameter("name"));
            }
            if(req.getParameter("salary")!=null) {
                try {
                    developer.setSalary(BigDecimal.valueOf(Long.parseLong(req.getParameter("salary"))));
                }
                catch (Exception e){
                }
            }
            if(req.getParameter("sex")!=null){
                developer.setSex(req.getParameter("sex").equals("male") ? EnumSex.MALE : EnumSex.FEMALE);
            }

            DeveloperService.getDeveloperService().updateDeveloperById(developer,developer.getId());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            Long devId = Long.parseLong(req.getParameter("iddelete"));
            DeveloperService.getDeveloperService().deleteDeveloperById(devId);
            resp.sendRedirect("/taskservlet");
    }
}
