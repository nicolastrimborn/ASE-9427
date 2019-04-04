/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK FlashControl (* Flash Control Block Type *)
  * @author JHC
  * @version 20190313/JHC - Generated.
  */
public class FlashControl extends fb.rt.FBInstance {
/** The index (0) of state START. */
public static final int INDEX_START = 0;
/** The index (1) of state INIT. */
public static final int INDEX_INIT = 1;
/** The index (2) of state REQ. */
public static final int INDEX_REQ = 2;
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** Execution Confirmation */
public final EventOutput CNF = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** Normal Execution Request */
public final EventServer REQ = (e) -> service_REQ();
/** VAR MODE:UINT */
  public UINT MODE = new UINT();
/** VAR LED3:BOOL */
  public final BOOL LED3 = new BOOL();
/** VAR LED2:BOOL */
  public final BOOL LED2 = new BOOL();
/** VAR LED1:BOOL */
  public final BOOL LED1 = new BOOL();
/** VAR LED0:BOOL */
  public final BOOL LED0 = new BOOL();
/** The default constructor. */
public FlashControl(){
    super();
  }
protected synchronized void service_INIT(){
  if(eccState == INDEX_START){
    state_INIT();
  }
}
protected synchronized void service_REQ(){
  if(eccState == INDEX_START){
    state_REQ();
  }
}
/** The actions to take upon entering state START. */
void state_START(){
   eccState = INDEX_START;
}
/** The actions to take upon entering state INIT. */
void state_INIT(){
   eccState = INDEX_INIT;
   alg_INIT();
   INITO.serviceEvent(this);
   state_START();
}
/** The actions to take upon entering state REQ. */
void state_REQ(){
   eccState = INDEX_REQ;
   alg_REQ();
   CNF.serviceEvent(this);
   state_START();
}
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
if( MODE.value==1 ){
	LED0.value=false;
	LED1.value=false;
	LED2.value=false;
    LED3.value=false;
}}
  /** ALGORITHM REQ IN ST*/
public void alg_REQ(){
LED0.value=! LED0.value;
LED1.value=! LED1.value;
LED2.value=! LED2.value;
LED3.value=! LED3.value;}
}
