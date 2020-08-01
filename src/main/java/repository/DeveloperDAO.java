package repository;

import domain.Developer;
import domain.Project;
import domain.Skill;
import domain.enums.EnumGrade;
import repository.abstracts.DAO;

import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeveloperDAO extends DAO<Developer> {
    private final static DeveloperDAO developerDAO = new DeveloperDAO();

    private DeveloperDAO() {}

    public static DeveloperDAO getDeveloperDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence_task");
        return developerDAO;
    }

    public List<Developer> getDevelopersForGrade(EnumGrade grade) {
        startNewEntityManager();
        List<Skill> skills = entityManager.createQuery("From Skill sk where sk.grade=:grade_name")
                .setParameter("grade_name", grade)
                .getResultList();
        List<Developer> listSetDev = skills
                .stream()
                .flatMap(skill -> skill.getDevelopers().stream())
                .collect(Collectors.toList());
        entityManager.close();
        return listSetDev;
    }

    public List<Developer> getDevelopersForSkill(String skill) {
            skill = skill.toLowerCase();
            startNewEntityManager();
            List<Skill> skills = entityManager.createQuery("From Skill sk where sk.name=:sk_name")
                    .setParameter("sk_name", skill)
                    .getResultList();
            List<Developer> listSetDev = skills
                    .stream()
                    .flatMap(skillInStream ->skillInStream.getDevelopers().stream())
                    .collect(Collectors.toList());
            entityManager.close();
            return listSetDev;
    }

    public Set<Developer> getDevelopersForProjectName(String projectName) {
        startNewEntityManager();
        Project project = (Project) entityManager.createQuery("from Project pr where pr.name=:prname")
                .setParameter("prname", projectName)
                .getResultList().stream().findFirst().orElse(null);
        entityManager.close();
        return project != null ? project.getDevelopers() : new HashSet<>();
    }

    /*по заданию
        список всех Java разработчиков;
        список всех middle разработчиков;
     */
}
