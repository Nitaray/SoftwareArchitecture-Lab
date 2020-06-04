package edu.hcmiu.sa.user;

import edu.hcmiu.sa.ui.CalendarUI;

public class ClassOrganizer extends User {
    public void organizeClass() {
        new CalendarUI(this).createNewReservation();
    }
}
