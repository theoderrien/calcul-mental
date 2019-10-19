package model;

import bo.User;

import javax.servlet.http.HttpServletRequest;

public class SignupModel {

    private static final String FORM_FIELD_LOGIN = "form-create-login";
    private static final String FORM_FIELD_PWD = "form-create-pwd";

    private String login;
    private String pwd;
    private String createResult;

    public SignupModel() {}

    public void createUser( HttpServletRequest request ) {

        login = request.getParameter( FORM_FIELD_LOGIN );
        pwd = request.getParameter( FORM_FIELD_PWD );
        User user = null;
    }

}
