/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK Controller (* Basic Function Block Type *)
  * @author JHC
  * @version 20190330/JHC - Generated.
  */
public class Controller extends fb.rt.FBInstance {
/** The index (0) of state START. */
public static final int INDEX_START = 0;
/** The index (1) of state INIT. */
public static final int INDEX_INIT = 1;
/** The index (2) of state CLK. */
public static final int INDEX_CLK = 2;
/** The index (3) of state ReleaseControl1. */
public static final int INDEX_ReleaseControl1 = 3;
/** The index (4) of state ToRed. */
public static final int INDEX_ToRed = 4;
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** EVENT RELEASECONTROL */
public final EventOutput RELEASECONTROL = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** Normal Execution Request */
public final EventServer CLK = (e) -> service_CLK();
/** VAR GREENTIME:UINT */
  public UINT GREENTIME = new UINT();
/** VAR MINGREENTIME:UINT */
  public UINT MINGREENTIME = new UINT();
/** VAR PEDCROSS:BOOL */
  public BOOL PEDCROSS = new BOOL();
/** VAR YELLOWTIME:UINT */
  public UINT YELLOWTIME = new UINT();
/** Output event qualifier */
  public final BOOL RED = new BOOL();
/** VAR YELLOW:BOOL */
  public final BOOL YELLOW = new BOOL();
/** VAR GREEN:BOOL */
  public final BOOL GREEN = new BOOL();
/** VAR GREENREMAINING:UINT */
  public final UINT GREENREMAINING = new UINT();
/** VAR Release:BOOL */
  public BOOL Release = new BOOL();
/** The default constructor. */
public Controller(){
    super();
  }
protected synchronized void service_INIT(){
  if(eccState == INDEX_START){
    state_INIT();
  }
}
protected synchronized void service_CLK(){
  if(eccState == INDEX_START){
    state_CLK();
  }
}
/** The actions to take upon entering state START. */
void state_START(){
   eccState = INDEX_START;
   if(RED.value)
     state_ToRed();
}
/** The actions to take upon entering state INIT. */
void state_INIT(){
   eccState = INDEX_INIT;
   alg_INIT();
   INITO.serviceEvent(this);
   state_START();
}
/** The actions to take upon entering state CLK. */
void state_CLK(){
   eccState = INDEX_CLK;
   alg_CLK();
   state_START();
}
/** The actions to take upon entering state ReleaseControl1. */
void state_ReleaseControl1(){
   eccState = INDEX_ReleaseControl1;
   alg_RELEASE();
   RELEASECONTROL.serviceEvent(this);
   state_START();
}
/** The actions to take upon entering state ToRed. */
void state_ToRed(){
   eccState = INDEX_ToRed;
   if(Release.value==False)
     state_ReleaseControl1();
   state_START();
}
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
RED.value=false;
YELLOW.value=false;
GREEN.value=false;}
  /** ALGORITHM CLK IN ST*/
public void alg_CLK(){
if( PEDCROSS.value && MINGREENTIME.value==0 ){
	YELLOW.value=true
    GREENTIME.value==0
ELSEIF(GREENTIME.value > 0) ){
	GREENTIME.value = GREENTIME.value - 1;
    MINGREENTIME.value= MINGREENTIME.value - 1;
}
GREENREMAINING.value == GREENTIME.value;
if( GREENTIME.value == 0 ){
	YELLOW.value = true
	if((YELLOW.value > 0) ){
		YELLOWTIME.value = YELLOWTIME.value - 1;
	ELSEIF YELLOWTIME.value == 0 ){
		RED.value=true
		Release.value=true
	}
}}
  /** ALGORITHM RELEASE IN ST*/
public void alg_RELEASE(){
Release.value=True;}
}
