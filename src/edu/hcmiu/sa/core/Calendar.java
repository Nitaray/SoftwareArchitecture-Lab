package edu.hcmiu.sa.core;

import edu.hcmiu.sa.core.components.Reservation;
import edu.hcmiu.sa.external.database.JDBCDriver;
import edu.hcmiu.sa.ui.CalendarUI;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Calendar {
    List<Date> freeDays;

    JDBCDriver jdbcDriver = new JDBCDriver();

    public void initialize(CalendarUI caller) {
        freeDays = jdbcDriver.getFreeRooms();
        caller.displayCalendar(freeDays);
    }

    public List<String> checkFreeRoom(String period) {
        List<String> roomIDs = new LinkedList<>();
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        return roomIDs;
    }

    public void makeReservation(String chosenRoomID, String period, CalendarUI caller) {
        Reservation reservation = new Reservation(chosenRoomID, period);
        String SQLStatus = jdbcDriver.addReservationToDB(reservation);
        if (SQLStatus.equals("Success")) {
            caller.displaySuccessNotice();
        } else {
            caller.displayFailureNotice();
        }
    }
}
