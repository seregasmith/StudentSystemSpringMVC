package ru.innopolis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Smith on 31.10.2016.
 */
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Iterable<Student> getStudentList(){
        return studentRepository.findAll();
    }

    public void deleteStudent(int id) {
        studentRepository.delete(id);
    }

    public void deleteStudents(Iterable<String> ids) {
        List<Integer> ids_int = new ArrayList<>();
        for (String s : ids){
            ids_int.add(Integer.parseInt(s));
        }
        studentRepository.deleteById(ids_int);
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }
}
