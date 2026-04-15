package model;


public class Usuario {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    public Usuario(int id, String nome, String telefone, String email, String endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
public String toString() {
    return "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email;
}

}