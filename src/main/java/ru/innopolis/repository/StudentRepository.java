package ru.innopolis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.Student;

import java.util.List;

/**
 * Created by Smith on 09.11.2016.
 */
@Transactional
public interface StudentRepository extends CrudRepository<Student,Integer> {
    void deleteById(Iterable<Integer> ids);
}
