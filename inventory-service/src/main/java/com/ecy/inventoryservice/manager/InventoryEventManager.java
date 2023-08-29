package com.ecy.inventoryservice.manager;

import com.ecy.data.event.InventoryEvent;
import com.ecy.data.event.OrderEvent;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 24.08.2023
 * Time: 20:26
 */

public interface InventoryEventManager {

    Mono<InventoryEvent> receiveOrder(OrderEvent orderEvent);

    Mono<Void> rejectOrder(OrderEvent orderEvent);

}