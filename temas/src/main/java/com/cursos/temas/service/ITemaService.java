/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cursos.temas.service;

import com.cursos.temas.model.Tema;
import java.util.List;

/**
 *
 * @author moss_
 */
public interface ITemaService {
     public List<Tema>getTemas();
    //metodo para dar de alta una persona
    public void saveTema(Tema tem);
    //metodo para borrar una persona
    public void deleteTema(Long id);
    //metodo para encontrar una persona
    public Tema findTema(Long id);
    
    
    public void editTema(Long id_original,Long idNueva,String nuevoNombre,String nuevaDescripcion);
    public void editTema(Tema tem);
}
