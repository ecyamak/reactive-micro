package com.ecy.data.event;

import com.ecy.data.dto.InventoryDTO;
import com.ecy.data.enums.InventoryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 23:14
 */

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class InventoryEvent extends BaseEvent {

    private InventoryDTO inventoryDTO;
    private InventoryStatus inventoryStatus;

}