package com.ecy.firstservice.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class FirstEntity {

    @Id
    private String id;
    private String description;

}
