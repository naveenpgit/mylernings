package junit_demo.commmon;

import junit_demo.commmon.pojo.Employee;

import java.util.List;

public class DataBase {

    private DataBase() {
    }

    public static DataBase getInstance() {
        return new DataBase();
    }

    public List<Employee> query(String s) {
        return null;
    }
}
