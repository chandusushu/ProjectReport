package com.chandu.project;

import java.util.List;

/**
 * This interface is for DataLayer, which helps in storing and retrieving
 */
public interface ProjectDAO {

    List<Project> insert(List<Project> projectList);

    Project insert(Project project);

    Long getUniqueCustomerIdCountByContractId(Integer contractId);

    Long getUniqueCustomerIdCountByGeoZone(String geoZone);

    Double getAverageBuildDurationByZone(String geoZone);

    List<Integer> getUniqueCustomerIdsByGeoZone(String geoZone);

    List<Integer> getUniqueContractIds();

    List<String> getUniqueGeoZones();

}
