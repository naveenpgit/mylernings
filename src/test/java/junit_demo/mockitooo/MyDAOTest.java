package junit_demo.mockitooo;

import junit_demo.commmon.DataBase;
import junit_demo.commmon.pojo.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MyDAOTest {

    @Mock
    DataBase dataBase;

    @Spy
    MyDAO myDAO = new MyDAO();

    @Before
    public void intit() {
        when(dataBase.query(Matchers.anyString())).thenReturn(getTestEmployeeData());
        doReturn(dataBase).when(myDAO).getDb();
    }

    private List<Employee> getTestEmployeeData() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        employees.add(new Employee());
        return employees;
    }

    @Test
    public void getEmployees() {
        assertFalse(myDAO.getEmployees().isEmpty());
        verify(dataBase, times(1)).query(eq("select * from X"));
    }

}