package com.giordanomenezes.cursomc;

import com.giordanomenezes.cursomc.domain.Categoria;
import com.giordanomenezes.cursomc.domain.Cidade;
import com.giordanomenezes.cursomc.domain.Cliente;
import com.giordanomenezes.cursomc.domain.Endereco;
import com.giordanomenezes.cursomc.domain.Estado;
import com.giordanomenezes.cursomc.domain.ItemPedido;
import com.giordanomenezes.cursomc.domain.Pagamento;
import com.giordanomenezes.cursomc.domain.PagamentoComBoleto;
import com.giordanomenezes.cursomc.domain.PagamentoComCartao;
import com.giordanomenezes.cursomc.domain.Pedido;
import com.giordanomenezes.cursomc.domain.Produto;
import com.giordanomenezes.cursomc.domain.enums.EstadoPagamento;
import com.giordanomenezes.cursomc.domain.enums.TipoCliente;
import com.giordanomenezes.cursomc.repositories.CategoriaRepository;
import com.giordanomenezes.cursomc.repositories.CidadeRepository;
import com.giordanomenezes.cursomc.repositories.ClienteRepository;
import com.giordanomenezes.cursomc.repositories.PagamentoRepository;
import com.giordanomenezes.cursomc.repositories.ProdutoRepository;
import java.math.BigDecimal;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import com.giordanomenezes.cursomc.repositories.PedidoRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository catrepo;

    @Autowired
    private ProdutoRepository prodrepo;

    @Autowired
    private CidadeRepository cidaderepo;

    @Autowired
    private ClienteRepository clienterepo;

    @Autowired
    private PedidoRepository pedrepo;

    @Autowired
    private PagamentoRepository pagtorepo;

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
        e2.getCidades().addAll(Arrays.asList(c2, c3));

        //pelo cascade, e1 tambem será salvo.
        cidaderepo.save(c1);
        cidaderepo.save(c2);
        cidaderepo.save(c3);

        //CLIENTES e ENDEREÇOS
        Cliente cli1 = new Cliente("Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PF);
        cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

        Endereco end1 = new Endereco(null, "Rua das Flores", "300", "Apto 203", "Jardim Europa", "38220834", cli1, c1);
        Endereco end2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c1);

        cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

        clienterepo.save(cli1);

        //PEDIDOS E PAGAMENTOS
        Pedido ped1 = new Pedido(LocalDateTime.of(2017, Month.SEPTEMBER, 30, 10, 32), cli1, end1);
        Pedido ped2 = new Pedido(LocalDateTime.of(2017, Month.OCTOBER, 10, 19, 35), cli1, end2);

        Pagamento pagto1 = new PagamentoComCartao(6, EstadoPagamento.QUIT, ped1);
        Pagamento pagto2 = new PagamentoComBoleto(LocalDate.of(2017, Month.OCTOBER, 20), null, EstadoPagamento.PEND, ped2);

        pedrepo.save(ped1);
        pedrepo.save(ped2);
        pagtorepo.save(pagto1);
        pagtorepo.save(pagto2);

        //ITENS DE PEDIDO
        ItemPedido ip1 = new ItemPedido(p1, ped1, BigDecimal.ZERO, 1, new BigDecimal(2000));
        ItemPedido ip2 = new ItemPedido(p3, ped1, BigDecimal.ZERO, 2, new BigDecimal(80));
        ItemPedido ip3 = new ItemPedido(p2, ped2, new BigDecimal(100), 1, new BigDecimal(800));

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));

        p1.getItensPedido().addAll(Arrays.asList(ip1));
        p2.getItensPedido().addAll(Arrays.asList(ip3));
        p3.getItensPedido().addAll(Arrays.asList(ip2));

        pedrepo.save(ped1);
        pedrepo.save(ped2);
    }
}
