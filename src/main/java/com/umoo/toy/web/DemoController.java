package com.umoo.toy.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umoo.toy.entity.Demo;
import com.umoo.toy.service.DemoService;

@RestController
public class DemoController {
	@Autowired
	private DemoService demoService;
	@PostMapping("/demo")
	public Demo saveDemo(Demo demo){
		return demoService.saveDemo(demo);
	}
	@PutMapping("/demo")
	public String putDemos(){
		Demo demo = new Demo();
		demo.setDemoName("C1");
		demoService.saveDemo(demo);
		int i = 10/0;
		Demo demo1 = new Demo();
		demo1.setDemoName("Java");
		demoService.saveDemo(demo1);
		return "ok";
	}
	@PostMapping("/demos")
	public List<Demo> findDemos(){
		return demoService.findDemos();
	}
}
