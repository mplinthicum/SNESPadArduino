/**
 *  @file    SNESPad.h
 *  @author  Michael Linthicum
 *  @date    2016-05-07
 *  @brief	 Library for flashing SNES capability.
 */

#ifndef SNESPad_H
#define SNESPad_H

#include "Arduino.h"

#define BTN_B 0x01
#define BTN_Y 0x02
#define BTN_SELECT 0x04
#define BTN_START 0x08
#define BTN_UP 0x10
#define BTN_DOWN 0x20
#define BTN_LEFT 0x40
#define BTN_RIGHT 0x80
#define BTN_A 0x100
#define BTN_X 0x200
#define BTN_L 0x400
#define BTN_R 0x800

class SNESPad{
	public:
		SNESPad(unsigned int latch, unsigned int clock, unsigned int data);
		unsigned int get_buttons();
	private:
		unsigned int PIN_LATCH;
		unsigned int PIN_CLOCK;
		unsigned int PIN_DATA;
};

#endif