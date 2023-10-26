package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ArchivoLector {
    ControlRegalos ctrlregalos;

    public void consultarDatos(ControlRegalos controlRegalos) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Leer datos de proveedores desde el archivo JSON
            List<Proveedor> proveedores = objectMapper.readValue(
                    new File("tarea4\\src\\main\\resources\\proveedores.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Proveedor.class));

            // Leer datos de productos desde el archivo JSON
            List<Producto> productos = objectMapper.readValue(new File("tarea4\\src\\main\\resources\\productos.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Producto.class));

            controlRegalos.setProveedores(proveedores);
            controlRegalos.setRegalos(productos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
