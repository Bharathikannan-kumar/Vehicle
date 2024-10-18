package com.vehicle.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.Entity.Car;
import com.vehicle.Service.CarService;

@RestController
@RequestMapping(value = "/Car")
public class CarController {

	@Autowired
	CarService cs;

	@PostMapping(value = "/postAllCar")
	public String postAllCar(@RequestBody List<Car> car) {
		return cs.postAllCar(car);
	}

	@GetMapping(value = "/getAllCar")
	public List<Car> getAllCar() {
		return cs.getAllCar();
	}

	///// GetBrand
	@GetMapping(value = "/GetByBrand/{brand}")
	public List<Car> findByBrand(@PathVariable String brand) {
		return cs.findByBrand(brand);
	}

	//// GetPrice query
	@GetMapping(value = "/GetPrice/{pricestart}/{priceEnd}")
	public List<Car> findBy2Lto3L(@PathVariable int pricestart, @PathVariable int priceEnd) {
		return cs.findBy2Lto3L(pricestart, priceEnd);
	}

	/// MaxPrice query
	@GetMapping(value = "/GetMaxPrice")
	public List<Car> findMaxPriceCar() {
		return cs.findMaxPriceCar();
	}

	//// colour and count Grouping by query
	@GetMapping(value = "/GetColourAndCount")
	public List<Object> getColourAndCount() {
		return cs.getColourAndCount();
	}

	/// Query method Starts With
	@GetMapping(value = "/GetNameStartsWith/{a}")
	public List<Car> getStartsWith(@PathVariable String a) {
		return cs.getStartsWith(a);
	}

	//// id by brand//////
	@GetMapping(value = "/GetBrand/{a}")
	public String getBrandById(@PathVariable int a) {
		return cs.getBrandById(a);
	}

	////////////// ===========================JQuery///////////////

	//// JQuery method Minimum
	@GetMapping(value = "/GetMin")
	public List<Car> getMinPrice() {
		return cs.getMinPrice();
	}

	/// JQuery method Maximum
	@GetMapping(value = "/GetMaxPriceCar")
	public List<Car> getMaxPrice() {
		return cs.getMaxPrice();
	}

//	/// JQuery method Find Second Max
	@GetMapping(value = "/secondMaxPriceCar")
	public Integer get2Max() {
		return cs.get2Max();
	}

	//// Jquery method only one brand
	@GetMapping(value = "/GetDesireBrand/{brand}")
	public List<Car> getOnlydesireBrand(@PathVariable String brand) {
		return cs.getOnlydesireBrand(brand);
	}
//	
//	////JQuery method Ends With
	@GetMapping(value="/GetEndWith/{a}")
	public List<Car>getEndsWith(@PathVariable String a){
	return cs.getEndsWith(a);
}

}
