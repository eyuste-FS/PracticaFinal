package com.practicafinal.api.repositories;

import com.practicafinal.api.models.response.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    @Query(value = "select p from PR_PROYECTOS p where p.fBaja is NULL order by p.idProyecto limit ?1 offset ?2")
    List<Proyecto> getProyectos(int limit, int offset);

    @Query(value = "select p from PR_PROYECTOS p where p.fBaja is NULL")
    List<Proyecto> getAllProyectos();

}
