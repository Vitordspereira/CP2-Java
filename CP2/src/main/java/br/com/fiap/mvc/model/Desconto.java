package br.com.fiap.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Desconto {

    private Double preco;
    private Double desconto; // Desconto em porcentagem

    // Calcula o valor do desconto
    public Double calcularValorDesconto() {
        return preco * (desconto / 100);
    }

    // Calcula o preço final com o desconto aplicado
    public Double calcularPrecoFinal() {
        return preco - calcularValorDesconto();
    }

}
