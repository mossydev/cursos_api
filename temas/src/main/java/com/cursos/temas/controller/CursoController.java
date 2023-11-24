/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursos.temas.controller;

import com.cursos.temas.dto.CursoDTO;
import com.cursos.temas.model.Curso;
import com.cursos.temas.service.ICursoService;
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
public class CursoController {
    @Autowired
    private ICursoService cursoServ;
   
    //Con DTO devuelve un sólo objeto con toda la informacion que estan solicitando.
    @GetMapping("/cursos/{id}")  
    public CursoDTO devolverTemasCurso(@PathVariable Long id){
        Curso curse = cursoServ.findCurso(id);//me retorna un objeto de tipo curso
        CursoDTO cursedto= new CursoDTO();
        cursedto.setListaTemas(curse.getListaTemas());
        
        return cursedto; //se devuelve un objeto CursoDTO en postman con toda la lista de temas del curso.
    }
    
    @GetMapping("/cursos/java")   
    public List<Curso> cursosJava(){
        return cursoServ.getCursosJava();
    }
   //---------------------------------------------------------------------------
    
    //Endpoints for CRUD
   
    //Traer
    @GetMapping("/cursos/traer")
    public List<Curso>getCursos(){
        return cursoServ.getCursos();
    }
    
    //Crear
    @PostMapping("/cursos/crear")
    public String createCurso(@RequestBody Curso curse){
        cursoServ.saveCurso(curse);
        
        return "El curso fue creado correctamente";
    }
    
    //Delete
    @DeleteMapping("/cursos/borrar/{id}")
    public String deleteCurso(@PathVariable Long id){
       cursoServ.deleteCurso(id);
       //devuelve un String avisando si eliminó correctamente
       return "El curso fue eliminado correctamente";
    }
    
    //Modificar
    @PutMapping("cursos/editar/{id_original}")
    public Curso editCurso(@PathVariable Long id_original, 
            @RequestParam(required = false, name= "id")Long idNueva,
            @RequestParam(required = false, name= "nombre")String nuevoNombre,
            @RequestParam(required = false, name="apellido")String nuevaModalidad,
            @RequestParam(required = false, name="edad")int nuevaFecha_Final){
    
    cursoServ.editCurso(id_original, idNueva, nuevoNombre, nuevaModalidad, nuevaFecha_Final);
    
    Curso curse= cursoServ.findCurso(idNueva);
    
    return curse;
    }
    
    @PutMapping("cursos/editar")
    public Curso editCurso(@RequestBody Curso curse){
       cursoServ.editCurso(curse);
       
       return cursoServ.findCurso(curse.getId_curso());
    }
}
