package com.esercizio.aitho;

import com.esercizio.aitho.model.Car;
import com.esercizio.aitho.model.Punto;
import com.esercizio.aitho.model.Vehicle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsercizioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsercizioApplication.class, args);

		Vehicle car = new Car();
		Vehicle punto = new Punto();

		System.out.println(car.getVehicleType());
		System.out.println(punto.getVehicleType());
	}



}
