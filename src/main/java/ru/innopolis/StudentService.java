package ru.innopolis;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Smith on 31.10.2016.
 */
@Service
public class StudentService {
    public List<Student> getStudentList(){
        try {
            return DBWrapper.getInstance().getStudentsList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void deleteStudent(int id) {
        try {
            DBWrapper.getInstance().deleteStudent(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
