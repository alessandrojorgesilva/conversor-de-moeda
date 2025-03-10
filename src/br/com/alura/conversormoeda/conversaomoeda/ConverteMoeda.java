package br.com.alura.conversormoeda.conversaomoeda;

import br.com.alura.conversormoeda.modelo.Moeda;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConverteMoeda {
    private final String KEY = System.getenv("EXCHANGERATE_APIKEY");
    private  String moedaBase;
    private  String moedaRequerida;

    public JsonObject consultaTaxaDeCambio(String moedaBase, String moedaRequerida, BigDecimal valor) {

        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + KEY + "/pair/"+moedaBase+"/"+moedaRequerida+"/"+valor);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);

            return  jsonObject;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void converteValorMoeda(int opcao, BigDecimal valor) {

        for(Moeda m: Moeda.values()){
            if(opcao == m.getOpcao()){
                this.moedaBase = m.getMoedaBase();
                this.moedaRequerida = m.getMoedaRequerida();
                break;
            }
        }

        JsonObject json = consultaTaxaDeCambio(this.moedaBase, this.moedaRequerida, valor);
        JsonElement valorConvertido = json.get("conversion_result");
        System.out.println("O VALOR DE " + valor +" " + "[" + this.moedaBase + "]"
                + " corresponde ao valor final de =>>> " + valorConvertido +
                " [" + this.moedaRequerida + "]");
    }

}
