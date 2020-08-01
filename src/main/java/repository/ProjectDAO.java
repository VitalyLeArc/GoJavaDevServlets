package repository;

import domain.Developer;
import domain.Project;
import repository.abstracts.DAO;

import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectDAO extends DAO<Project> {

    private ProjectDAO() {
    }

    private static final ProjectDAO projectDAO = new ProjectDAO();

    public static ProjectDAO getProjectDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence_task");
        return projectDAO;
    }

    public List<Project> getAllProjects() {
        startNewEntityManager();
        List<Project> projects = entityManager.createQuery("from Project").getResultList();
        entityManager.close();
        return projects;
    }

    public Project readByName(String projectName) {
        startNewEntityManager();
        Project project = (Project) entityManager
                .createQuery("from Project where name=:prname")
                .setParameter("prname", projectName)
                .getSingleResult();
        entityManager.close();
        return project;
    }

    public List<String> getAllProjectsName(){
        startNewEntityManager();
        List<Project> projects = entityManager.createQuery("from Projects").getResultList();
                entityManager.close();
                return projects.stream()
                        .map(Project::getName)
                        .collect(Collectors.toList());
    }
    /*по заданию
        список разработчиков отдельного проекта;
        список проектов в следующем формате: дата создания - название проекта - количество разработчиков на этом проекте.
        зарплату(сумму) всех разработчиков отдельного проекта ;
    */
}
