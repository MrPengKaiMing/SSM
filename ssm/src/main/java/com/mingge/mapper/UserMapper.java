package com.mingge.mapper;

import java.util.List;

import com.mingge.model.User;

public interface UserMapper {
	List<User> find();
	long insert(User user);
}
