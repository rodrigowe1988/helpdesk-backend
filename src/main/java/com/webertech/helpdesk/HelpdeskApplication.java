package com.webertech.helpdesk;

import com.webertech.helpdesk.domain.Chamado;
import com.webertech.helpdesk.domain.Cliente;
import com.webertech.helpdesk.domain.Tecnico;
import com.webertech.helpdesk.domain.enums.Perfil;
import com.webertech.helpdesk.domain.enums.Prioridade;
import com.webertech.helpdesk.domain.enums.Status;
import com.webertech.helpdesk.repositories.ChamadoRepository;
import com.webertech.helpdesk.repositories.ClienteRepository;
import com.webertech.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelpdeskApplication.class, args);
    }


}
