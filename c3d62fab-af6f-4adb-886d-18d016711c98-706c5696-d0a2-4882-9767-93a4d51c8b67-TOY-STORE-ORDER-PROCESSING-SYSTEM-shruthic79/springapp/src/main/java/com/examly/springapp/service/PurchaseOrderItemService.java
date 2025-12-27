package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.PurchaseOrderItem;

public interface PurchaseOrderItemService {
    PurchaseOrderItem create(PurchaseOrderItem item);
    List<PurchaseOrderItem> getByOrderId(Long orderId);
}
