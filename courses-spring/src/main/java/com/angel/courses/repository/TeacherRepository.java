package com.angel.courses.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.angel.courses.domain.Teacher;

public interface TeacherRepository {

	@Select("SELECT * FROM teachers")
	List<Teacher> getAll();
}
