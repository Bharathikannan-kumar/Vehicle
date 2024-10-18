package com.vehicle.Respository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vehicle.Entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

	////////// Query Name matching
	@Query(value = "select * from car_table where name like ?", nativeQuery = true)
	public List<Car> findByBrand(String brand);

	/////// Query price Condition
	@Query(value = "select *from car_table where price > ? and price<?", nativeQuery = true)
	public List<Car> findBy2Lto3L(int pricestart, int priceEnd);

	////// Query Max price Object
	@Query(value = "select *from car_table order by price desc limit 1", nativeQuery = true)
	public List<Car> findMaxPriceCar();

	//////// Query group by name
	@Query(value = "select name,count(name) from car_table group by name", nativeQuery = true)
	public List<Object> getColourAndCount();

	// Query Starts With
	@Query(value = "select *from car_table where name like 'a%' ", nativeQuery = true)
	public List<Car> getStartsWith(String a);

	///// ====================JQuery===================//////

	/// JQueryMinimum
	@Query(value = "select x from Car x order by x.price limit 1")
	public List<Car> getMinPrice();

	//// JQuery Maximum
	@Query(value = "select k from Car k order by price desc limit 1")
	public List<Car> getMaxPrice();

//	//// JQuery 2Max
	@Query(value = "select max(c.price) from Car c where c.price <(select max(c1.price ) from Car c1)")
	public Integer get2Max();  //

	/// JQuery only one brand
	@Query(value = "select c from Car c where name like:b")
	public List<Car> getOnlydesireBrand(@Param("b") String b);

//	
//	///JQuery Ends With 
	@Query(value="select c from Car c where c.name like %:a ")
	public List<Car> getEndsWith(@Param("a") String a);
	
	

}
