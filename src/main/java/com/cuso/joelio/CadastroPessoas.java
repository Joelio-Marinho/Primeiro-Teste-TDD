package com.cuso.joelio;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {
    private List<Pessoa> pessoa;

    public CadastroPessoas() {
        this.pessoa = new ArrayList<>();
    }

    public List<Pessoa> getPessoa() {
        return this.pessoa;
    }

    public void adicionar(Pessoa pessoa) {
        if (pessoa.getNome()==null){
            throw new PessoaSemNotException();
        }
        this.pessoa.add(pessoa);
    }

    public void remove(Pessoa pessoa) {
        if(this.pessoa.isEmpty()){
            throw new CadastroVazioException();
        }
        this.pessoa.remove(pessoa);
    }
}
