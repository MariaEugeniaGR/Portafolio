/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.maru.Repository;

import com.portafolio.maru.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author familia
 */
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
}
