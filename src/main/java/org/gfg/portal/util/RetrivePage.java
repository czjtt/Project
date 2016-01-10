package org.gfg.portal.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Created by czj on 2015-11-24.
 */
public class RetrivePage {
    private static HttpClient httpClient = new HttpClient();
    static GetMethod getmethod;

    /**
     * 测试代码
     */
    public static void main(String[] args) {
// 抓取制指定网页，并将其输出
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Input the URL of the page you want to get:");
            String path = in.next();
            System.out.println("program start!");
            RetrivePage.downloadPage(path);
            System.out.println("Program end!");
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean downloadPage(String path) throws IOException {
        getmethod = new GetMethod(path);
//获得响应状态码
        int statusCode = httpClient.executeMethod(getmethod);
        if (statusCode == HttpStatus.SC_OK) {
            System.out.println("response=" + getmethod.getResponseBodyAsString());
//写入本地文件
            FileWriter fwrite = new FileWriter("hello.txt");
            String pageString = getmethod.getResponseBodyAsString();
            getmethod.releaseConnection();
//            fwrite.write(pageString, 0, pageString.length());

            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("outputfile/hello.txt"),"utf-8");
            out.write(pageString,0,pageString.length());
            out.flush();
            out.close();

            fwrite.flush();
//关闭文件
            fwrite.close();
//释放资源
            return true;
        }
        return false;
    }
}