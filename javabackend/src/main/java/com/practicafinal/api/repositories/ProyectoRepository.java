package com.practicafinal.api.repositories;

import com.practicafinal.api.models.response.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    @Query(value = "select p from PR_PROYECTOS where F_BAJA is NULL order by ID_PROYECTO limit 10 offset (?1 * 10)")
    List<Proyecto> getProyectos(int page);

    @Query(value = "select p from PR_PROYECTOS where F_BAJA is NULL order by ID_PROYECTO limit 10")
    List<Proyecto> getProyectos();

}
