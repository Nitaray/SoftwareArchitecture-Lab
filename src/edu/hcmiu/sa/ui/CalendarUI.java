package edu.hcmiu.sa.ui;

import edu.hcmiu.sa.core.Calendar;
import edu.hcmiu.sa.user.User;
import edu.hcmiu.sa.ui.components.DayUI;
import edu.hcmiu.sa.ui.components.NoticeMessage;
import edu.hcmiu.sa.ui.components.UIObject;
import edu.hcmiu.sa.ui.components.dayTableUI;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class CalendarUI implements UI {
    private List<UIObject> onScreen;

    private Calendar calendar;

    private User caller;

    public CalendarUI(User caller) {
        this.calendar = new Calendar();
        onScreen = new LinkedList<>();
        this.caller = caller;
    }

    public void createNewReservation() {
        calendar.initialize(this);
        List<String> freeRoomIDs;
        do {
            String period = caller.getInput();
            freeRoomIDs = calendar.checkFreeRoom(period);
            if (freeRoomIDs.isEmpty()) {
                displayNoRoomNotice();
            } else {
                displayAvailableRooms();
                String chosenRoomID = caller.getInput();
                calendar.makeReservation(chosenRoomID, period, this);
            }
        } while (freeRoomIDs.isEmpty());
    }

    private void displayAvailableRooms() {
    }

    private void displayNoRoomNotice() {
    }

    @Override
    public void display() {
        onScreen.forEach(UIObject::show);
    }

    @Override
    public void clearDisplay() {
        onScreen.forEach(UIObject::hide);
        onScreen.clear();
    }

    @Override
    public void close() {
        clearDisplay();
        onScreen.clear();
        onScreen = null;
        calendar = null;
    }

    public void displayCalendar(List<Date> freeDays) {
        UIObject dayTable = new dayTableUI();
        freeDays.forEach(date -> {
            UIObject day = new DayUI(date);
            dayTable.addObject(day);
        });
        onScreen.add(dayTable);
        display();
    }

    public void displaySuccessNotice() {
        NoticeMessage successNotice = new NoticeMessage("Room reserved successfully!");
        onScreen.add(successNotice);
        display();
    }

    public void displayFailureNotice() {
        NoticeMessage failureNotice = new NoticeMessage("Something went wrong! Please try again later!");
        onScreen.add(failureNotice);
        display();
    }
}
