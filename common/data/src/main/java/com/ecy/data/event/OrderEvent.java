package com.ecy.data.event;

import com.ecy.data.dto.OrderDTO;
import com.ecy.data.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 22:58
 */

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class OrderEvent extends BaseEvent {

    private OrderDTO orderDTO;
    private OrderStatus orderStatus;

}