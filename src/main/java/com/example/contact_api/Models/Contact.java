package com.example.contact_api.Models;
import java.time.LocalDate;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @Email(message = "O e−mail deve ser válido")
    @NotBlank(message = "O e−mail é obrigatório")
    @Size(max = 150, message = "O e−mail deve ter no máximo 150 caracteres")
    private String email;

    @NotBlank(message = "O telefone é obrigatório")
    @Size(max = 50, message = "O telefone deve ter no máximo 50 caracteres")
    private String telefone;

    @Positive(message = "A idade deve ser um número positivo")
    private Integer idade;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @Past(message = "A data de nascimento deve ser no passado")
    private LocalDate dataNascimento;

    public Contact() { }

    public Contact(int Id, String nome, String email, String telefone, Integer idade, LocalDate dataNascimento) {
        this.Id = Id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
    }

    public int getId() { return Id; }
    public void setId(int Id) { this.Id = Id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
}