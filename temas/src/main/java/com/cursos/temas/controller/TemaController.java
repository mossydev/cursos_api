/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursos.temas.controller;

import com.cursos.temas.model.Curso;
import com.cursos.temas.model.Tema;
import com.cursos.temas.service.ITemaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author moss_
 */
@RestController
public class TemaController {
    @Autowired
    private ITemaService temaServ;
    
    //Endpoints for CRUD
   
    //Traer
    @GetMapping("/temas/traer")
    public List<Tema> getTemas(){
        return temaServ.getTemas();
    }
    
    //Crear
    @PostMapping("/temas/crear")
    public String createTema(@RequestBody Tema tem){       
        temaServ.saveTema(tem);
        
        return "El tema fue creado correctamente";
    }
    
    //Delete
    @DeleteMapping("/temas/borrar/{id}")
    public String deleteTema(@PathVariable Long id){
       temaServ.deleteTema(id);
       //devuelve un String avisando si eliminó correctamente
       return "El tema fue eliminado correctamente";
    }
    
    //Modificar
    @PutMapping("temas/editar/{id_original}")
    public Tema editTema(@PathVariable Long id_original, 
            @RequestParam(required = false, name= "id")Long idNueva,
            @RequestParam(required = false, name= "nombre")String nuevoNombre,
            @RequestParam(required = false, name="apellido")String nuevaDescripcion){
    
    temaServ.editTema(id_original, idNueva, nuevoNombre, nuevaDescripcion);
    
    Tema tem= temaServ.findTema(idNueva);
    
    return tem;
    }
    
    @PutMapping("temas/editar")
    public Tema editTema(@RequestBody Tema tem){
       temaServ.editTema(tem);
       
       return temaServ.findTema(tem.getId_tema());
    }
}

