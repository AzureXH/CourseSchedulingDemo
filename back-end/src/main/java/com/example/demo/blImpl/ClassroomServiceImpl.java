package com.example.demo.blImpl;

import com.example.demo.bl.ClassroomService;
import com.example.demo.data.ClassroomData;
import com.example.demo.po.Classroom;
import com.example.demo.vo.ClassroomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzureXH on 2019/7/22
 */
@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    ClassroomData classroomData;

    @Override
    public Boolean addClassroom(ClassroomVO classroomVO) {
        Classroom classroom = new Classroom().v2p(classroomVO);
        classroomData.insert(classroom);
        return true;
    }

    @Override
    public List<ClassroomVO> getAllClassroom() {
        List<Classroom> classroomList = classroomData.findAll();
        List<ClassroomVO> classroomVOList = new ArrayList<ClassroomVO>();
        for (Classroom classroom: classroomList
             ) {
            classroomVOList.add(new ClassroomVO().p2v(classroom));
        }
        return classroomVOList;
    }

    @Override
    public Boolean deleteClassroom(ClassroomVO classroomVO) {
        classroomData.deleteById(classroomVO.getId());
        return true;
    }

    @Override
    public Boolean updateClassroom(ClassroomVO classroomVO) {
        classroomData.save(new Classroom().v2p(classroomVO));
        return true;
    }
}
