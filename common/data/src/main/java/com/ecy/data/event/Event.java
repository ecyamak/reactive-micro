package com.ecy.data.event;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 22:59
 */

public interface Event {

    String getEventId();
    Instant getCreationDate();

}