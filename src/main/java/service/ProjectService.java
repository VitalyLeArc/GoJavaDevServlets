package service;

import domain.Developer;
import domain.Project;
import repository.ProjectDAO;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProjectService {
    private static final ProjectService projectService = new ProjectService();

    private ProjectService() {
    }

    public static ProjectService getProjectService() {
        return projectService;
    }


    public List<Project> getAllProjectsInfo() {
        return ProjectDAO.getProjectDAO().getAllProjects();
    }

    public BigDecimal getSumSalaryOfDevelopersForProject(String projectName) {
        return ProjectDAO.getProjectDAO().readByName(projectName).getDevelopers()
                .stream()
                .map(Developer::getSalary)
                .reduce(BigDecimal::add).get();
    }

    public List<String> getAllProjectsName(){
        return ProjectDAO.getProjectDAO().getAllProjectsName();
    }

    public Project getProjectById(Long id) {
        return ProjectDAO.getProjectDAO().read(Project.class, id);
    }

    public void addNewDeveloper(Project pr) {
        ProjectDAO.getProjectDAO().create(pr);
    }

    public void updateDeveloperById(Project pr, Long id) {
        ProjectDAO.getProjectDAO().update(Project.class, pr, id);
    }

    public void deleteDeveloperById(Long id) {
        ProjectDAO.getProjectDAO().delete(Project.class, id);
    }
}
