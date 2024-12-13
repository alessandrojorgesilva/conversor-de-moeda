package br.com.alura.conversormoeda.principal;

import br.com.alura.conversormoeda.conversaomoeda.ConverteMoeda;
import br.com.alura.conversormoeda.modelo.Moeda;

import java.math.BigDecimal;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int opcao = 1;

        String menu = """
                **********************************************
                Sejam bem-vindo/a ao Conversor de Moeda:                
                1) Dólar ==> Real
                2) Real ==> Dólar
                3) Dólar ==> Euro
                4) Euro ==> Dólar
                5) Real ==> Euro
                6) Euro ==> Real
                7) Dólar ==> Peso Argentino
                8) Peso Argentino ==> Dólar
                9) Dólar ==> Peso Colombiano
                10) Peso Colombiano ==> Dólar
                11) Real ==> Peso Argentino
                12) Peso Argentino ==> Real
                13) Real ==> Peso Colombiano
                14) Peso Colombiano ==> Real
                
                15) Sair                
                **********************************************
                Escolha uma opção válida:                 
                """;//.formatted();
        System.out.println(menu);
        while (opcao != 7) {
            Scanner leitura = new Scanner(System.in);
            opcao = leitura.nextInt();
            System.out.println("Informe o valor que deseja converter:");
            BigDecimal valor = leitura.nextBigDecimal();

            ConverteMoeda api = new ConverteMoeda();
            api.converteValorMoeda2(opcao, valor);

            System.out.println(menu);
        }
    }
}
