import java.util.Random;

public class GeradorCPF {

    public static String gerar(){

        Random random = new Random(1);

        String response = "";

        for (int i = 0; i <= 11; i++){
             response += random.nextInt()+ "";
        }
        return response;
    }
}
