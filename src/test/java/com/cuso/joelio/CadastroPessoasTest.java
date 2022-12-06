package com.cuso.joelio;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoasTest {


    @Test
    public void deveCriarCadastroPessoas(){
        // cenario e execução
        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        //verificação
        Assertions.assertThat(cadastroPessoas.getPessoa()).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoaTeste(){
        // cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("joao");

        //execução
        cadastroPessoas.adicionar(pessoa);

        //verificação
        Assertions.assertThat(cadastroPessoas.getPessoa()).isNotEmpty().hasSize(1).contains(pessoa);
    }

    @Test(expected = PessoaSemNotException.class)
    public void naoDeveAdicionarPessoaComNomeVazio(){
        // cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execução
        cadastroPessoas.adicionar(pessoa);
    }

    @Test
    public void deveRemoverUmaPessoa(){
        // cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("joao");
        cadastroPessoas.adicionar(pessoa);

        // execução
        cadastroPessoas.remove(pessoa);

        //verificação
        Assertions.assertThat(cadastroPessoas.getPessoa()).isEmpty();
    }

    @Test(expected = CadastroVazioException.class)
    public void deveLancarErroAoTentarRomoverPessoaInexistente(){
        // cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        // execução
        cadastroPessoas.remove(pessoa);
    }
}
