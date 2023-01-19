package com.pruebayanqui.pruebajuanyanqui.controller;

import com.pruebayanqui.pruebajuanyanqui.model.ListaReproduccion;
import com.pruebayanqui.pruebajuanyanqui.service.ServiceCancion;
import com.pruebayanqui.pruebajuanyanqui.service.ServiceLista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista")
public class ControllerLista {
    @Autowired
    ServiceLista serviceLista;


    @GetMapping("/li")
    public ResponseEntity<List<ListaReproduccion>> obtenerListali() {
        return new ResponseEntity<>(serviceLista.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/cre")
    public ResponseEntity<ListaReproduccion> crearcli(@RequestBody ListaReproduccion lista){
        return new ResponseEntity<>(serviceLista.save(lista), HttpStatus.CREATED);
    }

    @DeleteMapping("/eli/{id}")
    public ResponseEntity <?> eliminarli(@PathVariable Integer id) {
        serviceLista.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actu/{id}")
    public ResponseEntity <ListaReproduccion> actulizarli(@RequestBody ListaReproduccion lista, @PathVariable Integer id) {
        ListaReproduccion li = serviceLista.findById(id);
        if (li ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            li.setNombre(lista.getNombre());
            li.setDescripcion(lista.getDescripcion());
            li.setCancion(lista.getCancion());
            return new ResponseEntity<>(serviceLista.save(li), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
