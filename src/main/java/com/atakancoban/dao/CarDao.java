package com.atakancoban.dao;

import java.util.List;

public interface CarDao {

	
	public List<String> getCarDetails();
	public String getSystemTime() throws Exception;
}
