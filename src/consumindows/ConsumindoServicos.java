/*
    Lucas Buzetto Tsuchiya  and Pedro Bazia Neto

 */
package consumindows;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import modelo.Motorista;
import modelo.Passageiro;
import modelo.Reserva;
//Classe para consumir os serviços do webservices transfers
public class ConsumindoServicos {
    //Variável para processar as requisições no método post
   private final String USER_AGENT = "Mozilla/5.0";
    
    
    public static void main(String[] args) throws Exception {
        
        //Codificação para tester os métodos implementados
        ConsumindoServicos http = new ConsumindoServicos();
        String chamadaWS;
        String id = "lucas";
        chamadaWS = "http://127.0.0.1:5000/passageiros/"+id;
        String json = http.envioGet(chamadaWS);
        System.out.println(json);
        Passageiro p = new Passageiro();
        Gson g = new Gson();
        Type passageiroType = new TypeToken<Passageiro>() {}.getType();
        p = g.fromJson(json, passageiroType);
        System.out.println(p.getNome());
        
        String motorista_id = "pedro";
        String chamadaWS_motorista = "http://127.0.0.1:5000/motoristas/"+motorista_id;
        String json_motorista = http.envioGet(chamadaWS_motorista);
        Motorista m = new Motorista();
        Gson gm = new Gson();
        Type motoristaType = new TypeToken<Motorista>() {}.getType();
        m = gm.fromJson(json_motorista, motoristaType);
        System.out.println(m.getNome());
        //Criando uma reserva manualmente.
        Reserva nova_reserva = new Reserva();
        nova_reserva.setReserva_id("utfpr");
        nova_reserva.setPassageiro_id(p.getPassageiro_id());
        nova_reserva.setMotorista_id(m.getMotorista_id());
        nova_reserva.setPassageiro(p.getNome());
        nova_reserva.setMotorista(m.getNome());
        nova_reserva.setOrigem(p.getOrigem());
        nova_reserva.setDestino(p.getDestino());
        nova_reserva.setTipo_carro(m.getTipo_carro());
        nova_reserva.setCapacidade(m.getCapacidade());
        nova_reserva.setPreco(m.getPreco());
        Type reserva_novo_Type = new TypeToken<Reserva>() {}.getType();
        String novo_json_reserva = g.toJson(nova_reserva, reserva_novo_Type);
        String url_reserva = "http://127.0.0.1:5000/reservas/"+nova_reserva.getReserva_id();
        http.envioPost(url_reserva, novo_json_reserva, "POST");
    }

    // Método para requisição, processamento e recebimento de dados do servidor
    public String envioGet(String url) throws Exception {

        URL obj = new URL(url);
        //prepara a requisição 
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();

    }
    // Método para requisição, processamento e envio de dados para o servidor
    public void envioPost(String url, String urlParameters, String method) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //Adicionando header
        con.setRequestMethod(method);
        con.setRequestProperty("Content-Type", "application/json");
        //Processando a requisição
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        // Preparar e enviar requisição 
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        //Prints para análisar o processamento da requisição
        System.out.println("Enviando 'POST' request na URL : " + url);
        System.out.println("Parametros: : " + urlParameters);
        System.out.println("Respostas : " + responseCode);
        //Processando a requisição 
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        //Novas leituras
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //Print do resultado
        System.out.println(response.toString());

    }

    

}