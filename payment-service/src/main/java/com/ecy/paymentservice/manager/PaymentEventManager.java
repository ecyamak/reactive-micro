package com.ecy.paymentservice.manager;

import com.ecy.data.event.OrderEvent;
import com.ecy.data.event.PaymentEvent;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 23.08.2023
 * Time: 02:03
 */

public interface PaymentEventManager {

    Mono<PaymentEvent> receiveOrder(OrderEvent orderEvent);

    Mono<Void> cancelOrder(OrderEvent orderEvent);

}