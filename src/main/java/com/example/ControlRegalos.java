package com.example;

import java.util.List;

public class ControlRegalos {

    List<Producto> regalos;
    List<Proveedor> proveedores;

    public ControlRegalos() {
    }

    public void recomendarRegalo(int edad, double presupuesto) {

        boolean flag = false;

        System.out.println(
                "Lista de regalos para una persona de " + edad + " años con un presupuesto de $" + presupuesto + ":");

        for (Producto producto : regalos) {
            if (edad == producto.getEdadRecomendada() && (producto.getPrecioBase()
                    + getProveedorPrecioEnvio(proveedores, producto.getProveedor()) < presupuesto)) {
                flag = true;
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Precio Base: $" + producto.getPrecioBase());
                System.out
                        .println("Precio de Envío: $" + getProveedorPrecioEnvio(proveedores, producto.getProveedor()));
                System.out.println("Precio Total: $"
                        + (producto.getPrecioBase() + getProveedorPrecioEnvio(proveedores, producto.getProveedor())));
                System.out.println("--------------");
            }

        }
        if (flag == false) {
            System.out.println("No se tiene productos para esa edad o precio");

        }
    }

    private double getProveedorPrecioEnvio(List<Proveedor> proveedores, String proveedorNombre) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getNombre().equals(proveedorNombre)) {
                return proveedor.getPrecioEnvio();
            }
        }
        return 0;
    }

    public List<Producto> getRegalos() {
        return regalos;
    }

    public void setRegalos(List<Producto> regalos) {
        this.regalos = regalos;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

}
