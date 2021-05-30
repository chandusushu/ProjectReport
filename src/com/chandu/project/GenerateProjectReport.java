package com.chandu.project;

/**
 * This class is Main class of the application
 */
public class GenerateProjectReport {

    public static void main(String[] args) {

        ReportService reportService = new ReportServiceImpl();
        reportService.generateReport();
    }

}
