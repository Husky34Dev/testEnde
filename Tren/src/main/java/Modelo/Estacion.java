/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 *
 * @author bernardomartinez
 */
public class Estacion {
    private String nombre;
    private String ciudad;
    private List<Tren> trenes;
    
    public Estacion(String nombre, String ciudad, List<Tren> trenes){
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.trenes=trenes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public List<Tren> getTrenes() {
        return trenes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTrenes(List<Tren> trenes) {
        this.trenes = trenes;
    }
    
    public List<Tren> listaOrdenada(List<Tren> trenes) {
    Collections.sort(trenes, Comparator.comparing(Tren::getHoraSalida));
    return trenes;
}
    
    public String mostrarTrenesOrdenados(){
        this.trenes=listaOrdenada(trenes);
        return trenes.toString();
    }
    
    public String mostrarRelacionTrenes(String ciudad){
        List<Tren> trenesFiltrados=filtrarTrenes(ciudad);
        if(trenesFiltrados.isEmpty()){
            return "No hay trenes con ese destino";
        }else
        return trenesFiltrados.toString();
    }
    public List<Tren> filtrarTrenes(String ciudad){
        
           List<Tren> trenesFiltrados=new ArrayList();

        for(Tren elemento:trenes){
            if(elemento.getDestino()==ciudad){
                trenesFiltrados.add(elemento);
            }
        }
        return trenesFiltrados;
    }
    

    

    @Override
    public String toString() {
        return "Estacion{" + "nombre=" + nombre + ", ciudad=" + ciudad + ", trenes=" + trenes + '}';
    }
    
}
