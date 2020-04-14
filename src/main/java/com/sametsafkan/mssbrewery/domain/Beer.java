package com.sametsafkan.mssbrewery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Beer {
    private UUID id;
    private String name;
    private String style;
    private Long upc;
}
