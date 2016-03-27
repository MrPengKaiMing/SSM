package com.mingge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mingge.mapper.UserMapper;
import com.mingge.model.User;

@Controller
public class UserController {
	@Autowired
	private UserMapper userMapper;
	
	@ResponseBody
	@RequestMapping("/findAll")
	public List<User> find(){
		
		List<User> list=userMapper.find();
		return list;
	}
	
	@ResponseBody
	@RequestMapping("add")
	public String add(){
		User user=new User();
		user.setUsername("test");
		user.setPassword("test");
		userMapper.insert(user);
		System.out.println(user);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("user", user);
		return jsonObject.toJSONString();
	}
	
}
