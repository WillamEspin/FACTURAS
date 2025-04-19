package com.example.facturas.services;

import com.example.facturas.model.Compras;

import java.util.ArrayList;
import java.util.List;

public class ComprasService {
    private final List<Compras> listaCompras = new ArrayList<>();

    public void mostrarProveedorC(Compras compra) {
        listaCompras.add(compra);
    }

    public List<Compras> getListaCompras() {
        return listaCompras;
    }
}

