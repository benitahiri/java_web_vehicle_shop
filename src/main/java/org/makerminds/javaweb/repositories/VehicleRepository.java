package org.makerminds.javaweb.repositories;


import org.makerminds.javaweb.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}