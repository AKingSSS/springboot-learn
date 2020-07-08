package com.aking.excel.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static void download(String fileName, String path, String url, String index) {
        HttpURLConnection conn;

        InputStream inputStream = null;
        BufferedInputStream bis = null;

        FileOutputStream out = null;
        try {
            File file = new File(path);
            if (!file.isDirectory() && !file.exists()) file.mkdirs();

            out = new FileOutputStream(file + index + fileName);

            URL httpUrl = new URL(url);
            conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.connect();

            inputStream = conn.getInputStream();
            bis = new BufferedInputStream(inputStream);

            byte b[] = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1) out.write(b, 0, len);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void zip(String zipFileName, String zipPath,String sourceFileName, String index) {
        try {
            File file = new File(zipPath);
            if (!file.isDirectory() && !file.exists()) file.mkdirs();

            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipPath + index + zipFileName));

            BufferedOutputStream bos = new BufferedOutputStream(out);

            File sourceFile = new File(sourceFileName);

            compress(out, bos, sourceFile, sourceFile.getName(), index);

            bos.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void compress(ZipOutputStream out, BufferedOutputStream bos, File sourceFile, String base, String index) throws Exception {
        if (sourceFile.isDirectory()) {
            File[] flist = sourceFile.listFiles();

            if (flist.length == 0) {
                out.putNextEntry(new ZipEntry(base + index));
            } else {
                for (int i = 0; i < flist.length; i++)
                    compress(out, bos, flist[i], base + index + flist[i].getName(), index);
            }
        } else {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream fos = new FileInputStream(sourceFile);
            BufferedInputStream bis = new BufferedInputStream(fos);

            int tag;

            while ((tag = bis.read()) != -1) {
                bos.write(tag);
            }
            bos.flush();
            bis.close();
            fos.close();

        }
    }

}
