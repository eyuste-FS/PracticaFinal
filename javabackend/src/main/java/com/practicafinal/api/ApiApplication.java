package com.practicafinal.api;

import com.practicafinal.api.embeddables.EmpleadosProyectoId;
import com.practicafinal.api.models.response.Empleado;
import com.practicafinal.api.models.response.EmpleadosProyecto;
import com.practicafinal.api.models.response.Proyecto;
import com.practicafinal.api.repositories.EmpleadoRepository;
import com.practicafinal.api.repositories.EmpleadosProyectoRepository;
import com.practicafinal.api.repositories.ProyectoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
