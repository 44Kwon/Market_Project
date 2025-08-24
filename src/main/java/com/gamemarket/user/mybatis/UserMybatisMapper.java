package com.gamemarket.user.mybatis;

import com.gamemarket.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 복잡한 쿼리에 대해서는 Mybatis를 사용하여 최적화한다.
 */
@Mapper
public interface UserMybatisMapper {

}
