/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Lucas Tsuchiya e Pedro Bazia Neto
 */
//Classe para modelar e descrever os parametros da classe
public class Passageiro {
    private String passageiro_id;
    private String nome;
    private String origem;
    private String destino;
    private String tipo_carro;
    private String capacidade;
    private String preco;

    public String getPassageiro_id() {
        return passageiro_id;
    }

    public void setPassageiro_id(String passageiro_id) {
        this.passageiro_id = passageiro_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
