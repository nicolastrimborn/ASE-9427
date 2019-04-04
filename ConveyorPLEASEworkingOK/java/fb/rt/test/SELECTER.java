/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.test;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK SELECTER (* Multi-purpose LED Flasher *)
  * @author JHC
  * @version 20190331/JHC - Generated.
  */
public class SELECTER extends fb.rt.FBInstance {
/** The index (0) of state WAIT. */
public static final int INDEX_WAIT = 0;
/** The index (1) of state INIT. */
public static final int INDEX_INIT = 1;
/** The index (2) of state RED. */
public static final int INDEX_RED = 2;
/** The index (3) of state YELLOW. */
public static final int INDEX_YELLOW = 3;
/** The index (4) of state BLUE. */
public static final int INDEX_BLUE = 4;
/** The index (5) of state RESET_S. */
public static final int INDEX_RESET_S = 5;
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
/** VAR RED:BOOL */
  public final BOOL RED = new BOOL();
/** VAR YELLOW:BOOL */
  public final BOOL YELLOW = new BOOL();
/** VAR BLUE:BOOL */
  public final BOOL BLUE = new BOOL();
/** The default constructor. */
public SELECTER(){
    super();
  }
protected synchronized void service_INIT(){
  if(eccState == INDEX_WAIT){
    state_INIT();
  }
}
protected synchronized void service_REQ(){
  if((eccState == INDEX_WAIT) && (MODE.value==1)){
    state_RED();
  }
  else if((eccState == INDEX_WAIT) && (MODE.value==2)){
    state_YELLOW();
  }
  else if((eccState == INDEX_WAIT) && (MODE.value==3)){
    state_BLUE();
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
/** The actions to take upon entering state RED. */
void state_RED(){
   eccState = INDEX_RED;
   alg_RED();
   CNF.serviceEvent(this);
   state_WAIT();
}
/** The actions to take upon entering state YELLOW. */
void state_YELLOW(){
   eccState = INDEX_YELLOW;
   alg_YELLOW();
   CNF.serviceEvent(this);
   state_WAIT();
}
/** The actions to take upon entering state BLUE. */
void state_BLUE(){
   eccState = INDEX_BLUE;
   alg_BLUE();
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
RED.value=false;
YELLOW.value=false;
BLUE.value=false;}
  /** ALGORITHM RED IN ST*/
public void alg_RED(){
RED.value=true;}
  /** ALGORITHM YELLOW IN ST*/
public void alg_YELLOW(){
YELLOW.value=true;}
  /** ALGORITHM BLUE IN ST*/
public void alg_BLUE(){
BLUE.value=true;}
}
