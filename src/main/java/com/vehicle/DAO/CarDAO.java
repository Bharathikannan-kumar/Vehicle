package com.vehicle.DAO;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehicle.Entity.Car;
import com.vehicle.Respository.CarRepository;

@Repository
public class CarDAO {

	@Autowired
	CarRepository crepo;

	public String postAllCar(@RequestBody List<Car> car) {

		crepo.saveAll(car);
		return "Added Sucessfully";
	}

	public List<Car> getAllCar() {

		return crepo.findAll();
	}

	public List<Car> findByBrand(String brand) {
		return crepo.findByBrand(brand);
	}

	public List<Car> findBy2Lto3L(int pricestart, int priceEnd) {

		return crepo.findBy2Lto3L(pricestart, priceEnd);
	}

	public List<Car> findMaxPriceCar() {
		return crepo.findMaxPriceCar();
	}

	public List<Object> getColourAndCount() {

		return crepo.getColourAndCount();
	}

	public List<Car> getStartsWith(String a) {

		return crepo.getStartsWith(a);
	}

	public String getBrandById(int a) {

		String brand = crepo.findById(a).get().getName();
		return brand;

	}

	//////// ==================JQuery==================///////////////

	public List<Car> getMinPrice() {

		return crepo.getMinPrice();
	}

	public List<Car> getMaxPrice() {

		return crepo.getMaxPrice();
	}

	public Integer get2Max() {
		return crepo.get2Max();
	}

	public List<Car> getOnlydesireBrand(String brand) {

		return crepo.getOnlydesireBrand(brand);
	}

	public List<Car> getEndsWith(String a) {
		return crepo.getEndsWith(a);
	}

}
