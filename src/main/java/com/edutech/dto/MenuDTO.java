package com.edutech.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MenuDTO {

    Long id;
    String name;
    String url;
    Boolean isLinked;
    List<Map<String,Long>> subMenuIdList;

}
