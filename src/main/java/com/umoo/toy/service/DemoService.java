package com.umoo.toy.service;

import java.util.List;

import javax.transaction.Transactional;

import com.umoo.toy.entity.Demo;

public interface DemoService {
	Demo saveDemo(Demo demo);
	List<Demo> findDemos();
}
