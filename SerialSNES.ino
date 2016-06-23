#include <SNESPad.h>

SNESPad pad(3, 2, 4);

boolean pressed_b = false;
boolean pressed_y = false;
boolean pressed_select = false;
boolean pressed_start = false;
boolean pressed_up = false;
boolean pressed_down = false;
boolean pressed_left = false;
boolean pressed_right = false;
boolean pressed_a = false;
boolean pressed_x = false;
boolean pressed_l = false;
boolean pressed_r = false;

void setup(){
  Serial.begin(9600);
}

void loop(){
  unsigned int state;
  state = pad.get_buttons();

  if(state & BTN_X && pressed_x == false){
    pressed_x = true;
    Serial.println("X");
  }
  if(pressed_x == true && !(state & BTN_X)){
    pressed_x = false;
    Serial.println("x");
  }

  if(state & BTN_Y && pressed_y == false){
    pressed_y = true;
    Serial.println("Y");
  }
  if(pressed_y == true && !(state & BTN_Y)){
    pressed_y = false;
    Serial.println("y");
  }

  if(state & BTN_A && pressed_a == false){
    pressed_a = true;
    Serial.println("A");
  }
  if(pressed_a == true && !(state & BTN_A)){
    pressed_a = false;
    Serial.println("a");
  }

  if(state & BTN_B && pressed_b == false){
    pressed_b = true;
    Serial.println("B");
  }
  if(pressed_b == true && !(state & BTN_B)){
    pressed_b = false;
    Serial.println("b");
  }

  if(state & BTN_R && pressed_r == false){
    pressed_r = true;
    Serial.println("R");
  }
  if(pressed_r == true && !(state & BTN_R)){
    pressed_r = false;
    Serial.println("r");
  }

  if(state & BTN_L && pressed_l == false){
    pressed_l = true;
    Serial.println("L");
  }
  if(pressed_l == true && !(state & BTN_L)){
    pressed_l = false;
    Serial.println("l");
  }

  if(state & BTN_SELECT && pressed_select == false){
    pressed_select = true;
    Serial.println("SELECT");
  }
  if(pressed_select == true && !(state & BTN_SELECT)){
    pressed_select = false;
    Serial.println("select");
  }

  if(state & BTN_START && pressed_start == false){
    pressed_start = true;
    Serial.println("START");
  }
  if(pressed_start == true && !(state & BTN_START)){
    pressed_start = false;
    Serial.println("start");
  }

  if(state & BTN_UP && pressed_up == false){
    pressed_up = true;
    Serial.println("UP");
  }
  if(pressed_up == true && !(state & BTN_UP)){
    pressed_up = false;
    Serial.println("up");
  }

  if(state & BTN_DOWN && pressed_down == false){
    pressed_down = true;
    Serial.println("DOWN");
  }
  if(pressed_down == true && !(state & BTN_DOWN)){
    pressed_down = false;
    Serial.println("down");
  }

  if(state & BTN_LEFT && pressed_left == false){
    pressed_left = true;
    Serial.println("LEFT");
  }
  if(pressed_left == true && !(state & BTN_LEFT)){
    pressed_left = false;
    Serial.println("left");
  }

  if(state & BTN_RIGHT && pressed_right == false){
    pressed_right = true;
    Serial.println("RIGHT");
  }
  if(pressed_right == true && !(state & BTN_RIGHT)){
    pressed_right = false;
    Serial.println("right");
  }
}


