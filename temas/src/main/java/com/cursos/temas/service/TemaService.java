/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursos.temas.service;

import com.cursos.temas.model.Curso;
import com.cursos.temas.model.Tema;
import com.cursos.temas.repository.ITemaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author moss_
 */
@Service
public class TemaService implements ITemaService{
    @Autowired
    private ITemaRepository repoTema;
    
    
    //traer
    @Override
    public List<Tema> getTemas() {
        List<Tema> listaTemas = repoTema.findAll(); //accede a la BD
        return listaTemas;
    }

    //crear
    @Override
    public void saveTema(Tema tem) {
        repoTema.save(tem);
    }

    //borrar
    @Override
    public void deleteTema(Long id) {
        repoTema.deleteById(id);
    }

    //traer un tema
    @Override
    public Tema findTema(Long id) {
       Tema tem = repoTema.findById(id).orElse(null);
       
       return tem;
    }
    
    @Override
    public void editTema(Long id_original, Long idNueva, String nuevoNombre, String nuevaDescripcion) {
        Tema tem = this.findTema(id_original);
        
        //proceso de modificación a nivel lógico
        tem.setId_tema(idNueva);
        tem.setNombre(nuevoNombre);
        tem.setDescripcion(nuevaDescripcion);       
       
        this.saveTema(tem);
    }
    
    @Override
    public void editTema(Tema tem) {
        this.saveTema(tem);
    }  
    
}
