package web;

import domain.Project;
import service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(urlPatterns = "/projects")
public class ProjectController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //выбрать сумму зп разработчиков проекта
        if (req.getParameterMap().containsKey("projectdevssalarysum")) {
            String projectName = req.getParameter("projectdevssalarysum");
            BigDecimal projectDevelopersSalarySum = ProjectService.getProjectService().getSumSalaryOfDevelopersForProject(projectName);
            System.out.println(projectDevelopersSalarySum);
            System.out.println(projectDevelopersSalarySum.toString());
            req.setAttribute("projectdevssalarysum",projectDevelopersSalarySum);
            req.getRequestDispatcher("salary_sum.jsp").forward(req,resp);
        }
        //выбрать все проекты
        else {
            List<Project> projects = ProjectService.getProjectService().getAllProjectsInfo();
            req.setAttribute("projects",projects);
            req.getRequestDispatcher("project_list.jsp").forward(req,resp);

        }

    }
}
