package br.com.fiap.mvc.controller;

import br.com.fiap.mvc.model.Produto;
import br.com.fiap.mvc.respository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Produto produto){
        return "produto/cadastro";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        //Pessquisa o produto pela a id enviando para view
        model.addAttribute("produto", produtoRepository.findById(id));
        //retorno da view
        return "produto/editar";
    }

    @PostMapping("editar")
    @Transactional
    public String editar(Produto produto, RedirectAttributes redirectAttributes){
        produtoRepository.save(produto);
        redirectAttributes.addFlashAttribute("msg", "Produto atualizado com sucesso");
        return "redirect:/produto/listar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(Produto produto, RedirectAttributes redirectAttributes){
        produtoRepository.save(produto);
        redirectAttributes.addFlashAttribute("msg", "Novo produto registrado");
        return "redirect:/produto/cadastrar";
    }

    @PostMapping("excluir")
    @Transactional
    public String remover(Long idStatus, RedirectAttributes redirectAttributes){
        produtoRepository.deleteById(idStatus);
        redirectAttributes.addFlashAttribute("msg", "Produto removido");
        return "redirect:/produto/listar";
    }

}
