package org.makerminds.javaweb.service;

import java.util.List;

import org.makerminds.javaweb.entity.Vehicle;
import org.makerminds.javaweb.repositories.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleService {
 
	private final VehicleRepository vehicleRepository;
	
	// Create or update a vehicle
	// This method is responsible for creating a new vehicle if it doesn't exist
	// in the database, or updating an existing vehicle if it already exists.
	// It takes a Vehicle object as input and returns the created or updated Vehicle object.
	public Vehicle createOrUpdateVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	// Sell a vehicle by ID
	// This method is responsible for selling a vehicle based on its ID.
	// It retrieves the vehicle with the specified ID from the repository,
	// deletes it from the database, and returns a response indicating whether the sale was successful or the vehicle was not found.
	// It returns a ResponseEntity<String> object with an appropriate message.
	public ResponseEntity<?> sellVehicle(Long id) {
		Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
		if(vehicle != null) {
			
		   vehicleRepository.deleteById(id);
		    String message = "Vehicle with ID " + id + " has been sell " ;
		    return ResponseEntity.ok().body(message);
		}
		else {
			String message = "Vehicle with ID" + id + "not found " ;
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
		
	}

	// Retrieve all vehicles
	// This method retrieves all vehicles from the repository.
	// It returns a List<Vehicle> containing all the vehicles in the database.
	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}
}
