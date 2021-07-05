package com.luo.sys.entity;

import lombok.Data;

@Data
public class StudentScore {
    private Integer uid;

    private Integer math;

    private Integer english;

    private Integer clang;

    private Integer python;

    private Integer history;

    private Integer physics;

    private Integer cpp;

    public StudentScore(Integer uid, Integer math, Integer english, Integer clang, Integer python, Integer history, Integer physics, Integer cpp) {
        this.uid = uid;
        this.math = math;
        this.english = english;
        this.clang = clang;
        this.python = python;
        this.history = history;
        this.physics = physics;
        this.cpp = cpp;
    }
}