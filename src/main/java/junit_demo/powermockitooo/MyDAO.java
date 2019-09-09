package junit_demo.powermockitooo;

import junit_demo.commmon.DataBase;
import junit_demo.commmon.pojo.Employee;

import java.util.List;

public class MyDAO {

    DataBase db;

    public MyDAO() {
        db = DataBase.getInstance();
    }

    public List<Employee> getEmployees() {
        return db.query("select * from X");
    }

}
