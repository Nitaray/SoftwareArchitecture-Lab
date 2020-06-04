package edu.hcmiu.sa.core;

import edu.hcmiu.sa.core.components.RequestForm;

public class NotificationCenter {
    public void notifyNewRequest(RequestForm requestForm) {
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        System.out.println("New request received! The request address is " + requestForm.toString()); // Sample implementation
    }

    public void notifySystemError(RequestForm requestForm) {
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        System.err.println("A problem occurred when trying to add this request " + requestForm.toString() + " to the database!"); // Sample
        // implementation
    }
}
