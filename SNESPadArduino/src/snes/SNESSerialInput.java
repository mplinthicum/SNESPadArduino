package snes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import gnu.io.CommPortIdentifier; 
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class SNESSerialInput implements SerialPortEventListener {
	
	SerialPort serialPort;
	Robot robot;
	
	private static final String PORT_NAME = "COM3";
	private static final int TIME_OUT = 2000;
	private static final int DATA_RATE = 9600;
	
	private BufferedReader input;

	private void initialize() {
		
		CommPortIdentifier portId = null;
		
		try {
			portId = CommPortIdentifier.getPortIdentifier(PORT_NAME);
		} catch (NoSuchPortException nse) {
			System.err.println(nse.toString());
		}

		try {
			serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
			robot = new Robot();

			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));

			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	/**
	 * Handle an event on the serial port, read the button state, and 
	 * translate it to a keystroke.
	 */
	public synchronized void serialEvent(SerialPortEvent event) {
		if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String snesInput = input.readLine();
				buttonCaptureToKeyPress(snesInput);
			} catch (IOException ie) {
				System.err.println(ie.toString());
			}
		}
	}
	
	private void buttonCaptureToKeyPress(String snesInput) {
		switch (snesInput) {
		case "A":
			robot.keyPress(KeyEvent.VK_A);
			break;
		case "a":
			robot.keyRelease(KeyEvent.VK_A);
			break;
		case "B":
			robot.keyPress(KeyEvent.VK_B);
			break;
		case "b":
			robot.keyRelease(KeyEvent.VK_B);
			break;
		case "X":
			robot.keyPress(KeyEvent.VK_X);
			break;
		case "x":
			robot.keyRelease(KeyEvent.VK_X);
			break;
		case "Y":
			robot.keyPress(KeyEvent.VK_Y);
			break;
		case "y":
			robot.keyRelease(KeyEvent.VK_Y);
			break;
		case "UP":
			robot.keyPress(KeyEvent.VK_UP);
			break;
		case "up":
			robot.keyRelease(KeyEvent.VK_UP);
			break;
		case "DOWN":
			robot.keyPress(KeyEvent.VK_DOWN);
			break;
		case "down":
			robot.keyRelease(KeyEvent.VK_DOWN);
			break;
		case "LEFT":
			robot.keyPress(KeyEvent.VK_LEFT);
			break;
		case "left":
			robot.keyRelease(KeyEvent.VK_LEFT);
			break;
		case "RIGHT":
			robot.keyPress(KeyEvent.VK_RIGHT);
			break;
		case "right":
			robot.keyRelease(KeyEvent.VK_RIGHT);
			break;
		case "R":
			robot.keyPress(KeyEvent.VK_R);
			break;
		case "r":
			robot.keyRelease(KeyEvent.VK_R);
			break;
		case "L":
			robot.keyPress(KeyEvent.VK_L);
			break;
		case "l":
			robot.keyRelease(KeyEvent.VK_L);
			break;
		case "START":
			robot.keyPress(KeyEvent.VK_S);
			break;
		case "start":
			robot.keyRelease(KeyEvent.VK_S);
			break;
		case "SELECT":
			robot.keyPress(KeyEvent.VK_D);
			break;
		case "select":
			robot.keyRelease(KeyEvent.VK_D);
			break;
		default: 
			System.out.println("Invalid Button Press");
		}
	}

	public static void main(String[] args) throws Exception {
		SNESSerialInput main = new SNESSerialInput();
		main.initialize();
		
		
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(1000000);
				} catch (InterruptedException ie) {
					System.err.println(ie.toString());
				}
			}
		};
		
		t.start();
		System.out.println("Press your buttons...");
	}
}
