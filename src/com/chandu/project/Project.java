package com.chandu.project;
/**
 * This class is data model for project Info and provides builder for creating objects of Project
 */
public class Project {

    private int customerId;

    private int contractId;

    private String geozone;

    private String teamcode;

    private String projectcode;

    private long buildduration;

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getGeozone() {
        return geozone;
    }

    public void setGeozone(String geozone) {
        this.geozone = geozone;
    }

    public String getTeamcode() {
        return teamcode;
    }

    public void setTeamcode(String teamcode) {
        this.teamcode = teamcode;
    }

    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

    public long getBuildduration() {
        return buildduration;
    }

    public void setBuildduration(long buildduration) {
        this.buildduration = buildduration;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

   public Project(ProjectBuilder builder){

        this.buildduration = builder.buildduration;
        this.contractId = builder.contractId;
        this.customerId = builder.customerId;
        this.geozone = builder.geozone;
        this.teamcode = builder.teamcode;
        this.projectcode = builder.projectcode;
    }

    @Override
    public String toString() {
        return "Project{" +
                "customerId=" + customerId +
                ", contractId=" + contractId +
                ", geozone='" + geozone + '\'' +
                ", teamcode='" + teamcode + '\'' +
                ", projectcode='" + projectcode + '\'' +
                ", buildduration=" + buildduration +
                '}';
    }


    public static class ProjectBuilder {

        private int customerId;

        private int contractId;

        private String geozone;

        private String teamcode;

        private String projectcode;

        private long buildduration;


        public static ProjectBuilder newInstance()
        {
            return new ProjectBuilder();
        }

        private ProjectBuilder() {}

        public Project build(){
           return new Project(this);
        }

        public ProjectBuilder setCustomerId(int customerId) {
            this.customerId = customerId;
            return this;
        }

        public ProjectBuilder setContractId(int contractId) {
            this.contractId = contractId;
            return this;
        }

        public ProjectBuilder setGeozone(String geozone) {
            this.geozone = geozone;
            return this;
        }
        public ProjectBuilder setTeamcode(String teamcode) {
            this.teamcode = teamcode;
            return this;
        }

        public ProjectBuilder setProjectcode(String projectcode) {
            this.projectcode = projectcode;
            return this;
        }
        public ProjectBuilder setBuildduration(long buildduration) {
            this.buildduration = buildduration;
            return this;
        }
    }
}

