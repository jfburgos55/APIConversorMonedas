/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package lad.com.alura.conversormoneda.apiconversormonedas.modelos;

import java.util.Map;
/**
 *
 * @author jfburgos55
 */
public class Monedas {
    private String base;
    // Para manejar dinámicamente pares como "COP"
    private Map<String, Double> result; 

    // Getters y Setters
    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getResult() {
        return result;
    }

    public void setResult(Map<String, Double> result) {
        this.result = result;
    }
}
