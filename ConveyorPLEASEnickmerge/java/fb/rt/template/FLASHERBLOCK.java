/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK FLASHERBLOCK (* Multi-purpose LED Flasher *)
  * @author JHC
  * @version 20190318/JHC - Generated.
  */
public class FLASHERBLOCK extends fb.rt.FBInstance {
/** The index (0) of state WAIT. */
public static final int INDEX_WAIT = 0;
/** The index (1) of state INIT. */
public static final int INDEX_INIT = 1;
/** The index (2) of state FLASH_ALL. */
public static final int INDEX_FLASH_ALL = 2;
/** The index (3) of state COUNT_UP. */
public static final int INDEX_COUNT_UP = 3;
/** The index (4) of state COUNT_DOWN. */
public static final int INDEX_COUNT_DOWN = 4;
/** The index (5) of state CHASE_UP. */
public static final int INDEX_CHASE_UP = 5;
/** The index (6) of state CHASE_DOWN. */
public static final int INDEX_CHASE_DOWN = 6;
/** The index (7) of state RESET_S. */
public static final int INDEX_RESET_S = 7;
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** Update Confirmation */
public final EventOutput CNF = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** Update Request */
public final EventServer REQ = (e) -> service_REQ();
/** EVENT RESET */
public final EventServer RESET = (e) -> service_RESET();
/** 0=FLASH_ALL,1=COUNT_UP,2=COUNT_DOWN,3=CHASE_UP,4=CHASE_DOWN */
  public UINT MODE = new UINT();
/** MSB */
  public final BOOL LED3 = new BOOL();
/** VAR LED2:BOOL */
  public final BOOL LED2 = new BOOL();
/** VAR LED1:BOOL */
  public final BOOL LED1 = new BOOL();
/** LSB */
  public final BOOL LED0 = new BOOL();
/** VAR OFLO:BOOL */
  public BOOL OFLO = new BOOL("true");
/** The default constructor. */
public FLASHERBLOCK(){
    super();
  }
protected synchronized void service_INIT(){
  if(eccState == INDEX_WAIT){
    state_INIT();
  }
}
protected synchronized void service_REQ(){
  if((eccState == INDEX_WAIT) && (MODE.value==0)){
    state_FLASH_ALL();
  }
  else if((eccState == INDEX_WAIT) && (MODE.value==1)){
    state_COUNT_UP();
  }
  else if((eccState == INDEX_WAIT) && (MODE.value==2)){
    state_COUNT_DOWN();
  }
  else if((eccState == INDEX_WAIT) && (MODE.value==3)){
    state_CHASE_UP();
  }
  else if((eccState == INDEX_WAIT) && (MODE.value==4)){
    state_CHASE_DOWN();
  }
}
protected synchronized void service_RESET(){
  if(eccState == INDEX_WAIT){
    state_RESET_S();
  }
}
/** The actions to take upon entering state WAIT. */
void state_WAIT(){
   eccState = INDEX_WAIT;
}
/** The actions to take upon entering state INIT. */
void state_INIT(){
   eccState = INDEX_INIT;
   alg_INIT();
   INITO.serviceEvent(this);
   state_WAIT();
}
/** The actions to take upon entering state FLASH_ALL. */
void state_FLASH_ALL(){
   eccState = INDEX_FLASH_ALL;
   alg_FLASH_ALL();
   CNF.serviceEvent(this);
   state_WAIT();
}
/** The actions to take upon entering state COUNT_UP. */
void state_COUNT_UP(){
   eccState = INDEX_COUNT_UP;
   alg_COUNT_UP();
   CNF.serviceEvent(this);
   state_WAIT();
}
/** The actions to take upon entering state COUNT_DOWN. */
void state_COUNT_DOWN(){
   eccState = INDEX_COUNT_DOWN;
   alg_COUNT_DOWN();
   CNF.serviceEvent(this);
   state_WAIT();
}
/** The actions to take upon entering state CHASE_UP. */
void state_CHASE_UP(){
   eccState = INDEX_CHASE_UP;
   alg_ChaseUPST();
   CNF.serviceEvent(this);
   state_WAIT();
}
/** The actions to take upon entering state CHASE_DOWN. */
void state_CHASE_DOWN(){
   eccState = INDEX_CHASE_DOWN;
   alg_ChaseDOWNST();
   CNF.serviceEvent(this);
   state_WAIT();
}
/** The actions to take upon entering state RESET_S. */
void state_RESET_S(){
   eccState = INDEX_RESET_S;
   alg_INIT();
   CNF.serviceEvent(this);
   state_WAIT();
}
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
LED0.value=false;
LED1.value=false;
LED2.value=false;
LED3.value=false;
OFLO.value=true;}
  /** ALGORITHM COUNT_UP IN ST*/
public void alg_COUNT_UP(){
LED0.value=! LED0.value;
if( ! LED0.value ){
LED1.value=! LED1.value;
if( ! LED1.value ){
LED2.value=! LED2.value;
if( ! LED2.value ){ LED3.value=! LED3.value;
}
}
}
}
  /** ALGORITHM COUNT_DOWN IN ST*/
public void alg_COUNT_DOWN(){
LED0.value=! LED0.value;
if( LED0.value ){
LED1.value=! LED1.value;
if( LED1.value ){
LED2.value=! LED2.value;
if( LED2.value ){ LED3.value=! LED3.value;
}
}
}
}
  /** ALGORITHM FLASH_ALL IN LD*/
public void alg_FLASH_ALL(){
  LED0.value = !(LED0.value);
  LED1.value = !(LED1.value);
  LED2.value = !(LED2.value);
  LED3.value = !(LED3.value);
}
  /** ALGORITHM ChaseUPST IN ST*/
public void alg_ChaseUPST(){
if( LED3.value ){
	OFLO.value=true;
	LED3.value=false;
}

if( LED2.value ){
	LED3.value=true;
	LED2.value=false;
}

if( LED1.value ){
	LED2.value=true;
	LED1.value=false;
}

if( LED0.value ){
	LED1.value=true;
	LED0.value=false;
}

if( OFLO.value ){
	LED0.value=true;
	OFLO.value=false;
}}
  /** ALGORITHM ChaseDOWNST IN ST*/
public void alg_ChaseDOWNST(){
if( LED0.value ){
	OFLO.value=true;
	LED0.value=false;
}

if( LED1.value ){
	LED0.value=true;
	LED1.value=false;
}

if( LED2.value ){
	LED1.value=true;
	LED2.value=false;
}

if( LED3.value ){
	LED2.value=true;
	LED3.value=false;
}

if( OFLO.value ){
	LED3.value=true;
	OFLO.value=false;
}}
}
