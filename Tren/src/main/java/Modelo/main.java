/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bernardomartinez
 */

public class main {
      public static void main(String[] args) {
        Locomotora cabeza=new Locomotora(1, "renfe", "ave", 'E', 150);
        VagonMercancias merc1=new VagonMercancias(2, "renfe", "MEDIO", 9000,"Automoviles");
        VagonPasajeros pas1=new VagonPasajeros(3, "renfe", null, 50);
        VagonPasajeros pas2=new VagonPasajeros(4, "renfe", null, 50);
        VagonPasajeros pas3=new VagonPasajeros(5, "renfe", null, 50);
        Vagon cola[]={merc1,pas1,pas2,pas3};
        Tren trenecito=new Tren(cabeza, cola,"Madrid",LocalTime.of(8,30),LocalTime.of(2,0),5);
        Tren trenMerca=new Tren(cabeza, cola,"Madrid",LocalTime.of(8,30),LocalTime.of(4,0),2);
        List<Tren> listaTrenes=new ArrayList<>();
        listaTrenes.add(trenecito);
        listaTrenes.add(trenMerca);

        

        
        
        
        Estacion atocha=new Estacion("Atocha","Madrid",listaTrenes);
//          System.out.println(atocha.mostrarTrenesOrdenados());
          System.out.println(atocha.mostrarRelacionTrenes("Madriddsfdsf"));

    }
}
