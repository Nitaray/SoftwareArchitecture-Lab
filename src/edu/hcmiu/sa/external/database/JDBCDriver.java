package edu.hcmiu.sa.external.database;

import edu.hcmiu.sa.core.components.RequestForm;
import edu.hcmiu.sa.core.components.Reservation;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class JDBCDriver {
    public String addToDatabase(RequestForm requestForm) {
        String status = "Failure";
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         * Essentially, this method adds the requestForm to the database.
         * Implementation of this method would requires implementations of more classes than necessary
         * to represent our sequence diagrams.
         */
        return status;
    }

    public String getSoftwareInformation(RequestForm filledForm) {
        String softwareInformation = "";
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        return softwareInformation;
    }

    public String addTrainingRequest(String softwareInformation) {
        String status = "Failure";
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        return status;
    }

    public String getHardwareInformation(RequestForm filledForm) {
        String hardwareInformation = "";
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        return hardwareInformation;
    }

    public String addRepairRequest(String hardwareInformation) {
        String status = "Failure";
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        return status;
    }

    public List<Date> getFreeRooms() {
        List<Date> free = new LinkedList<>();
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        return free;
    }

    public String addReservationToDB(Reservation reservation) {
        String status = "Failure";
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        return status;
    }
}
