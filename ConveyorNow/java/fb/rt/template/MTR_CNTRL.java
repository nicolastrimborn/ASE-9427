/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK MTR_CNTRL (* Basic Function Block Type *)
  * @author JHC
  * @version 20190403/JHC - Generated.
  */
public class MTR_CNTRL extends fb.rt.FBInstance {
/** The index (0) of state START. */
public static final int INDEX_START = 0;
/** The index (1) of state INIT. */
public static final int INDEX_INIT = 1;
/** The index (2) of state REQ. */
public static final int INDEX_REQ = 2;
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** EVENT CNF */
public final EventOutput CNF = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** EVENT REQ */
public final EventServer REQ = (e) -> service_REQ();
/** VAR POS:UINT */
  public UINT POS = new UINT();
/** VAR STATE:BOOL */
  public BOOL STATE = new BOOL();
/** VAR FINAL_POS:INT */
  public INT FINAL_POS = new INT();
/** Output event qualifier */
  public final BOOL MTR = new BOOL();
/** The default constructor. */
public MTR_CNTRL(){
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
MTR.value=false;}
  /** ALGORITHM REQ IN ST*/
public void alg_REQ(){
if( STATE.value==true ){
	if( POS.value<FINAL_POS.value ){
		MTR.value=true;
	}else{
		MTR.value=false;
	}
}else{
	MTR.value=false;
}}
}
