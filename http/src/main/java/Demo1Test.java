import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author Zerox
 * @date 2019/2/21 8:38
 */
public class Demo1Test {

    /**
     *  1. 第一次执行之后检测到没有请求头~
     */
    public static void main(String[] args) throws Exception{

        // 1. 生成Http对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 2. 获取httpGet对象
        HttpGet httpGet = new HttpGet("http://www.tuicool.com/");
        // 2.1 设置http请求头 User-Agent ,模拟第一次请求,
        httpGet.setHeader("User-Agent","Mozilla/5.0(Windows NT 6.1;Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        // 3. 执行httpGet
        CloseableHttpResponse response = httpClient.execute(httpGet);
        // 4. 获取返回的实体
        HttpEntity httpEntity = response.getEntity();
        // 5. 解析实体类
        String entityJson = EntityUtils.toString(httpEntity,"utf-8");
        // 6. 打印数据,观看结果
        System.out.println("返回的数据是:" + entityJson);
        // 7. 关闭连接对象
        response.close();
        httpClient.close();
    }
}
