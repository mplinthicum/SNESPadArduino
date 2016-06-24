# SNESPadArduino
Code used to interface between a SNES controller and an Arduino Uno, and the Arduino Uno and the PC.  Arduino gets SNES serial input, and a Java program translates that to keystrokes.

##SNES Controller Pins

The following is a representation of the SNES pad's pin configuration and their functionality.

	  1 2 3 4   5 6 7
	< o o o o | o o o >
	
	1) +5V
	2) Clock
	3) Latch
	4) Data
	7) GND

##Pin Configuration Function
	
	pin_config(latch, clock, data);

##Serial output
	This program prints a capital verison of the button to serial when the button is pressed (UP) and a
	lowercase version of the button when it is released (up).

