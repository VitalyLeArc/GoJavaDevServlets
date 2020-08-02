package service;

import domain.Developer;
import domain.enums.EnumGrade;
import repository.DeveloperDAO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeveloperService {

    private static final DeveloperService developerService = new DeveloperService();

    private DeveloperService(){}

    public static DeveloperService getDeveloperService() {
        return developerService;
    }

    public List<Developer> getDevelopersForGrade(String grade) {
        return DeveloperDAO.getDeveloperDao().getDevelopersForGrade(EnumGrade.getEnumForString(grade));
    }

    public List<Developer> getDevelopersForSkill(String skill) {
        return DeveloperDAO.getDeveloperDao().getDevelopersForSkill(skill);
    }
    public Set<Developer> getDevelopersForProjectName(String projectName){
        return DeveloperDAO.getDeveloperDao().getDevelopersForProjectName(projectName);
    }
    public Developer getDeveloperById(Long id) {
        return DeveloperDAO.getDeveloperDao().read(Developer.class, id);
    }

    public void addNewDeveloper(Developer dev) {
        DeveloperDAO.getDeveloperDao().create(dev);
    }

    public void updateDeveloperById(Developer dev, Long id) {
        DeveloperDAO.getDeveloperDao().update(Developer.class, dev, id);
    }

    public void deleteDeveloperById(Long id) {
        DeveloperDAO.getDeveloperDao().delete(Developer.class, id);
    }

    public List<Developer> getAllDevelopers(){
        return DeveloperDAO.getDeveloperDao().getAllDevelopers();
    }
}
