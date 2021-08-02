package org.aibles.backendjava.saleservice.exception.common;

public abstract class SaleServiceException extends RuntimeException {

    private final SaleServiceError saleServiceError;

    protected SaleServiceException(SaleServiceError saleServiceError){
        super();
        this.saleServiceError = saleServiceError;
    }

    public SaleServiceError getSaleServiceError() {
        return saleServiceError;
    }
}
