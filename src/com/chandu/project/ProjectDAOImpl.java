package com.chandu.project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is implementation of DataLayer,which helps in storing and retrieving
 */
public class ProjectDAOImpl implements ProjectDAO {

    List<Project> projectList;

    @Override
    public List<Project> insert(List<Project> projectList) {
        if(this.projectList == null){
            this.projectList = new ArrayList<>();
        }
        this.projectList.addAll(projectList);
        return projectList;
    }

    @Override
    public Project insert(Project projectInfo) {
        if(this.projectList == null){
            this.projectList = new ArrayList<>();
        }
         this.projectList.add(projectInfo);
         return projectInfo;
    }

    @Override
    public Long getUniqueCustomerIdCountByContractId(Integer contractId) {
        return this.projectList.stream().filter(p -> p.getContractId()==contractId).map(p->p.getCustomerId()).distinct().count();
    }

    @Override
    public Long getUniqueCustomerIdCountByGeoZone(String geoZone) {
        return this.projectList.stream().filter(p -> geoZone.equals(p.getGeozone())).map(p->p.getCustomerId()).distinct().count();
    }

    @Override
    public Double getAverageBuildDurationByZone(String geoZone) {
        return  this.projectList.stream().filter(p -> geoZone.equals(p.getGeozone())).mapToLong(p -> p.getBuildduration()).average().getAsDouble();
    }

    @Override
    public List<Integer> getUniqueCustomerIdsByGeoZone(String geoZone) {
        return  this.projectList.stream().filter(p -> geoZone.equals(p.getGeozone())).map(p->p.getCustomerId()).distinct().collect(Collectors.toList());
    }

    @Override
    public List<Integer> getUniqueContractIds() {
        return  projectList.stream().map(p -> p.getContractId()).distinct().collect(Collectors.toList());
    }

    @Override
    public List<String> getUniqueGeoZones() {
        return  projectList.stream().map(p -> p.getGeozone()).distinct().collect(Collectors.toList());
    }
}
