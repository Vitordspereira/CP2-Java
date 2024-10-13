package br.com.fiap.mvc.controller;

import br.com.fiap.mvc.model.Desconto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("desconto")
public class CalculoDescontoController {

    // Carrega a página para calcular o desconto
    @GetMapping("porcentagem")
    public String calcular() {
        return "calculo/porcentagem"; // Carrega o template correto (por exemplo, um formulário)
    }

    // Processa o cálculo do desconto
    @PostMapping("porcentagem")
    public String calcular(Desconto desconto, Model model) {
        System.out.println("Calculando porcentagem de desconto: " + desconto.getPreco());

        // Calcula o valor do desconto e o preço final
        double valorDesconto = desconto.calcularValorDesconto();
        double precoFinal = desconto.calcularPrecoFinal();

        // Adiciona os valores calculados ao modelo para enviar à view
        model.addAttribute("valorDesconto", valorDesconto);
        model.addAttribute("precoFinal", precoFinal);
        model.addAttribute("desconto", desconto); // Passa o objeto desconto completo para a view

        // Retorna para a página que exibe os resultados
        return "calculo/resultado"; // Altera para o template que vai exibir o resultado
    }
}



