package org.example;

import java.util.Observable;

public class Pedido extends Observable {
    private PedidoEstado estado;
    private IRestaurante restaurante;

    public Pedido(IRestaurante restaurante) {
        this.restaurante = restaurante;
    }

    public void setRestaurante(IRestaurante restaurante) {
        this.restaurante = restaurante;
    }

    public IRestaurante getRestaurante() {
        return restaurante;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
        notificarMudanca();
    }

    public PedidoEstado getEstado() {
        return this.estado;
    }

    public boolean criar(Pedido pedido) {
        return this.estado.criar(this);
    }

    public boolean preparar(Pedido pedido) {
        return this.estado.preparar(this);
    }

    public boolean sair(Pedido pedido) {
        return this.estado.sair(this);
    }

    public boolean entregar(Pedido pedido) {
        return this.estado.entregar(this);
    }

    public boolean cancelar(Pedido pedido) {
        return this.estado.cancelar(this);
    }


    private void notificarMudanca() {
        String nomeRestaurante = restaurante != null ? restaurante.getNome() : "Desconhecido";
        setChanged();
        notifyObservers("Estado do pedido: " + estado.getEstado() + " (por " + nomeRestaurante + ")");
    }
}