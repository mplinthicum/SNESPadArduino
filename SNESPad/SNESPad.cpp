/**
 *  @file    SNESPad.cpp
 *  @author  Michael Linthicum
 *  @date    2016-05-07
 *  @brief   Library for implementing SNES pad capabilities.
 */

#include "Arduino.h"
#include "SNESPad.h"

/**
 *  @brief Sets pin input and output on Arduino
 *  
 *  @param latch Latch bit from SNES pad that must be ticked to save a button state
 *  @param clock Clock bit from SNES pad that must be ticked once to send a single bit of data
 *  @param data  Data bit from SNES pad that outputs serial data with SNES button state information
 *  
 *  @details 
 */
SNESPad::SNESPad(unsigned int latch, unsigned int clock, unsigned int data) {
	PIN_LATCH = latch;
	PIN_CLOCK = clock;
	PIN_DATA = data;
	
	pinMode(PIN_LATCH, OUTPUT);
	pinMode(PIN_CLOCK, OUTPUT);
	pinMode(PIN_DATA, INPUT);
}

/**
 *  @brief Gets a single button state of a SNES controller
 *  
 *  @details 
 */
unsigned int SNESPad::get_buttons() {
  unsigned int button_state = 0;

  digitalWrite(PIN_LATCH, HIGH);
  digitalWrite(PIN_LATCH, LOW);

  int i;
  for(i = 0; i < 12; i++){
    button_state |= digitalRead(PIN_DATA) << i;

    digitalWrite(PIN_CLOCK, HIGH);
    digitalWrite(PIN_CLOCK, LOW);
  }

  button_state = ~button_state;
  button_state &= 0x0fff;

  return button_state;
}