package com.chandu.project;

/**
 * This is interface for generating reports.
 */
public interface ReportService {

   String  numofUniqueCustomerIdByContractId();

   String  numofUniqueCustomerIdByGeozone();

   String averageBuildDurationByZone();

   String uniqueCustomerIdsByZone();

    void generateReport();

    void buildProjectInfo();

}
