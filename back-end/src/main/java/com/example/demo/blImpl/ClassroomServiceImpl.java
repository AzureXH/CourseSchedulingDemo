package com.example.demo.blImpl;

import com.example.demo.bl.ClassroomService;
import com.example.demo.data.ClassroomData;
import com.example.demo.po.Classroom;
import com.example.demo.vo.ClassroomVO;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
    public List<ClassroomVO> getFreeClassroom(String teachingPattern) {
        //teachingPattern = 周一上午0011 选出周一上午12节有空的
        //剔除目标"周一上午0011" "周一上午1000"
        //首先选出不包含周一上午0011的

        List<Classroom> classroomList = classroomData.findClassroomsByTeachingNotContains(teachingPattern);

        //然后选出含有"周一上午"中教室 不要把下午的0111给删除了
        for (int i = 0; i< classroomList.size(); i++){
            String weekday = teachingPattern.substring(0,4);
            if (classroomList.get(i).getTeaching().contains(weekday)){
                String teaching = classroomList.get(i).getTeaching().substring(4);
                String tempPattern = teachingPattern.substring(4);
                StringBuilder s1 = new StringBuilder();
                for (int j = 0;j<tempPattern.length();j++){
                    if (tempPattern.charAt(j)=='1' || teaching.charAt(j)=='1'){
                        s1.append("1");
                    }else{
                        s1.append("0");
                    }
                }
                String result = s1.toString();
                if (result.contains("0")){
                    classroomList.remove(i);
                }

            }
        }

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
