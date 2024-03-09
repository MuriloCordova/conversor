package com.senai.conversor.controllers;

import com.senai.conversor.dtos.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conversor")
public class ConversorController {
    
    //-- POST /conversor/temperatura 
    @PostMapping("/temperatura")
    public ResponseEntity<ResultadoConversorDTO> converterTemperatura(@RequestBody ConversorDTO dados){        
        // Formula fahrenheit = (celsius * 9/5) + 32
        
        float fahrenheit = 0f;
        float celsius = 0f;
        ResultadoConversorDTO resultado = new ResultadoConversorDTO();  
        
        //-- "C" - Célsius | "F" - Fahrenheit 
        if(dados.getUnidadeOrigem().equals("C") && dados.getUnidadeDestino().equals("F") ){
            //--Converter C -> F
            
            celsius = dados.getValor();            
            fahrenheit = ( celsius * 9/5) + 32; 
            
            resultado.setUnidadeDestino(dados.getUnidadeDestino());
            resultado.setValor(fahrenheit);
            
        } else {
            if(dados.getUnidadeOrigem().equals("F") && dados.getUnidadeDestino().equals("C") ){
                //--Converter F -> C 
                fahrenheit = dados.getValor(); 
                celsius = (fahrenheit - 32) * 5 / 9;
                
                resultado.setUnidadeDestino(dados.getUnidadeDestino());
                resultado.setValor(celsius);
            
            } else {
                if(dados.getUnidadeOrigem().equals(dados.getUnidadeDestino())){
                    //--Unidades igual não é necessário converter
                    resultado.setUnidadeDestino(dados.getUnidadeDestino());
                    resultado.setValor(dados.getValor());                                        
                    
                }else{                    
                    resultado.setUnidadeDestino(dados.getUnidadeOrigem());
                    resultado.setValor(dados.getValor());  
                    
                }
            }  
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultado);
    }
    
    //-- POST /conversor/comprimento 
    @PostMapping("/comprimento")
    public ResponseEntity<ResultadoConversorDTO> converterComprimento(@RequestBody ConversorDTO dados){
        ResultadoConversorDTO resultado = new ResultadoConversorDTO();        
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultado);
    }
    
    //-- POST /conversor/massa 
    @PostMapping("/massa")
    public ResponseEntity<ResultadoConversorDTO> converterMassa(@RequestBody ConversorDTO dados){
        ResultadoConversorDTO resultado = new ResultadoConversorDTO();        
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultado);
    }     
    
    //-- POST /conversor/volume 
    @PostMapping("/volume")
    public ResponseEntity<ResultadoConversorDTO> converterVolume(@RequestBody ConversorDTO dados){
        ResultadoConversorDTO resultado = new ResultadoConversorDTO();        
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultado);
    }  
    
}
