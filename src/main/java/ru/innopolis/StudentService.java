package ru.innopolis;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
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
            return HibernateDBWrapper.getInstance().getStudentsList();
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
