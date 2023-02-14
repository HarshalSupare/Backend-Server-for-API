package com.restAPI.wrapper;

public class StudentMarksData {
    private Integer school_id;
    private Integer s_id;
    private Integer score;
    private String status;

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentMarksData{" +
                "school_id=" + school_id +
                ", s_id=" + s_id +
                ", score=" + score +
                ", status='" + status + '\'' +
                '}';
    }
}
