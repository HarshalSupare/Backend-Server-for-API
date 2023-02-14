package com.restAPI.wrapper;

public class StudentData {
    private Integer s_id;

    private String s_name;

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }


    @Override
    public String toString() {
        return "StudentData{" + "s_id=" + s_id +", s_name='" + s_name + '\'' +'}';
    }
}
