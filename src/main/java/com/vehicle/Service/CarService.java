package com.vehicle.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehicle.DAO.CarDAO;
import com.vehicle.Entity.Car;
import com.vehicle.Respository.CarRepository;

@Service
public class CarService {
	@Autowired
	CarDAO cdao;

	public String postAllCar(@RequestBody List<Car> car) {

		return cdao.postAllCar(car);
	}

	public List<Car> getAllCar() {

		return cdao.getAllCar();
	}

	public List<Car> findByBrand(String brand) {
		return cdao.findByBrand(brand);
	}

	//// price Condition Query
	public List<Car> findBy2Lto3L(int pricestart, int priceEnd) {

		return cdao.findBy2Lto3L(pricestart, priceEnd);
	}

	//// MaxPrice Query////

	public List<Car> findMaxPriceCar() {

		return cdao.findMaxPriceCar();
	}

	//// Grouping by Colour////
	public List<Object> getColourAndCount() {

		return cdao.getColourAndCount();
	}

	/// Starts With

	public List<Car> getStartsWith(String a) {

		return cdao.getStartsWith(a);
	}

	//// brand by id///

	public String getBrandById(int a) {

		return cdao.getBrandById(a);
	}

	/////// ==============JQuery====================/////

	//// Min//
	public List<Car> getMinPrice() {
		return cdao.getMinPrice();
	}

	/// max
	public List<Car> getMaxPrice() {

		return cdao.getMaxPrice();
	}

	// second Max
	public Integer get2Max() {
		return cdao.get2Max();
	}
	//// Desire Brand///
	public List<Car> getOnlydesireBrand(String brand) {

		return cdao.getOnlydesireBrand(brand);
	}

	/// Ends With
//
	public List<Car> getEndsWith(String a) {
		
		return cdao.getEndsWith(a);
	}

}
