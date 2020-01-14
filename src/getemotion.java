import com.paralleldots.paralleldots.App;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.parser.JSONParser;


public class getemotion{
    public static void main(String[] args) {
        getemotion("Kill my self");
    }

    public void getsentiment(String check) {
        App pd = new App("g2zZ63dJSsvrnnRPSoGL7oUjtUt6Fu3d4rT7OIFAbYU");
        try {
            String sentiment = pd.sentiment(check);
            //String sentiment = "{\"sentiment\":{\"negative\":0.068,\"neutral\":0.46,\"positive\":0.472}}";

            System.out.println(getresult(sentiment));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getresult(String sentiment){
        int maxat = 0;
        String[] sentimentval = {"Negative","Neutral","Positive","Mixed"};
        String[] str1;
        Double[] val = new Double[3];
        str1 = sentiment.split("\":");


            val[0] = Double.parseDouble(str1[2].split(",")[0]);
            val[1] = Double.parseDouble(str1[3].split(",")[0]);
            val[2] = Double.parseDouble(str1[4].split("}")[0]);

            Double max = val[0];

            for (int i = 1; i < 3; i++) {
                System.out.println("checking " + i + "= " + val[i]);
                if (val[i] > max) {
                    max = val[i];
                    maxat = i;
                    System.out.println("max updated = " + val[i]);
                } else if (val[i] == max) {
                    System.out.println("mixed");
                    maxat = 3;
                }
            }
        return sentimentval[maxat];
    }
    }