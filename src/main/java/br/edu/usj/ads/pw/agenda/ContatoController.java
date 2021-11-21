package br.edu.usj.ads.pw.agenda;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class ContatoController {

    @Autowired
    ContatoRepository contatoRepository;
    
    @GetMapping(value="/")
    public ModelAndView getIndex() {

        List<Contato> lista = new ArrayList<>();

        lista = contatoRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("lista", lista);

        return modelAndView;
    }

    //Não esquecer das Get para recebimento aula 05/11

    @GetMapping(value="/detalhes/{id}")
    public ModelAndView getDetalhes(@PathVariable Long id) {

        Contato contato = new Contato();
        contato = contatoRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("detalhes");

        modelAndView.addObject("contato", contato);

        return modelAndView;
    }
    

    @GetMapping(value="/cadastro")
    public ModelAndView getCadastro() {
        Contato contato = new Contato();

        ModelAndView modelAndView = new ModelAndView("cadastro");

        modelAndView.addObject("contato", contato);

        return modelAndView;
    }

    @PostMapping(value="/adicionar")
    public ModelAndView postAdicionar(Contato contato) {

        contatoRepository.save(contato);

        ModelAndView modelAndView = new ModelAndView("detalhes");

      
        modelAndView.addObject("contato", contato);

      
        return modelAndView;
    }

    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
 
        Contato contato = new Contato();
        contato = contatoRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("cadastro");

        modelAndView.addObject("contato", contato);

        return modelAndView;
    }
    

    @GetMapping(value="/deletar/{id}")
    public String getDeletar(@PathVariable Long id) {
       
        contatoRepository.deleteById(id);

        return "redirect:/";
    }
    //retornar os parametros
    
}
