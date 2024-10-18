package com.vehicle.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.Entity.Bike;
import com.vehicle.Entity.Car;
import com.vehicle.Service.BikeService;

@RestController
@RequestMapping(value = "/Bike")
public class BikeController {

	@Autowired
	BikeService bs;

	@PostMapping(value = "/PostAllBike")
	public String postAllBike(@RequestBody List<Bike> bike) {
		return bs.postAllBike(bike);
	}
	
	@DeleteMapping(value="/DeleteAll")
	public String deleteAll() {
		return bs.deleteAll();
	}
	
	@GetMapping(value="/getAllBike")
	public List<Bike> getAllBike(){
		return bs.getAllBike();
	}
	
	@PutMapping(value="/patchWholework/{a}")
	public String putpatch(@PathVariable int a,@RequestBody Bike bike ) {
		return bs.putpatch(a,bike);
	}
	
	@PatchMapping(value="/patchsingleFiled/{a}")
	public String patchfiled(@PathVariable int a,@RequestBody Bike bike) {
		return bs.patchfiled(a,bike);
	}
	
	
	/////services and implementation/////////////
	
	@GetMapping(value="/GetExpensiveBikes")
	public List<Bike> getAllExpensiveBike(){
		return bs.getAllExpensiveBike();
	}
	
	@GetMapping(value="/GetExpensiveBikeBrands")
	public List<String>getAllExpensiveBikeBrands(){
		return bs.getAllExpensiveBikeBrands();
	}
	
	@GetMapping(value="/BrandsOnly")
	public List<String>getAllBrands(){
		return bs.getAllBrands();
	}
	
	@GetMapping(value="/BlueBikeBrandandPrice")
	public List<String> getblueBikeBrandandPrice(){
		return bs.blueBikeBrandandPrice();
	}
	
	/////Max/////
	
	@GetMapping(value="/MaxPriceFullObject")
	public Bike getMaxPrice() {
		return bs.getMaxPrice();
	}
	
	@GetMapping(value="/MaxPriceOnly")
	public int getMaxPriceonly() {
		return bs.getMaxPriceonly();
	}
	/////Minimum/////////////////
	@GetMapping(value="/MinPriceObject")
	public Bike getMinPrice() {
		return bs.getMinPrice();
	}
	
	@GetMapping(value="/MinpriceOnly")
	public int getMinPriceOnly() {
		return bs.getMinPriceOnly();
	}
	
//	@PutMapping(value="/TaxForBike")
//	public List<Bike> taxForBike(){
//		return bs.taxForBike();
//	}
	
	

}
