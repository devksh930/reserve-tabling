package me.devksh930.tabling.app.common.config;

import me.devksh930.tabling.app.common.config.annotation.CurrentAccount;
import me.devksh930.tabling.app.common.domain.AccountId;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class CurrentAccountArgumentResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentAccount.class);
    }

    @Override
    public Object resolveArgument(
        final MethodParameter parameter,
        final ModelAndViewContainer mavContainer,
        final NativeWebRequest webRequest,
        final WebDataBinderFactory binderFactory
    ) {

        final UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
            .getAuthentication().getPrincipal();

        return AccountId.of(principal.getUsername());
    }

}