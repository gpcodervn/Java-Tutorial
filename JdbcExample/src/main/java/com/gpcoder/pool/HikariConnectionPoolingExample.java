package com.gpcoder.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;

import com.gpcoder.pool.thirdparties.HikariCPDataSource;

class HikariWorkerThread extends Thread {
	 
    private CountDownLatch latch;
    private String taskName;
 
    public HikariWorkerThread(CountDownLatch latch, String taskName) {
        this.latch = latch;
        this.taskName = taskName;
    }
 
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Starting. Task = " + taskName);
        execute();
		latch.countDown();
        System.out.println(Thread.currentThread().getName() + " Finished.");
    }
 
	private void execute() {
        try {
			String sqlSelect = "SELECT COUNT(*) AS total FROM user";
			try (Connection conn = HikariCPDataSource.getConnection();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(sqlSelect);) {
				Thread.sleep(2000);
	            rs.next();
				System.out.println("Task = " + taskName + ": Run SQL successfully " + rs.getInt("total"));
			}
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class HikariConnectionPoolingExample {
	
	private static final int NUMBER_OF_USERS = 8;

	public static void main(String[] args) throws SQLException, InterruptedException {
		final CountDownLatch latch = new CountDownLatch(NUMBER_OF_USERS);
		for (int i = 1; i <= NUMBER_OF_USERS; i++) {
            Thread worker = new HikariWorkerThread(latch, "" + i);
            worker.start();
        }
		latch.await();
		System.out.println("DONE All Tasks");
	}
}
