package com.funnycode.hello;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class App {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(App.class, args);
        System.out.println(context.getBean(Girl.class));

        context.getAutowireCapableBeanFactory().destroyBean(Girl.class);

        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) ((ConfigurableApplicationContext) context).getBeanFactory();
        registry.removeBeanDefinition("girl");

        System.out.println(context.getBean(Girl.class));


//        IOutfit outfit = context.getBean(TShirt.class);
////		System.out.println(outfit);
////		System.out.println("--------------------------------------");
//        Girl girl = context.getBean(Girl.class);
//		girl.setName("Ngọc Trinh");
//		girl.showOutfit();
//		System.out.println("Outfit của girl: "+girl.getOutfit());

        // Xóa bean khỏi ApplicationContext
//        context.getAutowireCapableBeanFactory().destroyBean(Girl.class);
//        System.out.println(context.getBean(Girl.class));
//
//		 Girl girl2 = context.getBean(Girl.class);
//		System.out.println(girl2);

//		context.getBean(Girl.class).showOutfit();
//
//		String connection = context.getBean(String.class);
//		System.out.println(connection);

    }

}
