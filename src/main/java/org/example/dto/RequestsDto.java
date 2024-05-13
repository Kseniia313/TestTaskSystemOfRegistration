package org.example.dto;

import lombok.Data;

@Data
public class RequestsDto {
    private String title;
    private String description;
    private StatusRequest statusRequest;
}
