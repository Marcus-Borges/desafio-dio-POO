package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    
    public void inscreverBootcamp(Bootcamp bootcamp) {
        // Evita inscrição duplicada
        if (!bootcamp.getDevsInscritos().contains(this)) {
            this.conteudosInscritos.addAll(bootcamp.getConteudos());
            bootcamp.getDevsInscritos().add(this);
        } else {
            System.out.println("Você já está inscrito neste Bootcamp.");
        }
    }

    public void cancelarInscricaoBootcamp(Bootcamp bootcamp) {
        if (bootcamp.getDevsInscritos().contains(this)) {
            this.conteudosInscritos.removeAll(bootcamp.getConteudos());
            bootcamp.getDevsInscritos().remove(this);
        } else {
            System.out.println("Você não está inscrito neste Bootcamp.");
        }
    }

    public void progredir() {
        if (!conteudosInscritos.isEmpty()) {
            Conteudo conteudo = conteudosInscritos.iterator().next();
            conteudosConcluidos.add(conteudo);
            conteudosInscritos.remove(conteudo);
        } else {
            System.out.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public void reiniciarProgresso() {
        this.conteudosInscritos.addAll(this.conteudosConcluidos);
        this.conteudosConcluidos.clear();
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos
        .stream()
        .mapToDouble(Conteudo::calcularXp)
        .sum();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
