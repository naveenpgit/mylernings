package junit_demo.powermockitooo;

import junit_demo.commmon.DataBase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest(DataBase.class)
public class MyDAOTest {

    @Mock
    DataBase dataBase;

    MyDAO myDAO;

    @Before
    public void intit() {
        PowerMockito.mockStatic(DataBase.class);
        PowerMockito.when(DataBase.getInstance()).thenReturn(dataBase);
        when(dataBase.query(Matchers.anyString())).thenReturn(new ArrayList<>());
        myDAO = new MyDAO();
    }

    @Test
    public void getEmployees() {
        assertTrue(myDAO.getEmployees().isEmpty());
        verify(dataBase, times(1)).query(eq("select * from X"));
    }

}