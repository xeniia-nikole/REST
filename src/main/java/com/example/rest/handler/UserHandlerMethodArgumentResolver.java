package com.example.rest.handler;

import com.example.rest.exceptions.InvalidCredentials;
import com.example.rest.model.User;
import org.springframework.core.MethodParameter;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.validation.Valid;

public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private static final int ERROR_POSITION = 1;
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(UserResolver.class);
    }

    @Override
    public Object resolveArgument( MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String login = webRequest.getParameter("user");
        String password = webRequest.getParameter("password");
        String binderError;
        WebDataBinder binder;
        User user = new User().setLogin(login).setPassword(password);
        if(parameter.hasParameterAnnotation(Valid.class)) {
            binder = binderFactory.createBinder(webRequest, user, DataBinder.DEFAULT_OBJECT_NAME);
            binder.validate();
            binderError = binder.getBindingResult().toString();
            if(findBinderError(binderError)) {
                String messageError = "Incorrect field length!";
                throw new InvalidCredentials(messageError);
            }
        }
        return user;
    }

    private boolean findBinderError(String binderErrorMsg) {
        String[] binderStringComponents = binderErrorMsg.split(" ");
        return Integer.parseInt(binderStringComponents[ERROR_POSITION]) != 0;
    }
}
