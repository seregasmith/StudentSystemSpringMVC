package ru.innopolis;

import org.hibernate.transform.Transformers;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Smith on 07.11.2016.
 */
public class HibernateDBWrapper {
    private static Connection con;
    private static HibernateDBWrapper instance;
    private static DataSource dataSource;
    private static EntityManager entityManager;

    private HibernateDBWrapper() {
    }

    public static synchronized HibernateDBWrapper getInstance() {
        if (instance == null) {
            try {
                instance = new HibernateDBWrapper();
            }catch (Exception e){

            }
        }
        return instance;
    }

    public List<Student> getStudentsList() throws SQLException {
        entityManager = HibernateUtil.getEm();
//        Query query = entityManager.createQuery("from Student");
//
//        List<Student> list = query.getResultList();

        Query query = entityManager.createNativeQuery("SELECT * FROM " + "studentz" + ";");
        List<Student> list = query.getResultList();
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM student");
//        List<Student> student_list = studentListFromResultSet(rs);
//        rs.close();
//        stmt.close();
        entityManager.close();
        return list;
    }

    public List<Student> getStudentsListSortedBy(String field) throws SQLException {
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery(new StringBuilder("SELECT * FROM student").append(" SORT BY ").append(field).toString() );
//        List<Student> student_list = studentListFromResultSet(rs);
//        rs.close();
//        stmt.close();
        List<Student> student_list = null;
        return student_list;
    }

    public List<Student> getStudentsWith(String field, String value) throws SQLException {
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery(new StringBuilder("SELECT * FROM student")
//                .append(" WHERE ").append(field)
//                .append(" = ").append(value)
//                .toString()
//        );
//        List<Student> student_list = studentListFromResultSet(rs);
//        rs.close();
//        stmt.close();
        List<Student> student_list = null;
        return student_list;
    }

    public long deleteStudent(int id) throws SQLException {
        Statement stmt = con.createStatement();
        long res = stmt.executeUpdate(
                new StringBuilder("DELETE FROM student WHERE id = ")
                        .append(String.valueOf(id))
                        .toString()
        );
        stmt.close();
        return res;
    }

    public long updateStudent(Student student) throws SQLException {
        Statement stmt = con.createStatement();
        long res = stmt.executeUpdate(
                new StringBuilder("UPDATE student SET (name,surname,dob,sex) VALUES (")
                        .append(student.getName()).append(",")
                        .append(student.getSurname()).append(",")
                        .append(student.getDateOfBirth()).append(",")
                        .append(Student.Sex.MALE.equals(student.getSex())?"M":"F").append(")")
                        .append(" WHERE id = ")
                        .append(student.getId())
                        .toString()
        );
        stmt.close();
        return res;
    }

    public long createStudent(Student student) throws SQLException {
        Statement stmt = con.createStatement();
        long res = stmt.executeUpdate(
                new StringBuilder("INSERT INTO student VALUES (")
                        .append("nextval('student_id_seq')")
                        .append(student.getName()).append(",")
                        .append(student.getSurname()).append(",")
                        .append(student.getDateOfBirth()).append(",")
                        .append(Student.Sex.MALE.equals(student.getSex())?"M":"F").append(")")
                        .toString()
        );
        stmt.close();
        return res;
    }
}
