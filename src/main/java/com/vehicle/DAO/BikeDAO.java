package com.vehicle.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehicle.Entity.Bike;
import com.vehicle.Respository.BikeRepository;

@Repository
public class BikeDAO {
	@Autowired

	BikeRepository brepo;

	public String postAllBike(@RequestBody List<Bike> bike) {

		brepo.saveAll(bike);

		return "All bike added sucessfully";
	}

	public String deleteAll() {
		brepo.deleteAll();
		return "Deleted All Details";
	}

	public List<Bike> getAllBike() {
		return brepo.findAll();

	}

	public String putpatch(int a, Bike bike) {
		brepo.save(bike);

		return "Changes Done";
	}

	public String patchfiled(int a, Bike bi) {

		Bike bike = brepo.findById(a).get();
		/// warranty///
		bike.setWarranty(bi.getWarranty());
		/// colour////
		bike.setColour(bi.getColour());
		brepo.save(bike);

		return "Filed changes Done";
	}

}
