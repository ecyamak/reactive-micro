package com.ecy.data.event;

import com.ecy.data.dto.BaseDTO;
import com.ecy.data.dto.InventoryDTO;
import com.ecy.data.dto.OrderDTO;
import com.ecy.data.dto.PaymentDTO;
import com.ecy.data.enums.InventoryStatus;
import com.ecy.data.enums.OrderStatus;
import com.ecy.data.enums.PaymentStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Author: ecyamak
 * Date: 27.08.2023
 * Time: 14:33
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class EventFactory {

    public static Event receive(EventType eventType, BaseDTO dto) {
        return switch (eventType) {
            case ORDER -> OrderEvent.of((OrderDTO) dto, OrderStatus.RECEIVED);
            case PAYMENT -> PaymentEvent.of((PaymentDTO) dto, PaymentStatus.RECEIVED);
            case INVENTORY -> InventoryEvent.of((InventoryDTO) dto, InventoryStatus.RECEIVED);
            default -> throw new IllegalArgumentException();
        };
    }

    public static Event reject(EventType eventType, BaseDTO dto) {
        return switch (eventType) {
            case ORDER -> OrderEvent.of((OrderDTO) dto, OrderStatus.REJECTED);
            case PAYMENT -> PaymentEvent.of((PaymentDTO) dto, PaymentStatus.REJECTED);
            case INVENTORY -> InventoryEvent.of((InventoryDTO) dto, InventoryStatus.REJECTED);
            default -> throw new IllegalArgumentException();
        };
    }

}