package com.farm.entity.dto;

import lombok.Data;

import java.util.List;


@Data
public class Refer {

    private List<String> sources;
    private List<String> license;

}