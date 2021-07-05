package com.luo.sys.entity;

import lombok.Data;

@Data
public class StudentInformation {
    private Integer uid;

    private String collage;

    private Integer grade;

    private String major; //Profession

    private Integer group; //Class

    private Integer studyYear; //n学年制

    private String home;

    public StudentInformation(Integer uid, String collage, Integer grade, String major, Integer group, Integer studyYear, String home) {
        this.uid = uid;
        this.collage = collage;
        this.grade = grade;
        this.major = major;
        this.group = group;
        this.studyYear = studyYear;
        this.home = home;
    }
}
