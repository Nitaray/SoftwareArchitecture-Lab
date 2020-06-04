package edu.hcmiu.sa.external.supplier;

import java.util.Date;

public class HardwareSupplierServer extends Supplier {
    private String supplierName;

    public HardwareSupplierServer(String supplier) {
        supplierName = supplier;
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
    }

    @Override
    public String checkOutConfirm(String address, String billingInfo) {
        Date deliveryDate = new Date();
        /**
         * This method's implementation is beyond the scope of our sequence diagrams.
         */
        return deliveryDate.toString();
    }
}
