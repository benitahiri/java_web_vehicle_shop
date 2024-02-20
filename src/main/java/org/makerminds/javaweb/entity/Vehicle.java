package org.makerminds.javaweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "vehicles")
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private Long id;

	// Manufacturer of the vehicle
	// TODO: Add field for manufacturer
	@NotBlank(message = "Manufacturer is required")
	@Column(name= "Manufacturer", nullable = false)
	private String manufacturer;

	// Model of the vehicle
	// TODO: Add field for model
	@NotBlank(message = "Model is required")
	@Column(name= "Model", nullable = false)
	private String model;

	// Horsepower of the vehicle
	// TODO: Add field for horsepower
	@Size(min = 2, max = 3 , message = "Invalid Horse Power")
	@Column(name= "Horse Power", nullable = false)
	private String horsepower;
	

	// Price of the vehicle
	// TODO: Add field for price
	@Column(name= "Price", nullable = false)
	private String Price;

	// Color of the vehicle
	// TODO: Add field for color
	@NotBlank(message = "Vehicle Color is required")
	@Column(name= "Vehicle Color", nullable = false)
	private String vehicleColor;

	// Mileage of the vehicle
	// TODO: Add field for mileage
	@Column(name= "Mileage", nullable = false)
	private String mileage;

	// Production year of the vehicle
	// TODO: Add field for production year
	@Column(name= "Production year of the vehicle", nullable = false)
	private String productionYearOfTheVehicle;

	// Transmission type of the vehicle
	// TODO: Add field for transmission
	@NotBlank(message = "Vehicle transmission is required")
	@Column(name= "Vehicle transmission", nullable = false)
	private String transmission;

	// Fuel type of the vehicle
	// TODO: Add field for fuel type
	@NotBlank(message = "Fuel Type is required")
	@Column(name= "Fuel Type", nullable = false)
	private String fuelType;
}
