package com.atakancoban.bean;

import java.io.Serializable;
import java.util.jar.Attributes.Name;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atakancoban.service.CarService;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = -4823295172962937652L;

	@ManagedProperty("#{carService}")
	private CarService carService;

	private String message = "www.atakancoban.com";

	@PostConstruct
	public void init() {
		System.out.println("init()");
	}

	public void onClick() {
		try {

			System.out.println("Araba Listesi  : " + carService.getCarDetails());

			System.out.println("Veritabanı ile çekilen zaman   : " + carService.getSystemTime());

		} catch (Exception e) {
			System.out.println("Exception onClick() " + e.getMessage());
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}



}
