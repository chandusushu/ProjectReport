package com.chandu.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is implementation of ReportService.
 */
public class ReportServiceImpl implements ReportService {

    private ProjectDAO projectDAOImpl;

    @Override
    public String numofUniqueCustomerIdByContractId() {

        StringBuilder stringBuilder = new StringBuilder();

        List<Integer> uniqueContractIds = projectDAOImpl.getUniqueContractIds();

        for (Integer contractId : uniqueContractIds) {

            long uniqueCustomerIds = projectDAOImpl.getUniqueCustomerIdCountByContractId(contractId);

            stringBuilder.append(" The number of unique customerIds for ContractId ");
            stringBuilder.append(contractId);
            stringBuilder.append(" is : ");
            stringBuilder.append(uniqueCustomerIds);
            stringBuilder.append("\r\n");

        }
        return stringBuilder.toString();
    }

    @Override
    public String numofUniqueCustomerIdByGeozone() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> uniqueGeoZones = projectDAOImpl.getUniqueGeoZones();
        for (String geoZone : uniqueGeoZones) {
            long uniqueCustomerIds = projectDAOImpl.getUniqueCustomerIdCountByGeoZone(geoZone);
            stringBuilder.append(" The number of unique customerIds for Geo zone ");
            stringBuilder.append(geoZone);
            stringBuilder.append(" is : ");
            stringBuilder.append(uniqueCustomerIds);
            stringBuilder.append("\r\n");

        }
        return stringBuilder.toString();
    }

    @Override
    public String averageBuildDurationByZone() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> uniqueGeoZones = projectDAOImpl.getUniqueGeoZones();
        for (String geoZone : uniqueGeoZones) {
            Double averageDuration = projectDAOImpl.getAverageBuildDurationByZone(geoZone);
            stringBuilder.append(" The average build duration for Geo zone ");
            stringBuilder.append(geoZone);
            stringBuilder.append(" is : ");
            stringBuilder.append(averageDuration);
            stringBuilder.append("\r\n");

        }
        return stringBuilder.toString();
    }

    @Override
    public String uniqueCustomerIdsByZone() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> uniqueGeoZones = projectDAOImpl.getUniqueGeoZones();
        for (String geoZone : uniqueGeoZones) {
            List<Integer> customerIdsList = projectDAOImpl.getUniqueCustomerIdsByGeoZone(geoZone);
            stringBuilder.append(" The unique customerIds for Geo zone ");
            stringBuilder.append(geoZone);
            stringBuilder.append(" is : ");
            stringBuilder.append(customerIdsList);
            stringBuilder.append("\r\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public void generateReport() {
        setDAO(new ProjectDAOImpl());
        buildProjectInfo();
        StringBuilder sb = new StringBuilder();
        sb.append(numofUniqueCustomerIdByContractId());
        sb.append(numofUniqueCustomerIdByGeozone());
        sb.append(averageBuildDurationByZone());
        sb.append(uniqueCustomerIdsByZone());
        System.out.println(sb.toString());
    }

    private void setDAO(ProjectDAO projectDAO) {
        this.projectDAOImpl = projectDAO;
    }

    @Override
    public void buildProjectInfo() {
        List<Project> projectList = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(System.in);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data !=null && !data.isEmpty()) {
                    String[] infos = data.split(",");
                    Project projectInfo = Project.ProjectBuilder.newInstance().setCustomerId(Integer.parseInt(infos[0]))
                            .setContractId(Integer.parseInt(infos[1])).setGeozone(infos[2]).setTeamcode(infos[3])
                            .setProjectcode(infos[4]).setBuildduration(Long.parseLong(infos[5])).build();
                    projectList.add(projectInfo);
                } else {
                    break;
                }
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("Error happened during building data");
        }
        projectDAOImpl.insert(projectList);
    }
}
