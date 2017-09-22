import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by sunhongbo on 17/9/15.
 */
public class GetResponse {


    public String getStringFromRequest(InputStream is) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len = -1;
        String result = "";
        try {
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            is.close();
            result = os.toString();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
