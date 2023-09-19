package com.ecy.data.event;

import com.ecy.data.dto.InventoryDTO;
import com.ecy.data.enums.InventoryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 23:14
 */

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(callSuper = true)
public class InventoryEvent extends BaseEvent {

    private InventoryDTO inventoryDTO;
    private InventoryStatus inventoryStatus;

}