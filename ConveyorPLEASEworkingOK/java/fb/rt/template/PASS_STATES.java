/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK PASS_STATES (* Basic Function Block Type *)
  * @author JHC
  * @version 20190404/JHC - Generated.
  */
public class PASS_STATES extends fb.rt.FBInstance {
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
/** VAR COLOUR:UINT */
  public UINT COLOUR = new UINT();
/** Output event qualifier */
  public final WSTRING LOAD_STATE = new WSTRING();
/** VAR MTR_STATE:WSTRING */
  public final WSTRING MTR_STATE = new WSTRING();
/** The default constructor. */
public PASS_STATES(){
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
LOAD_STATE.value="";
MTR_STATE.value="";}
  /** ALGORITHM REQ IN ST*/
public void alg_REQ(){
if( COLOUR.value==1 ){
	LOAD_STATE.value="CNV5_LOAD_STATE";
	MTR_STATE.value="CNV5_STATE";
}
if( COLOUR.value==2 ){
	LOAD_STATE.value="CNV4_LOAD_STATE";
	MTR_STATE.value="CNV4_STATE";
}
if( COLOUR.value==3 ){
	LOAD_STATE.value="CNV3_LOAD_STATE";
	MTR_STATE.value="CNV3_STATE";
}}
}
