package com.angel.courses.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.angel.courses.domain.Level;

public interface LevelRespository {

	@Select("SELECT * FROM levels")
	List<Level> getAll();
}
