package com.example;

import com.example.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author : yion
 * @Date : 2015. 10. 29.
 * @Description :
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private RepositoryService repositoryService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryService.saveMember();
	    repositoryService.print();
	    repositoryService.lazyEntityPrint();

	    repositoryService.deletConstraintKey();
	    repositoryService.print();
    }
}
