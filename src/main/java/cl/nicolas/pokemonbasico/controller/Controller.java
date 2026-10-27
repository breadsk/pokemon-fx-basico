package cl.nicolas.pokemonbasico.controller;

import cl.nicolas.pokemonbasico.model.Pokemon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //1. Inyeccion de componentes definidos en el FXML
    @FXML
    private TableView<Pokemon> tableView;
    @FXML
    private TableColumn<Pokemon, Integer> colId;
    @FXML
    private TableColumn<Pokemon, String> colNombre;
    @FXML
    private TableColumn<Pokemon, String> colTipo;

    //2. Lista reactiva con los datos origen
    private final ObservableList<Pokemon> listaPokemon = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //A. Cargar datos de prueba
        listaPokemon.addAll(
                new Pokemon(1,"Bulbasaur","Planta"),
                new Pokemon(4,"Charmander","Fuego"),
                new Pokemon(7,"Squirtle","Agua"),
                new Pokemon(1,"Pikachu","Electrico")
        );//Diferencia entre add y addall

        //B. Enlazar columnas con las Properties del Modelo
        colId.setCellValueFactory(cell -> cell.getValue().idProperty().asObject());//<- Que hace esto
        colNombre.setCellValueFactory(cell -> cell.getValue().nombreProperty());
        colTipo.setCellValueFactory(cell -> cell.getValue().tipoProperty());

        //C. Permitir la edicion en vivo de la columna nombre
        tableView.setEditable(true);
        colNombre.setCellFactory(TextFieldTableCell.forTableColumn());
        colNombre.setOnEditCommit(event -> {
            Pokemon p = event.getRowValue(); //Captura la fila obtenida
            p.setNombre(event.getNewValue());//Actualiza el modelo con el nuevo texto
        });

        //D. Asignar la lista reactiva directamente a la tabla
        tableView.setItems(listaPokemon);

    }

    @FXML
    private void onEliminarClick(){
        Pokemon seleccionado = tableView.getSelectionModel().getSelectedItem();
        if(seleccionado != null){
            listaPokemon.remove(seleccionado);
        }
    }
}
