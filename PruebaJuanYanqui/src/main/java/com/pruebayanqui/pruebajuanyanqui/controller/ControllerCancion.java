package com.pruebayanqui.pruebajuanyanqui.controller;

import com.pruebayanqui.pruebajuanyanqui.model.Cancion;
import com.pruebayanqui.pruebajuanyanqui.repository.CancionRepository;
import com.pruebayanqui.pruebajuanyanqui.service.ServiceCancion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cancion")
public class ControllerCancion {
    @Autowired
    ServiceCancion serviceCancion;

    @GetMapping("/li")
    public ResponseEntity<List<Cancion>> obtenerListacan() {
        return new ResponseEntity<>(serviceCancion.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/cre")
    public ResponseEntity<Cancion> crearcli(@RequestBody Cancion cancion){
        return new ResponseEntity<>(serviceCancion.save(cancion), HttpStatus.CREATED);
    }
    @DeleteMapping("/eli/{id}")
    public ResponseEntity <?> eliminarcan(@PathVariable Integer id) {
        serviceCancion.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actu/{id}")
    public ResponseEntity <Cancion> actulizarcan(@RequestBody Cancion cancion, @PathVariable Integer id) {
        Cancion can = serviceCancion.findById(id);
        if (can ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            can.setTitulo(cancion.getTitulo());
            can.setArtista(cancion.getArtista());
            can.setAlbum(cancion.getAlbum());
            can.setYear(cancion.getYear());
            return new ResponseEntity<>(serviceCancion.save(can), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
