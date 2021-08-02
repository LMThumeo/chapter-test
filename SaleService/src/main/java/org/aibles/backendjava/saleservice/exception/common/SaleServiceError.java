package org.aibles.backendjava.saleservice.exception.common;

public enum SaleServiceError {
    PRODUCT_NOT_FOUND(404, "Product not found");
    private final int errorCode;

    private final String errorMessage;

    SaleServiceError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
