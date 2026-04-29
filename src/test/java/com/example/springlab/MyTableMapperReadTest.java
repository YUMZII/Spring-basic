package com.example.springlab;

import mybatis.dao.MyTableMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyTableMapperReadTest {
	@Autowired
	MyTableMapper dao;
	@Test
	void read() {
		dao.list().stream().forEach(System.out::println);
	}
}
