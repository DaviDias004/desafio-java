package model;

public class Solicitacao {

    private int id;
    private Beneficiario beneficiario;
    private ItemDoacao item;
    private int quantidadeSolicitada;
    private String justificativa;
    private String status;

    public Solicitacao(int id, Beneficiario beneficiario, ItemDoacao item, int quantidadeSolicitada, String justificativa, String status) {
       
        this.id = id;
        this.beneficiario = beneficiario;
        this.item = item;
        this.quantidadeSolicitada = quantidadeSolicitada;
        this.justificativa = justificativa;
        this.status = status;
    }

    public String getStatus() {
    return status;
    }
    
    public void setStatus(String status) {
    this.status = status;
    }

    @Override
    public String toString() {
        return "Beneficiário: " + beneficiario +
               "\nItem: " + item +
               "\nQuantidade: " + quantidadeSolicitada +
               "\nStatus: " + status;
    }
}