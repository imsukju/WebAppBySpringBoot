package com.example1.springDemo1;

import org.springframework.context.ApplicationContext;

import com.example1.springDemo1.MyFeature.EnableMyFeature;
import com.example1.springDemo1.config.AppConfig;
import com.example1.springDemo1.config.DelayedConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@EnableMyFeature
public class SpringDemo1Application {

//	public static void main(String[] args) {
//		//SpringApplication.run을 가지는 클래스는 최상위 패키지에 위치해야함
//		//SpringDemo1Application 
//		SpringApplication.run(SpringDemo1Application.class, args);
//	}
	
    public static void main(String[] args) 
    {
        ApplicationContext context = SpringApplication.run(SpringDemo1Application.class, args);

        // 기본 설정 클래스에서 로드된 빈 출력
        // 기본 설정 클래스에서 로드된 빈 출력
        if (context.containsBean("initialBean")) {
            System.out.println(context.getBean("initialBean"));
        } else {
            System.out.println("Initial bean was not loaded.");
        }

        // 지연 로딩된 빈 출력
        if (context.containsBean("helloDelayed")) {
            System.out.println(context.getBean("helloDelayed"));
        } else {
            System.out.println("Deferred bean was not loaded.");
        }
    }

}
