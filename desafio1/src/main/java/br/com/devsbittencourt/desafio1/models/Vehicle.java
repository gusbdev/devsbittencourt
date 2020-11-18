package br.com.devsbittencourt.desafio1.models;

public class Vehicle {
    private String vehicleType;
    private String marca;
    private String modelo;
    private String cor;

    public String getMarca() {
        return this.marca;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
