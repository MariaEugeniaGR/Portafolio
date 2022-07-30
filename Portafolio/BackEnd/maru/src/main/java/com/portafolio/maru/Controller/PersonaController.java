/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.maru.Controller;

import com.portafolio.maru.Entity.Persona;
import com.portafolio.maru.Repository.PersonaRepository;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author familia
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping ("/personas")
public class PersonaController {
    
    @Autowired
    PersonaRepository personaRepository;
    
    @GetMapping("{id}")
    public Persona obtenerPersonaPorId(@PathVariable Long id) {
     
       Optional<Persona> personaOpt = personaRepository.findById(id);
       
       if (!personaOpt.isPresent()) {}
       
       return personaOpt.get();
    }
    
    @GetMapping
    public List<Persona> getPersonas(){
           return personaRepository.findAll();
    }
    
    @PostMapping
    public Persona createPersona(@Valid @RequestBody Persona newPerson) {
        return personaRepository.save(newPerson);
    }
    
    @PutMapping("{id}") 
    public Persona updatePersona(@PathVariable Long id, @RequestBody Persona newPerson) {
            
       Optional<Persona> personaOpt = personaRepository.findById(id);
       if (!personaOpt.isPresent()){
       }
       Persona personaUpdated = personaOpt.get();
       if(newPerson.getImage() != null)
          personaUpdated.setImage(newPerson.getImage());
       if(newPerson.getName()!= null)
          personaUpdated.setName(newPerson.getName());
       if(newPerson.getLastname()!=null)
           personaUpdated.setLastname(newPerson.getLastname());
                   
       newPerson.setId(id);
       return personaRepository.save(personaUpdated);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity deletePerson(@PathVariable Long id) {
         Map response = new HashMap();
         Optional<Persona> personaOpt = personaRepository.findById(id);
         if(!personaOpt.isPresent()){
         response.put("message", "Persona no existe");
         return new ResponseEntity(response, HttpStatus.NOT_FOUND);
         }
         
         personaRepository.deleteById(id);
         response.put("message", "Persona borrada exitosamente");
         return new ResponseEntity(response, HttpStatus.OK);
         
    }
    
    
}
