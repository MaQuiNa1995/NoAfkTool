package es.maquina.no.afk;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class Main {
	public static void main(String[] args) {
		crearHilo().run();
	}

	private static Runnable crearHilo() {
		Runnable hilo = (() -> {

			Robot robot = null;

			try {
				robot = new Robot();
			} catch (AWTException e) {
				System.exit(-1);
			}

			do {

				Point posicionRaton = MouseInfo.getPointerInfo().getLocation();

				int x = posicionRaton.x + 1;
				int y = posicionRaton.y + 1;

				robot.mouseMove(x, y);

				try {
					Thread.currentThread().sleep(180 * 1000);
				} catch (InterruptedException e) {
				}

			} while (Boolean.TRUE);

		});

		return new Thread(hilo);
	}
}
