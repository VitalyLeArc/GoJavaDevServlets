package web;

import service.DeveloperService;
import service.ProjectService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        //String allMiddleDevelopers = DeveloperService.getDeveloperService().getDevelopersForGrade("middle").toString();
        //String allJavaDevelopers = DeveloperService.getDeveloperService().getDevelopersForSkill("Java").toString();
       // String developersOfUnrealEngine4 = DeveloperService.getDeveloperService().getDevelopersForProjectName("UnrealEngine4").toString();
       // BigDecimal sumSalaryDevelopersOfMinecraft = ProjectService.getProjectService().getSumSalaryOfDevelopersForProject("Minecraft");
       // String infoAllProjects = ProjectService.getProjectService().getAllProjectsInfo();

        System.out.println("\n\n");

        //System.out.println("Список разработчиков уровня Middle " + allMiddleDevelopers);
        //System.out.println("Список разработчиков владеющих Java " + allJavaDevelopers);
        //System.out.println("Список разработчиков в проекте UnrealEngine4 " + developersOfUnrealEngine4);
        //System.out.println("Сумма зп разработчиков в проекте Minecraft " + sumSalaryDevelopersOfMinecraft);
       // System.out.println(infoAllProjects);
        //System.out.println(DeveloperService.getDeveloperService().getAllDevelopers().toString());
        //DeveloperService.getDeveloperService().deleteDeveloperById(10L);
    }
}

//простые запросы для проверки что всё работает
//System.out.println(DeveloperService.getDeveloperService().getDeveloperById(2L));
//System.out.println(ProjectService.getProjectService().getProjectById(1L));