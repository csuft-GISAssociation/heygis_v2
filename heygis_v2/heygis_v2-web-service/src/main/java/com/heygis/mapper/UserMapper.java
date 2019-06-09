package com.heygis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.heygis.pojo.User;
@Mapper
public interface UserMapper {
	
	public List<User> queryUserList();

}
