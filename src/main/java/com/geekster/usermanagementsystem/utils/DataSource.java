package com.geekster.usermanagementsystem.utils;

import com.geekster.usermanagementsystem.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class DataSource {
    @Bean("listProvider")
    public List<User> supplyList() {
        return new LinkedList<>();
    }
}
