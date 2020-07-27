package com.honeypeng;


import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by PengWX on 2020/7/27.
 */
public class mainTest {


    public static void main(String[] args) {
        String[] program = new String[]{"D:\\softs\\python\\python", "C:\\Users\\ftcs\\Desktop\\generatecode\\test_sum.py","23","211"};
        Process p;
        //利用CMD命令调用python，包含两个参数
        String cmd="python demo.py \"Hello\" \"World\"";
        try{
            p = Runtime.getRuntime().exec(cmd);
            InputStream fis=p.getInputStream();
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String line=null;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
//        PyObject number_sum = jPython2Java(11, 31, "C:\\Users\\ftcs\\Desktop\\generatecode\\test_sum.py", "adder");
//        System.out.println("计算得到的jpython求和:" + number_sum);
    }




    /*public static void python2Java(Integer param1, Integer param2, String[] program) {

        BufferedReader in = null;
        Process proc = null;
        try {
            proc = Runtime.getRuntime().exec(program);// 执行py文件

            in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "GBK"));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println(line);
            System.out.println("测试结束");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(in)) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(proc)) {
                proc.destroy();
            }
        }
    }*/

    public static PyObject jPython2Java(Integer param1, Integer param2, String pythonCodeFilePath, String methodName) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile(pythonCodeFilePath);

        // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
        PyFunction pyFunction = interpreter.get(methodName, PyFunction.class);
        //调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型”
        PyObject pyobj = pyFunction.__call__(new PyInteger(param1), new PyInteger(param2));
        return pyobj;
    }
}
