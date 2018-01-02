package com.gpcoder;

import java.io.FilePermission;
import java.io.IOException;
import java.security.PermissionCollection;

public class FilePermissionExample {

	public static void main(String[] args) throws IOException {

		String srg = "D:\\WorkSpace\\gpcoder\\JavaIOTutorial\\data\\java.txt";
		
		// cấp quyền cho path1
		FilePermission file1 = new FilePermission("D:\\WorkSpace\\gpcoder\\JavaIOTutorial\\data\\-", "read");
		PermissionCollection permission = file1.newPermissionCollection();
		permission.add(file1);
		
		// cấp quyền cho path2
		FilePermission file2 = new FilePermission(srg, "write");
		permission.add(file2);
		
		if (permission.implies(new FilePermission(srg, "read,write"))) {
			System.out.println("Read, Write permission is granted for the path " + srg);
		} else {
			System.out.println("No Read, Write permission is granted for the path " + srg);
		}
	}
}
