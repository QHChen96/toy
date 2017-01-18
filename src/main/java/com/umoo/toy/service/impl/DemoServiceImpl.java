package com.umoo.toy.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umoo.toy.dao.DemoDao;
import com.umoo.toy.entity.Demo;
import com.umoo.toy.service.DemoService;

@Service("demoService")
public class DemoServiceImpl implements DemoService{
	@Autowired
	private DemoDao demoDao;
	
	@Transactional
	public Demo saveDemo(Demo demo) {
		Demo d = demoDao.save(demo);
		return d;
	}

	public List findDemos() {
		return (List) demoDao.findAll();
	}
	
}
