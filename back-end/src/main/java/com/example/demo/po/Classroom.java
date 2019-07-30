package com.example.demo.po;

import com.example.demo.vo.ClassroomVO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by AzureXH on 2019/7/22
 */
@Document(collection = "classroom")
public class Classroom {

    @Id
    private String id;

    private String building;

    private String room;

    private Integer available;

    private Integer size_level;

    private String teaching;

    public Classroom v2p(ClassroomVO classroomVO){
        Classroom classroom = new Classroom();
        classroom.setId(classroomVO.getId());
        classroom.setBuilding(classroomVO.getBuilding());
        classroom.setRoom(classroomVO.getRoom());
        classroom.setAvailable(classroomVO.getAvailable());
        classroom.setSize_level(classroomVO.getSize_level());
        classroom.setTeaching(classroomVO.getTeaching());
        return classroom;
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

    public String getTeaching() {
        return teaching;
    }

    public void setTeaching(String teaching) {
        this.teaching = teaching;
    }
}
