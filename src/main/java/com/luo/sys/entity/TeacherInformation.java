package com.luo.sys.entity;

import lombok.Data;

@Data
public class TeacherInformation {

    private Integer uid;

    private String collage;

    private String home;

    public TeacherInformation(Integer uid, String collage, String home) {
        this.uid = uid;
        this.collage = collage;
        this.home = home;
    }
}
