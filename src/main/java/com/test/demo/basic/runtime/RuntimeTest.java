package com.test.demo.basic.runtime;

import java.io.*;

/**
 * <p>
 *
 * </p>
 *
 * @package: train.basic.runtime
 * @description:
 * @author: chengqj
 * @date: Created in 2021/4/18 23:03
 * @copyright: Copyright (c) 2021
 * @version: V1.0
 * @modified:
 */
public class RuntimeTest {
    public static void main(String[] args) throws IOException, InterruptedException {
//        executive("dir");

        aaa("dir");
    }

    //一般的执行方法，有时执行exe会卡在那  stmt要执行的命令
    public static void executive(String stmt) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime(); //获取Runtime实例
        //执行命令
        try {
            String[] command = {"cmd", "/c", stmt}; // 注意这里执行命令的方式
            Process process = runtime.exec(command);
            // 标准输入流（必须写在 waitFor 之前）
            String inStr = consumeInputStream(process.getInputStream());
            // 标准错误流（必须写在 waitFor 之前）
            String errStr = consumeInputStream(process.getErrorStream());
            int proc = process.waitFor();
            InputStream errorStream = process.getErrorStream(); // 若有错误信息则输出
            if (proc == 0) {
                System.out.println("执行成功");
            } else {
                System.out.println("执行失败" + errStr);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String consumeInputStream(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "GBK"));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            System.out.println(s);
            sb.append(s);
        }
        return sb.toString();
    }


    //这个方法比第一个好，执行时不会卡 stmt要执行的命令
    public static void aaa(String stam) {
        BufferedReader br = null;
        try {
            File file = new File("D:\\daemonTmp");
            File tmpFile = new File("D:\\daemonTmp\\temp.tmp");//新建一个用来存储结果的缓存文件
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!tmpFile.exists()) {
                tmpFile.createNewFile();
            }
            ProcessBuilder pb = new ProcessBuilder().command("cmd.exe", "/c", stam).inheritIO();
            pb.redirectErrorStream(true);//这里是把控制台中的红字变成了黑字，用通常的方法其实获取不到，控制台的结果是pb.start()方法内部输出的。
            pb.redirectOutput(tmpFile);//把执行结果输出。
            pb.start().waitFor();//等待语句执行完成，否则可能会读不到结果。
            InputStream in = new FileInputStream(tmpFile);
            br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            br = null;
            tmpFile.delete();//卸磨杀驴。
            System.out.println("执行完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
