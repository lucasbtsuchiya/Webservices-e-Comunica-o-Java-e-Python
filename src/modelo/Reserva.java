/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Lucas Tsuchiya and Pedro Bazia Neto
 */
//Classe para modelar e descrever os parametros da classe
public class Reserva {
    private String reserva_id;
    private String passageiro_id;
    private String motorista_id;
    private String passageiro;
    private String motorista;
    private String origem;
    private String destino;
    private String tipo_carro;
    private String capacidade;
    private String preco;

    public String getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(String reserva_id) {
        this.reserva_id = reserva_id;
    }

    public String getPassageiro_id() {
        return passageiro_id;
    }

    public void setPassageiro_id(String passageiro_id) {
        this.passageiro_id = passageiro_id;
    }

    public String getMotorista_id() {
        return motorista_id;
    }

    public void setMotorista_id(String motorista_id) {
        this.motorista_id = motorista_id;
    }

    public String getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(String passageiro) {
        this.passageiro = passageiro;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipo_carro() {
        return tipo_carro;
    }

    public void setTipo_carro(String tipo_carro) {
        this.tipo_carro = tipo_carro;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    
}
