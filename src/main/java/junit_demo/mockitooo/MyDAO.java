package junit_demo.mockitooo;

import junit_demo.commmon.DataBase;
import junit_demo.commmon.pojo.Employee;

import java.util.List;

public class MyDAO {

    DataBase db;

    public MyDAO() {
        db = DataBase.getInstance();
    }

    public List<Employee> getEmployees() {
        return getDb().query("select * from X");
    }

    public DataBase getDb() {
        return db;
    }
}
