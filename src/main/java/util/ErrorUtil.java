package util;

import com.tavant.finexp.mismo.vo.Error;
import com.tavant.finexp.mismo.vo.Errors;
import com.tavant.finexp.mismo.vo.Service;
import util.json.JSONUtils;

import java.util.ArrayList;
import java.util.List;

public class ErrorUtil {
    public static void main(String[] args) {
        String errorLog = JSONUtils.fromFile("E:\\naveen_git\\mylernings\\resources\\Error_Lock.json");

        Service error = JSONUtils.toObject(errorLog, Service.class);
        System.out.println(error);

        Errors errors = new Errors();
        errors.setError(getError());
        JSONUtils.toJson(errors);
    }

    private static List<Error> getError() {
        List<Error> errors = new ArrayList<>();
        Error error = new Error();
        error.setLabel("blahh_1");
        errors.add(error);

        error = new Error();
        error.setLabel("blahh_2");
        errors.add(error);

        return errors;
    }
}
