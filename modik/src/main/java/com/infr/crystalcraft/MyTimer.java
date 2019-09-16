package com.infr.crystalcraft;

public class MyTimer extends Thread {

	private long time;
	private MyTimerEvent e;
	
	public MyTimer(long time, MyTimerEvent e) {
		this.time = time;
		this.e = e;
		this.start();
		this.run();
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(time);
			e.run();
		}catch(Exception ex) {
	          ex.printStackTrace();
		}
	}
}