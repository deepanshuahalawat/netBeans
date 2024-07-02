package net.codejava.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloSpringbootApplication {

	public static void main(String[] args) {
            ConfigurableApplicationContext context = SpringApplication.run(HelloSpringbootApplication.class, args);
            Alien alien = context.getBean(Alien.class);
            alien.show();
            alien.compile();
        }

}
