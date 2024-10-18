package com.vehicle.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehicle.DAO.BikeDAO;
import com.vehicle.Entity.Bike;

@Service
public class BikeService {
	@Autowired
	BikeDAO bdao;

	public String postAllBike(@RequestBody List<Bike> bike) {

		return bdao.postAllBike(bike);
	}

	public String deleteAll() {

		return bdao.deleteAll();
	}

	public List<Bike> getAllBike() {

		return bdao.getAllBike();
	}

	public String putpatch(int a, Bike bike) {

		return bdao.putpatch(a, bike);
	}

	public String patchfiled(int a, Bike bike) {

		return bdao.patchfiled(a, bike);
	}

	////// servive and Implementataion//////

	//// ExpensiveBike/////
	public List<Bike> getAllExpensiveBike() {

		List<Bike> expensiveBike = bdao.getAllBike().stream().filter(i -> i.getPrice() > 100000)
				.collect(Collectors.toList());

		return expensiveBike;
	}

	//// ExpensiveBikeBrandsOnly
	public List<String> getAllExpensiveBikeBrands() {
		List<String> brandsonly = getAllExpensiveBike().stream().map(i -> i.getBrand()).collect(Collectors.toList());
		return brandsonly;
	}

	///// brands Only/////

	public List<String> getAllBrands() {
		List<String> brandsOnly = bdao.getAllBike().stream().map(i -> i.getBrand()).collect(Collectors.toList());

		return brandsOnly;
	}

	public List<String> blueBikeBrandandPrice() {
		List<String> bluepriceandbrand = bdao.getAllBike().stream().filter(i -> i.getColour().equals("Blue"))
				.map(i -> i.getBrand() + "=" + i.getPrice()).collect(Collectors.toList());
		return bluepriceandbrand;
	}

	//// MaxPrice
	public Bike getMaxPrice() {
		Bike max = bdao.getAllBike().stream().max(Comparator.comparingInt(o -> o.getPrice())).get();
		return max;
	}

	public int getMaxPriceonly() {

		int max = bdao.getAllBike().stream().map(i -> i.getPrice()).sorted(Comparator.reverseOrder()).distinct()
				.findFirst().get();

		return max;
	}

	public Bike getMinPrice() {
		Bike min = bdao.getAllBike().stream().min(Comparator.comparingInt(o -> o.getPrice())).get();
		return min;
	}

	public int getMinPriceOnly() {
		int min = bdao.getAllBike().stream().map(i -> i.getPrice()).sorted().distinct().findFirst().get();
		return min;
	}
	
	/////Tax Price

//	public List<Bike> taxForBike() {
//		
//		List<Bike>tax=bdao.getAllBike().stream().map(o->{
//			if(o.getPrice()>100000 && o.getPrice()<200000) {
//				return o.setPrice(o.getPrice()+o.getPrice()*10/100);
//			}
//			else if(o.getPrice()>=200000 && o.getPrice()<500000){
//				return o.setPrice(o.getPrice()+o.getPrice()*15/100);
//			}
//			else {
//				return o.setPrice(o.getPrice()+o.getPrice()*20/100);
//			}
//			return o.
//		}).collect(Collectors.toList());
//	}

}
