package com.ecy.data.event;

import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

/**
 * Author: ecyamak
 * Date: 24.08.2023
 * Time: 20:38
 */
@Getter
public abstract class BaseEvent implements Event {

    private final String eventId = UUID.randomUUID().toString();
    private final Instant creationDate = Instant.now();

}