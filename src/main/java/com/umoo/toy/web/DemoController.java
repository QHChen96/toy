package com.umoo.toy.web;

import java.util.List;

import com.umoo.toy.dto.BaseResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umoo.toy.entity.Demo;
import com.umoo.toy.service.DemoService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class DemoController {
	@Autowired
	private DemoService demoService;
	@PostMapping("/demo")
	public BaseResult<Demo> saveDemo(@Valid Demo demo, BindingResult result){
		return new BaseResult<Demo>(true, demoService.saveDemo(demo));
	}
	@GetMapping("/demo/{id}")
	public Demo getDemo(@PathVariable("id") Integer id) {
		return demoService.findDemo(id);
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
	@DeleteMapping("/demo/{id}")
	public String delDemo(@PathVariable("id") Integer id){
		demoService.deleteFromCache(id);
		return "{success:true}";
	}
	@RequestMapping(produces = "text/plain;charset=utf-8")
	public String index(HttpServletRequest request) {
		return "url" + request.getRequestURL() + " can access";
	}
}
