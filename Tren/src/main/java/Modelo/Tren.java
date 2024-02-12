package Modelo;
import Modelo.Locomotora;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Tren {
    Locomotora locomotora;
    Vagon vagones[];
    private String destino;
    private LocalTime horaLlegada;
    private LocalTime horaSalida;
    private int numeroVia;

    public Tren(Locomotora locomotora, Vagon vagon[], String destino, LocalTime horaLlegada, LocalTime horaSalida,
            int numeroVia) {
        this.locomotora = locomotora;
        this.vagones = vagon;
        this.destino = destino;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.numeroVia = numeroVia;
    }

   

    public String toString() {
        String descripcion;
        descripcion = "\n locomotora: \n "
                + "Codigo: " + this.locomotora.getCodigo()
                + "\n Marca: " + this.locomotora.getMarca()
                + "\n Modelo: " + this.locomotora.getModelo()
                + "\n Tipo: " + this.locomotora.getTipo()
                + "\n Destino: "+this.destino
                + "\n Potencia: " + this.locomotora.getPotencia() + "CV"
                + "\n Hora de Salida: " + this.horaSalida
                + "\n Hora de llegada: " + this.horaLlegada
                + "\n Vía: " + this.numeroVia
                + "\n Vagones: \n";

        // Iterar a través de los vagones
        for (Vagon vagon : this.vagones) {
            if (vagon instanceof VagonPasajeros) {
                // Si es un VagonPasajeros
                descripcion +="Vagon de pasajeros"
                        + "\n  - Codigo: " + vagon.getCodigo()
                        + "\n    Marca: " + vagon.getMarca()
                        + "\n    Modelo: " + vagon.getModelo()
                        + "\n    Numero de Asientos: " + ((VagonPasajeros) vagon).getNumeroAsientos()
                        + "\n";
            } else if (vagon instanceof VagonMercancias) {
                // Si es un VagonMercancias
                descripcion += "Vagon de Mercancías"
                        +"  - Codigo: " + vagon.getCodigo()
                        + "\n    Marca: " + vagon.getMarca()
                        + "\n    Modelo: " + vagon.getModelo()
                        + "\n    Capacidad de Carga: " + ((VagonMercancias) vagon).getCapacidadCarga() + " toneladas"
                        + "\n";
            }
        }

        return descripcion;
    }

    public String getDestino() {
        return destino;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public int getNumeroVia() {
        return numeroVia;
    }

    public Vagon[] getVagones() {
        return vagones;
    }
     public Locomotora getLocomotora() {
        return locomotora;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setLocomotora(Locomotora locomotora) {
        this.locomotora = locomotora;
    }

    public void setNumeroVia(int numeroVia) {
        this.numeroVia = numeroVia;
    }

    public void setVagones(Vagon[] vagones) {
        this.vagones = vagones;
    }
    
    public static List<String> obtenerDestinos(List<Tren> trenes){
        List<String> nombreDestinos=new ArrayList<>();
        for(Tren elemento:trenes){
            String Destino=elemento.getDestino();
            if(!nombreDestinos.contains(Destino)){
                nombreDestinos.add(elemento.destino);
            }
        }
        return nombreDestinos;
        
        
    }
    public static List<Tren> filtrarPorIdLocomotora(String[] codigos,List<Tren> trenes){
        List<Tren> trenesFiltrados=new ArrayList<>();
        List<String> codigosList = Arrays.asList(codigos);
        for(Tren tren:trenes){

            if(codigosList.contains(String.valueOf(tren.getLocomotora().getCodigo()))){
                trenesFiltrados.add(tren);

            }
        }
        return trenesFiltrados;
    }
   

}

