import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author Zerox
 * @date 2019/2/20 16:56
 */
public class Demo1 {

    public static void main(String[] args) throws Exception{

        CloseableHttpClient httpClient = HttpClients.createDefault();       // 创建httpClient实例
        HttpGet httpGet = new HttpGet("http://www.tuicool.com/");   // 创建httpGet实例

        CloseableHttpResponse response = httpClient.execute(httpGet);       // 执行http get请求

        HttpEntity entity = response.getEntity();                           // 获取返回实体
        System.out.println("网页内容:" + EntityUtils.toString(entity,"utf-8")); // 获取网页内容
        response.close();                                                   // response关闭
        httpClient.close();                                                 // httpClient关闭
    }
}
