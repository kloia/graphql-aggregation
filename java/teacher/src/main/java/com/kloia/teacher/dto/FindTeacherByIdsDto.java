package com.kloia.teacher.dto;

import lombok.Data;

import java.util.List;

@Data
public class FindTeacherByIdsDto {
    List<Integer> ids;
}
