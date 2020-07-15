package cn.kgc.movie.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 23:31  <br/>
 * 类描述   ：
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public UserInterceptor newUserInterceptor(){
        return new UserInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(newUserInterceptor()).addPathPatterns("/","/getMovieInfo","/getSeatInfo");
    }
}
