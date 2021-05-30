package com.chandu.project.test;
import com.chandu.project.*;
import com.chandu.project.Project;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectDAOTest {

    static List<Project> projectList = new ArrayList<>();

    static ProjectDAO projectDAO;

   @BeforeAll
   public static void init() {
       projectList.add(Project.ProjectBuilder.newInstance().setCustomerId(1)
               .setContractId(1).setGeozone("us_east").setTeamcode("A")
               .setProjectcode("ProjectApple").setBuildduration(10000).build());
       projectList.add(Project.ProjectBuilder.newInstance().setCustomerId(2)
               .setContractId(1).setGeozone("us_west").setTeamcode("B")
               .setProjectcode("ProjectBanana").setBuildduration(7000).build());
       projectList.add(Project.ProjectBuilder.newInstance().setCustomerId(1)
               .setContractId(2).setGeozone("eu_west").setTeamcode("C")
               .setProjectcode("ProjectCarrot").setBuildduration(8000).build());
       projectList.add(Project.ProjectBuilder.newInstance().setCustomerId(4)
               .setContractId(3).setGeozone("eu_west").setTeamcode("D")
               .setProjectcode("ProjectDate").setBuildduration(3000).build());
       projectDAO = new ProjectDAOImpl();
       projectDAO.insert(projectList);
   }

   @Test
   public void findnumofUniqueCustomerIdByContractId() {

       Assertions.assertEquals(2,projectDAO.getUniqueCustomerIdCountByContractId(1));
       Assertions.assertEquals(1,projectDAO.getUniqueCustomerIdCountByContractId(2));
       Assertions.assertEquals(1,projectDAO.getUniqueCustomerIdCountByContractId(3));

   }

    @Test
    public void findUniqueCustomerIdCountByGeoZone() {

        Assertions.assertEquals(1,projectDAO.getUniqueCustomerIdCountByGeoZone("us_east"));
        Assertions.assertEquals(1,projectDAO.getUniqueCustomerIdCountByGeoZone("us_west"));
        Assertions.assertEquals(2,projectDAO.getUniqueCustomerIdCountByGeoZone("eu_west"));

    }

    @Test
    public void getaverageBuildDurationByZone() {

        Assertions.assertEquals(10000.0,projectDAO.getAverageBuildDurationByZone("us_east"));
        Assertions.assertEquals(7000.0,projectDAO.getAverageBuildDurationByZone("us_west"));
        Assertions.assertEquals(5500.0,projectDAO.getAverageBuildDurationByZone("eu_west"));

    }

    @Test
    public void getUniqueCustomerIdsByGeoZone() {

        Assert.assertTrue(projectDAO.getUniqueCustomerIdsByGeoZone("us_east").equals(Arrays.asList(1)));
        Assert.assertTrue(projectDAO.getUniqueCustomerIdsByGeoZone("us_west").equals(Arrays.asList(2)));
        Assert.assertTrue(projectDAO.getUniqueCustomerIdsByGeoZone("eu_west").equals(Arrays.asList(1,4)));

    }

}
