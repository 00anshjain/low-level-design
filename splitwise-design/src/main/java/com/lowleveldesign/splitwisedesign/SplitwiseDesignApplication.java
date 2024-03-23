package com.lowleveldesign.splitwisedesign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SplitwiseDesignApplication {

    public static void main(String[] args) {
        Splitwise splitwise = new Splitwise();
        splitwise.demo();
        SpringApplication.run(SplitwiseDesignApplication.class, args);
    }

}
