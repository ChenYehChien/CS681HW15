package edu.umb.cs681.hw15;

public class hw15 {
	public static void main(String[] args) {
		AdmissionControl a = new AdmissionControl();
		
		EntranceHandler en = new EntranceHandler(a);
		ExitHandler ex = new ExitHandler(a);
		MonitorHandler m = new MonitorHandler(a);
		
		Thread t_en = new Thread(en);
		Thread t_ex = new Thread(ex);
		Thread t_m = new Thread(m);
		
		t_en.start();
		t_ex.start();
		t_m.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		en.setDone();
		ex.setDone();
		m.setDone();
		
		t_en.interrupt();
		t_ex.interrupt();
		t_m.interrupt();
		
		try {
			t_en.join();
			t_ex.join();
			t_m.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}