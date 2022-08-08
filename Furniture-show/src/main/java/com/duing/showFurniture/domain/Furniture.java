package com.duing.showFurniture.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Furniture {
    private Integer id;

    private String name;

    private Double price;

    private String mainImgUrl;

    private List<String> viceImgUrl;

    private Integer inventory;
}
