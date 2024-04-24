import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Convertidor {

    public static void main(String[] args) {
        double dolar = 1.0;
        double pesosArg = 864.7500;
        double realBra= 5.1680;
        double pesoCol = 3901.8504;
        int opcion = 0;
        double cambio = 0;



        try {

            URL url = new URL("https://v6.exchangerate-api.com/v6/a21e4e8ee0760c61590f1a6f/latest/USD");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {

                throw new RuntimeException("Ocurrio un Error: " + responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
                System.out.println(informationString);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



        String menu = """
                 \n
                 Sea bienvenido/a al Conversor de Moneda \n
                 1 - Dolar => Peso Argentino
                 2 - Peso Argentino => Dolar
                 3 - Dolar => Real Brasileño
                 4 - Real Brasileño => Dolar
                 5 - Dolar => Peso Colombiano
                 6 - Peso Colombiano => Dolar 
                 7 - Salir
                """;


        Scanner teclado = new Scanner(System.in);

        while (opcion != 7) {

            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Cual es la cantidad de dolares que decea cambiar a Pesos Argentinos");
                    double divisaCambioDolar = teclado.nextDouble();
                    cambio = divisaCambioDolar * pesosArg;
                    System.out.println("La cantidad de Pesos Argentinos es: " + "$" + cambio);
                    break;
                case 2:
                    System.out.println("Cual es la cantidad de Pesos Argentinos que decea cambiar a Dolares");
                    double divisaCambioArg = teclado.nextDouble();
                    cambio = divisaCambioArg/pesosArg;
                    System.out.println("La cantidad de Dolares es: " + "$" + cambio);
                    break;
                case 3:
                    System.out.println("Cual es la cantidad de Dolares que decea cambiar a Real Brasileño");
                    double divisaCambioDolarRb = teclado.nextDouble();
                    cambio = divisaCambioDolarRb * realBra;
                    System.out.println("La cantidad de Real Brasileños es: " + "$" + cambio);
                    break;
                case 4:
                    System.out.println("Cual es la cantidad de Real Brasileño que decea cambiar a dolares");
                    double divisaCambioRbAdolar = teclado.nextDouble();
                    cambio =  divisaCambioRbAdolar/realBra;
                    System.out.println("La cantidad de Dolares es: " + "$" + cambio);
                    break;
                case 5:
                    System.out.println("Cual es la cantidad de Dolares que decea cambiar a Peso Colombiano");
                    double divisaCambioPcAdolar = teclado.nextDouble();
                    cambio =  divisaCambioPcAdolar * pesoCol;
                    System.out.println("La cantidad de Peso Colombiano es: " + "$" + cambio);
                    break;
                case 6:
                    System.out.println("Cual es la cantidad de Peso Colombiano que decea cambiar a Dolares");
                    double divisaCambioDolarPc = teclado.nextDouble();
                    cambio =  divisaCambioDolarPc / pesoCol;
                    System.out.println("La cantidad de Pesos Dolares: " + "$" + cambio);
                    break;
                    case 7:
                    System.out.println("Saliedo del programa, gracias por utilizar nuestros servicios, lo Intente hacer lo mejor que pude!");
                    break;
                default:
                    System.out.println("Opcion no valida");


            }


        }
    }

}

