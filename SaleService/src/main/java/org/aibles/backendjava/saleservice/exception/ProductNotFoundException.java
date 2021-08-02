package org.aibles.backendjava.saleservice.exception;

import org.aibles.backendjava.saleservice.exception.common.SaleServiceError;
import org.aibles.backendjava.saleservice.exception.common.SaleServiceException;

public class ProductNotFoundException extends SaleServiceException {

    public ProductNotFoundException(){
        super(SaleServiceError.PRODUCT_NOT_FOUND);
    }
}
