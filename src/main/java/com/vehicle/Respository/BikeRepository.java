package com.vehicle.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.Entity.Bike;


public interface BikeRepository extends JpaRepository<Bike, Integer> {

}
