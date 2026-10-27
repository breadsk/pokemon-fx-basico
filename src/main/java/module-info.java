module cl.nicolas.pokemonbasico {
    requires javafx.controls;
    requires javafx.fxml;


    opens cl.nicolas.pokemonbasico.controller to javafx.fxml;

    exports cl.nicolas.pokemonbasico;
    exports cl.nicolas.pokemonbasico.controller;
    exports cl.nicolas.pokemonbasico.model;
}