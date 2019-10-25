package com.example.demo;

import org.apache.kafka.common.metrics.stats.Count;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.io.*;

/**
 * @Auther: Xiao
 * @Date: 2019/2/26 0026 :19:46
 * @Description:
 */

@Configuration
@EnableWebSocket
public class TestWebsocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "/myHandler");
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new LocalWebsocketHandler();
    }

    public static void main(String[] args) {
        File file = new File("file");
        File file1 = new File("sqlfile.txt");
        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                PrintWriter printWriter = new PrintWriter(new FileOutputStream(file1));
                ){
            String line = "";
            int count = 0;
            while ((line = bufferedReader.readLine())!= null){
                printWriter.write("(select "+count+" as count , send_date,\""+line+"\",case when send_date > '2019-09-27 18:30:00' then '成功' else '失败' end as result ,remark from zhgd_dw.d_project_send_log where data_mapping_bean = '"+line+"'  order by send_date desc limit 1\n)");
                printWriter.write("union ");
                count ++;
            }
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

