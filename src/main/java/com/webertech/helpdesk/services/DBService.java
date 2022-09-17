package com.webertech.helpdesk.services;

import com.webertech.helpdesk.domain.Chamado;
import com.webertech.helpdesk.domain.Cliente;
import com.webertech.helpdesk.domain.Tecnico;
import com.webertech.helpdesk.domain.enums.Perfil;
import com.webertech.helpdesk.domain.enums.Prioridade;
import com.webertech.helpdesk.domain.enums.Status;
import com.webertech.helpdesk.repositories.ChamadoRepository;
import com.webertech.helpdesk.repositories.ClienteRepository;
import com.webertech.helpdesk.repositories.PessoaRepository;
import com.webertech.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanciaDB() {
        Tecnico tec1 = new Tecnico(null, "Valdir Cesar", "12345678345", "valdir@email.com", encoder.encode("123"));
        tec1.addPerfil(Perfil.ADMIN);
        Tecnico tec2 = new Tecnico(null, "Richard Stalon", "54536612084", "stall@email.com", encoder.encode("123"));
        Tecnico tec3 = new Tecnico(null, "Claude Elwood Shannon", "69004215042", "shannon@email.com", encoder.encode("123"));
        Tecnico tec4 = new Tecnico(null, "Tim Berner-Lee", "69901875064", "lee@email.com", encoder.encode("123"));
        Tecnico tec5 = new Tecnico(null, "Linus Torvalds", "64276895090", "linus@email.com", encoder.encode("123"));

        Cliente cli1 = new Cliente(null, "Albert Einstein", "96354629056", "albert@email.com", encoder.encode("123"));
        Cliente cli2 = new Cliente(null, "Rodrigo Weber", "17803055087", "rodrigo@email.com", encoder.encode("123"));
        Cliente cli3 = new Cliente(null, "Marie Curie", "75498788037", "marie@email.com", encoder.encode("123"));
        Cliente cli4 = new Cliente(null, "Stephen Hawking", "31581725000", "stephen@email.com", encoder.encode("123"));
        Cliente cli5 = new Cliente(null, "Max Planck", "24395192009", "max@email.com", encoder.encode("123"));

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
        Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
        Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
        Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cli3);
        Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
        Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 7", "Teste chamado 6", tec1, cli5);

        pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
    }
}
