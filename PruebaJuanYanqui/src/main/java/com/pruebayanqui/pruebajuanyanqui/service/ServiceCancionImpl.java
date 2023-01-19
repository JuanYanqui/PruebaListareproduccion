package com.pruebayanqui.pruebajuanyanqui.service;

import com.pruebayanqui.pruebajuanyanqui.model.Cancion;
import com.pruebayanqui.pruebajuanyanqui.model.ListaReproduccion;
import com.pruebayanqui.pruebajuanyanqui.repository.CancionRepository;
import com.pruebayanqui.pruebajuanyanqui.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceCancionImpl extends GenericServiceImpl<Cancion, Integer> implements ServiceCancion{

    @Autowired
    CancionRepository cancionRepository;
    @Override
    public CrudRepository<Cancion, Integer> getDao() {
        return cancionRepository;
    }
}
