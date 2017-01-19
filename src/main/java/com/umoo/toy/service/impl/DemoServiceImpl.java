package com.umoo.toy.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.umoo.toy.dao.DemoDao;
import com.umoo.toy.entity.Demo;
import com.umoo.toy.service.DemoService;

@Service("demoService")
public class DemoServiceImpl implements DemoService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
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
	@CacheEvict(value="demo")
	public void deleteFromCache(Integer id) {
		logger.info("从缓存中删除>>>");
		demoDao.delete(id);
	}
	
	@Cacheable(value = "demo")
	public Demo findDemo(Integer id){
		return demoDao.findOne(id);
	}
}
