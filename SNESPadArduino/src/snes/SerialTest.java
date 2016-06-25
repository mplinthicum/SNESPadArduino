package snes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import gnu.io.CommPortIdentifier; 
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener;

public class SerialTest implements SerialPortEventListener {
	
	SerialPort serialPort;
	
	private static final String PORT_NAME = "COM3";
	private static final int TIME_OUT = 2000;
	private static final int DATA_RATE = 9600;
	
	private BufferedReader input;

	public void initialize() {

		CommPortIdentifier portId = null;
		
		try {
			portId = CommPortIdentifier.getPortIdentifier(PORT_NAME);
		} catch (NoSuchPortException nse) {
			System.err.println("Could not find COM port: " + nse.toString());
		}

		try {
			serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));

			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	/**
	 * Handle an event on the serial port. Read the data and print it.
	 */
	public synchronized void serialEvent(SerialPortEvent event) {
		if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine = input.readLine();
				System.out.println(inputLine);
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		SerialTest main = new SerialTest();
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
		System.out.println("Begin...");
	}
}
