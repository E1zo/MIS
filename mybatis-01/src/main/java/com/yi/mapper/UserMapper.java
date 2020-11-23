package com.yi.mapper;

import com.yi.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {

  public User queryByName(String name);

}
