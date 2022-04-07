package com.yjh.config;

import com.yjh.interceptor.ImgInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String os = System.getProperty("os.name");

        if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
//            registry.addResourceHandler("/smallapple/**")
//                    // /apple/**表示在磁盘apple目录下的所有资源会被解析为以下的路径
//                    .addResourceLocations("file:G:/itemsource/smallapple/") //媒体资源
//                    .addResourceLocations("classpath:/META-INF/resources/");  //swagger2页面
        } else {  //linux 和mac
            registry.addResourceHandler("/garageKit_img/**")
                    .addResourceLocations("file:/Users/yangjiahao/img/garageKit_img/")  //媒体资源
                    .addResourceLocations("classpath:/img/garageKit_img/");   //测试时的媒体资源

            registry.addResourceHandler("/profilePhoto_img/**")
                    .addResourceLocations("file:/Users/yangjiahao/img/profilePhoto_img/")  //媒体资源
                    .addResourceLocations("classpath:/img/profilePhoto_img/");   //测试时的媒体资源
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ImgInterceptor imgInterceptor = new ImgInterceptor();
//        对静态资源url进行解码
        registry.addInterceptor(imgInterceptor).addPathPatterns("/profilePhoto_img/**","/garageKit_img/**");
    }
}
