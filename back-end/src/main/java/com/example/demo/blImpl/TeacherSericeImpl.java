package com.example.demo.blImpl;

import com.example.demo.bl.TeacherService;
import com.example.demo.data.TeacherData;
import com.example.demo.po.Teacher;
import com.example.demo.vo.TeacherVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzureXH on 2019/7/22
 */
@Service
public class TeacherSericeImpl implements TeacherService {

    @Autowired
    TeacherData teacherData;

    @Override
    public List<TeacherVO> getAllTeacher() {
        List<TeacherVO> teacherVOList = new ArrayList<TeacherVO>();
        List<Teacher> teacherList = teacherData.findAll();
        for (Teacher teacher: teacherList
             ) {
            teacherVOList.add(new TeacherVO().p2v(teacher));
        }
        return teacherVOList;
    }

    @Override
    public List<TeacherVO> getFreeTeacher(String teachingPattern, String department) {
        List<Teacher> teacherList = teacherData.
                findTeachersByTeachingNotContainsAndDepartmentEquals(
                        teachingPattern,
                        department);

        for (int i = 0; i< teacherList.size(); i++){
            String weekday = teachingPattern.substring(0,4);
            if (teacherList.get(i).getTeaching().contains(weekday)){
                String teaching = teacherList.get(i).getTeaching().substring(4);
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
                    teacherList.remove(i);
                }

            }
        }

        List<TeacherVO> teacherVOList = new ArrayList<TeacherVO>();
        for (Teacher teacher: teacherList
        ) {
            teacherVOList.add(new TeacherVO().p2v(teacher));
        }
        return teacherVOList;
    }

    @Override
    public Boolean addTeacher(TeacherVO teacherVO) {
        Teacher teacher = new Teacher().v2p(teacherVO);
        teacherData.insert(teacher);
        return true;
    }

    @Override
    public Boolean deleteTeacher(TeacherVO teacherVO) {
        teacherData.deleteById(teacherVO.getId());
        return true;
    }

    @Override
    public Boolean updateTeacher(TeacherVO teacherVO) {
        teacherData.save(new Teacher().v2p(teacherVO));
        return true;
    }
}
