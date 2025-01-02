package ir.maktab.filtertraning.servlet.filter;


import ir.maktab.filtertraning.model.dto.CreateUserRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class CreateUserFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response =(HttpServletResponse) servletResponse;

        String nationalCode =request.getParameter("nationalCode");
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        CreateUserRequest createUserRequest= CreateUserRequest.builder().nationalCode(nationalCode).username(username).password(password).build();
        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CreateUserRequest>> validate = validator.validate(createUserRequest);



        if(validate.isEmpty()){
            request.setAttribute("createUserRequest",createUserRequest);
            filterChain.doFilter(request,response);
        }else {
            PrintWriter writer=response.getWriter();
            for (ConstraintViolation<CreateUserRequest> error : validate){
                writer.write(error.getMessage());
                writer.write("\n");
            }
            writer.close();
        }


    }
}
