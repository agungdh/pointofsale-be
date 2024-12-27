package com.agungdh.pointofsale;

import org.springframework.boot.SpringApplication;

public class TestPointOfSaleApplication {

    public static void main(String[] args) {
        SpringApplication.from(PointOfSaleApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
