package com.pruebayanqui.pruebajuanyanqui.service;

import com.pruebayanqui.pruebajuanyanqui.model.ListaReproduccion;
import com.pruebayanqui.pruebajuanyanqui.repository.CancionRepository;
import com.pruebayanqui.pruebajuanyanqui.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceListaImpl extends GenericServiceImpl<ListaReproduccion, Integer> implements ServiceLista{

    @Autowired
    ListaRepository listaRepository;
    @Override
    public CrudRepository<ListaReproduccion, Integer> getDao() {
        return listaRepository;
    }
}
