package me.devksh930.tabling.app.common.config;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CurrentAccountConfig implements WebMvcConfigurer {
    private final CurrentAccountArgumentResolver argumentResolver;

    public CurrentAccountConfig(
        final CurrentAccountArgumentResolver argumentResolver
    ) {
        this.argumentResolver = argumentResolver;
    }

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(argumentResolver);
    }
}
