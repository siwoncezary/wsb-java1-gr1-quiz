package pl.wsb.quiz.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wsb.quiz.servlet.QuizFormServlet;
import pl.wsb.quiz.servlet.SimpleServlet;

@Configuration
public class ServletConfiguration {

//    @Bean
//    public ServletRegistrationBean<SimpleServlet> registerServlet(){
//        ServletRegistrationBean<SimpleServlet> serv = new ServletRegistrationBean<SimpleServlet>();
//        serv.setServlet(new SimpleServlet());
//        serv.addUrlMappings("/servlet");
//        serv.setLoadOnStartup(1);
//        return serv;
//    }
//    @Bean
//    public ServletRegistrationBean<QuizFormServlet> registerQuizFormServlet(){
//        ServletRegistrationBean<QuizFormServlet> serv = new ServletRegistrationBean<QuizFormServlet>();
//        serv.setServlet(new QuizFormServlet());
//        serv.addUrlMappings("/fill");
//        serv.setLoadOnStartup(1);
//        return serv;
//    }

}
