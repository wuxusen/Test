package com.wxs.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-31
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class Sn {

    public static String executeLinuxCmd(String cmd) {
        try {
            Runtime run = Runtime.getRuntime();
            Process process;
            process = run.exec(cmd);
            InputStream in = process.getInputStream();
            BufferedReader bs = new BufferedReader(new InputStreamReader(in));
            StringBuffer out = new StringBuffer();
            byte[] b = new byte[8192];
            for (int n; (n = in.read(b)) != -1; ) {
                out.append(new String(b, 0, n));
            }

            in.close();
            process.destroy();
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getSerialNumber(String cmd, String record, String symbol) {
        String execResult = executeLinuxCmd(cmd);
        if(execResult == null){
            return null;
        }
        String[] infos = execResult.split("\n");

        for (String info : infos) {
            info = info.trim();
            if (info.indexOf(record) != -1) {
                info.replace(" ", "");
                String[] sn = info.split(symbol);
                return sn[1];
            }
        }

        return null;
    }



    public static void main(String[] args) {



        String cpuidLinux = getSerialNumber("dmidecode -t processor | grep 'systemd'", "ID", ":");

        String stt = "cat /proc/self/cgroup | grep 'docker' | sed 's/^.*\\///'";
        System.out.println(stt);
        String str = executeLinuxCmd(stt);



        String[] keys = str.split("\n");

        String key = null;
        for (int i = 0; i < keys.length; i++) {
            if(keys[i] != null){
                key = keys[i];
                break;
            }

        }
        System.out.println(key);
    }
}
