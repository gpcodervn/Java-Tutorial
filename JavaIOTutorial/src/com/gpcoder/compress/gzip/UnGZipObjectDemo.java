package com.gpcoder.compress.gzip;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.zip.GZIPInputStream;

public class UnGZipObjectDemo {
	
	public static String OUTPUT_FILE = "C:/demo/user.dat";
	
    public static void main(String[] args) {
        User admin = null;
        User foo = null;

        try {
            FileInputStream fis = new FileInputStream(new File(OUTPUT_FILE));
            GZIPInputStream gis = new GZIPInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(gis);

            admin = (User) ois.readObject();
            foo = (User) ois.readObject();

            ois.close();
            gis.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(admin);
        System.out.println(foo);
    }
}