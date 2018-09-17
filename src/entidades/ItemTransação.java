
package entidades;

import javax.persistence.OneToMany;

public class ItemTransação {
    private int qntdCompra;
    private double total;
    @OneToMany
    private Produto poduto;

    public int getQntdCompra() {
        return qntdCompra;
    }

    public void setQntdCompra(int qntdCompra) {
        this.qntdCompra = qntdCompra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Produto getPoduto() {
        return poduto;
    }

    public void setPoduto(Produto poduto) {
        this.poduto = poduto;
    }
}
