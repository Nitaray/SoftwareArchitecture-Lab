package edu.hcmiu.sa.core.components;

import edu.hcmiu.sa.core.resource.ResourceGatherer;

public class RequestForm {
    /**
     * This class's implementation is beyond the scope of our sequence diagrams.
     * Therefore, we need not implement this class fully.
     */

    private FormType type;

    public FormType getType() {
        return type;
    }

    public RequestForm(FormType type) {
        this.type = type;
        ResourceGatherer.FormMetaData meta = ResourceGatherer.getFormMetadata(type);
    }

    public RequestForm fill(String information) {
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         * Essentially, this method is used to fill this RequestForm object with necessary information.
         */
        return this;
    }

    public void addInfo(String addedInformation) {
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         * Essentially, this method is used to fill this RequestForm object with necessary information.
         */
    }

    public void clear() {
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         * Essentially, this method clears this RequestForm object of all information.
         */
    }

    public boolean checkMetaData() {
        boolean isValid = false;
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         * Essentially, this method verifies the information in this RequestForm object against its metadata.
         */
        return isValid;
    }

    public void close() {
        type = null;
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         * Essentially, this method closes the form by removing all its calls and references, allowing the GC to collect it.
         */
    }

    /**
     * More implementations for this class can go here.
     * E.g: Content, layout, etc.
     */
}
