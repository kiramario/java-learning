package org.example.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {
    void add(String qaStr) {
        System.out.println("String may not be good, " + qaStr);
    }
}
