package cl.nicolas.pokemonbasico.model;

import javafx.beans.property.*;

public class Pokemon {

    private final IntegerProperty id;
    private final StringProperty nombre;
    private final StringProperty tipo;

    public Pokemon(int id , String nombre ,String tipo){
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.tipo = new SimpleStringProperty(tipo);
    }

    //Property Getters (Para JavaFX y TableView)
    public IntegerProperty idProperty(){
        return id;
    }
    public StringProperty nombreProperty(){
        return nombre;
    }
    public StringProperty tipoProperty(){
        return tipo;
    }

    //Getter y Setter Clasicos (Para Java Tradicional)
    public int  getId(){
        return id.get();
    }
    public String getNombre(){
        return nombre.get();
    }
    public void setNombre(String nombre){
        this.nombre.set(nombre);
    }

    public String getTipo() {
        return tipo.get();
    }
    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }
}
