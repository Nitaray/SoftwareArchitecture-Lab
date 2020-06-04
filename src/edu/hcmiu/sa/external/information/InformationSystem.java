package edu.hcmiu.sa.external.information;

public class InformationSystem {
    private String searchEngineName;

    public InformationSystem() {
        this("Google");
    }

    public InformationSystem(String searchEngineName) {
        this.searchEngineName = searchEngineName;

    }

    public String getInformation(InformationType type) {
        String information = "";
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         * Essentially, this method connects with external systems such as google to gather data depending on the type.
         */
        return information;
    }
}
