package br.com.alura.conversormoeda.modelo;

public enum Moeda {

    USDBRL(1, "USD", "BRL"),
    BRLUSD(2, "BRL", "USD"),
    USDEUR(3, "USD", "EUR"),
    EURUSD(4, "EUR", "USD"),
    BRLEUR(5, "BRL", "EUR"),
    EURBRL(6,  "EUR", "BRL"),
    USDARS(7, "USD", "ARS" ),
    ARSUSD(8, "ARS", "USD"),
    USDCOP(9, "USD", "COP"),
    COPUSD(10, "COP", "USD"),
    BRLARS(11, "BRL", "ARS"),
    ARSBRL(12, "ARS", "BRL"),
    BRLCOP(13, "BRL", "COP"),
    COPBRL(14, "COP", "BRL");


    private int opcao;
    private String moedaBase;
    private String moedaRequerida;

    Moeda(int opcao, String moedaBase, String moedaRequerida ) {
        this.opcao = opcao;
        this.moedaBase = moedaBase;
        this.moedaRequerida = moedaRequerida;
    }

    public int getOpcao() {
        return opcao;
    }

    public String getMoedaBase() {
        return moedaBase;
    }

    public String getMoedaRequerida() {
        return moedaRequerida;
    }
}
