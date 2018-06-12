package com.giordanomenezes.cursomc;

import com.giordanomenezes.cursomc.domain.Categoria;
import com.giordanomenezes.cursomc.domain.Cidade;
import com.giordanomenezes.cursomc.domain.Estado;
import com.giordanomenezes.cursomc.domain.Produto;
import com.giordanomenezes.cursomc.repositories.CategoriaRepository;
import com.giordanomenezes.cursomc.repositories.CidadeRepository;
import com.giordanomenezes.cursomc.repositories.ProdutoRepository;
import java.math.BigDecimal;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    
    @Autowired
    private CategoriaRepository catrepo;

    @Autowired
    private ProdutoRepository prodrepo;

    @Autowired
    private CidadeRepository cidaderepo;

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        //CATEGORIAS E PRODUTOS
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", new BigDecimal(2000));
        Produto p2 = new Produto(null, "Impressora", new BigDecimal(800));
        Produto p3 = new Produto(null, "Mouse", new BigDecimal(80));

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().add(p2);

        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().add(cat1);

        catrepo.saveAll(Arrays.asList(cat1, cat2));
        prodrepo.saveAll(Arrays.asList(p1, p2, p3));

        //CIDADES E ESTADOS
        Estado e1 = new Estado(null, "Minas Gerais");
        Estado e2 = new Estado(null, "São Paulo");
        Cidade c1 = new Cidade(null, "Uberlândia", e1);
        Cidade c2 = new Cidade(null, "São Paulo", e2);
        Cidade c3 = new Cidade(null, "Campinas", e2);

        e1.getCidades().add(c1);
        e2.getCidades().addAll(Arrays.asList(c2,c3));

        //pelo cascade, e1 tambem será salvo.
        cidaderepo.save(c1);
        cidaderepo.save(c2);
        cidaderepo.save(c3);

    }
}
