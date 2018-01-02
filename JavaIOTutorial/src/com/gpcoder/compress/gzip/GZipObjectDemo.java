package com.gpcoder.compress.gzip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;

public class GZipObjectDemo {
	public static String OUTPUT_FILE = "C:/demo/user.dat";
	
    public static void main(String[] args) {
        User admin = new User();
        admin.setId(1L);
        admin.setUsername("admin");
        admin.setPassword("secret");
        admin.setFirstName("System");
        admin.setLastName("Administrator");

        User foo = new User();
        foo.setId(2L);
        foo.setUsername("foo");
        foo.setPassword("secret");
        foo.setFirstName("Foo");
        foo.setLastName("Bar");

        System.out.println("Zipping....");
        System.out.println(admin);
        System.out.println(foo);
        try {
            FileOutputStream fos = new FileOutputStream(new File(OUTPUT_FILE));
            GZIPOutputStream gos = new GZIPOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(gos);

            oos.writeObject(admin);
            oos.writeObject(foo);

            oos.flush();
            oos.close();

            gos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
