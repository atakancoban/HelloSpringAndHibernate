package com.atakancoban.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atakancoban.dao.CarDao;

@Service("carService")
@Transactional(readOnly=true)
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarDao cardao;

	
	@Override
	public List<String> getCarDetails() {
	if(cardao!=null)
		return cardao.getCarDetails();
	else{
		System.out.println("carDaou service i�inde null");
		return null;}
	}

/*	@Transactional(rollbackFor = Exception.class, readOnly = false)
	public addname() {
	}*/
	
	public CarDao getCardao() {
		return cardao;
	}

	public void setCardao(CarDao cardao) {
		this.cardao = cardao;
	}

	@Override
	public String getSystemTime() throws Exception {
		return cardao.getSystemTime();
	}

	
	
}
