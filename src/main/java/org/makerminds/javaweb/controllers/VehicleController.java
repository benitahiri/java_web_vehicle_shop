package org.makerminds.javaweb.controllers;

import java.util.Map;
import java.util.HashMap;


import org.makerminds.javaweb.entity.Vehicle;
import org.makerminds.javaweb.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/vehicles")
@CrossOrigin
@RequiredArgsConstructor
public class VehicleController {
	private final VehicleService vehicleService;
    // This method should retrieve all vehicles and return them as a response. 
	// Implement the logic to fetch all vehicles from the VehicleService and return them.
	@GetMapping(path = "/all")
	public Iterable<Vehicle> getVehicles() {
		return vehicleService.getAllVehicles();
	}
	// createVehicle: This method should create a new vehicle based on the provided request body. 
	// Validate the Vehicle object using the BindingResult. 
	// If there are validation errors, construct a map of field errors and return a ResponseEntity with a BadRequest status and the error map. 
	// If there are no errors, call the createOrUpdateVehicle method of the VehicleService to create the vehicle and return a ResponseEntity with the created vehicle.
	@PostMapping()
	public ResponseEntity<?> createVehicle(@Valid @RequestBody Vehicle vehicle, BindingResult bindingResult) {
		  if(bindingResult.hasErrors()) {
			  Map<String, String>  errors = new HashMap<>();
	        	 for(FieldError fieldError : bindingResult.getFieldErrors()) {
	        	 errors.put(fieldError.getField(),  fieldError.getDefaultMessage());
	        	 }
	        	 return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
	         }		
			return ResponseEntity.ok(vehicleService.createOrUpdateVehicle(vehicle));
			
		
		
		
	}
    // sellVehicle: This method should sell a vehicle based on the provided ID. 
	// Call the sellVehicle method of the VehicleService with the ID and return the response received from the service.
	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<?> sellVehicle(@PathVariable Long id) {
		return vehicleService.sellVehicle(id);
	}

}