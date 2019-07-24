package com.example.demo.vo;

import com.example.demo.po.Classroom;

/**
 * Created by AzureXH on 2019/7/22
 */
public class ClassroomVO {

    private String id;

    private String building;

    private String room;

    private Integer available;

    private Integer size_level;



    public ClassroomVO p2v(Classroom classroom){
        ClassroomVO classroomVO = new ClassroomVO();
        classroomVO.setId(classroom.getId());
        classroomVO.setBuilding(classroom.getBuilding());
        classroomVO.setRoom(classroom.getRoom());
        classroomVO.setAvailable(classroom.getAvailable());
        classroomVO.setSize_level(classroom.getSize_level());
        return classroomVO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getSize_level() {
        return size_level;
    }

    public void setSize_level(Integer size_level) {
        this.size_level = size_level;
    }
}
