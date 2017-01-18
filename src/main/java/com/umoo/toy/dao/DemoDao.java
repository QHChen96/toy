package com.umoo.toy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.umoo.toy.entity.Demo;

public interface DemoDao extends JpaRepository<Demo, Integer>{
}
