package ru.innopolis;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBWrapper
{
    private static Connection con;
    private static DBWrapper instance;
    private static DataSource dataSource;

    private DBWrapper() {
    }

    public static synchronized DBWrapper getInstance() {
        if (instance == null) {
            try {
                instance = new DBWrapper();
                Context ctx = new InitialContext();
                instance.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/studentsDS");
                con = dataSource.getConnection();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public List<Student> getStudentsList() throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");
        List<Student> student_list = studentListFromResultSet(rs);
        rs.close();
        stmt.close();
        return student_list;
    }

    public List<Student> getStudentsListSortedBy(String field) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(new StringBuilder("SELECT * FROM student").append(" SORT BY ").append(field).toString() );
        List<Student> student_list = studentListFromResultSet(rs);
        rs.close();
        stmt.close();
        return student_list;
    }

    public List<Student> getStudentsWith(String field, String value) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(new StringBuilder("SELECT * FROM student")
                .append(" WHERE ").append(field)
                .append(" = ").append(value)
                .toString()
        );
        List<Student> student_list = studentListFromResultSet(rs);
        rs.close();
        stmt.close();
        return student_list;
    }

    private List<Student> studentListFromResultSet(ResultSet rs) throws SQLException {
        List<Student> student_list = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student();
            student.setDbId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setSurname(rs.getString("surname"));
            student.setDateOfBirth(rs.getDate("dob"));
            switch (rs.getString("sex")){
                case "M": student.setSex(Student.Sex.MALE); break;
                case "F": student.setSex(Student.Sex.FEMALE); break;
            }
            student_list.add(student);
        }
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
                        .append(student.getDbId())
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