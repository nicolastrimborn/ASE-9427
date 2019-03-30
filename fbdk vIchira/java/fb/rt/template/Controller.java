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
/** The index (3) of state Red. */
public static final int INDEX_Red = 3;
/** The index (4) of state Release. */
public static final int INDEX_Release = 4;
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** EVENT CNF */
public final EventOutput CNF = new EventOutput();
/** EVENT RELEASEE */
public final EventOutput RELEASEE = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** Normal Execution Request */
public final EventServer CLK = (e) -> service_CLK();
/** EVENT LD */
public final EventServer LD = (e) -> {
  alg_LD();
  }
;
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
/** VAR MINGREENTIMEIN:UINT */
  public UINT MINGREENTIMEIN = new UINT();
/** VAR YELLOWTIMEIN:UINT */
  public UINT YELLOWTIMEIN = new UINT();
/** VAR GREENTIMEIN:UINT */
  public UINT GREENTIMEIN = new UINT();
/** VAR RELEASE:BOOL */
  public BOOL RELEASE = new BOOL();
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
  if((eccState == INDEX_START) && (RED.value==false)){
    state_CLK();
  }
  else if((eccState == INDEX_Red) && (RELEASE.value==false)){
    state_Release();
  }
  else if((eccState == INDEX_START) && (RED.value==true)){
    state_Red();
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
/** The actions to take upon entering state CLK. */
void state_CLK(){
   eccState = INDEX_CLK;
   alg_CLK();
   CNF.serviceEvent(this);
   state_START();
}
/** The actions to take upon entering state Red. */
void state_Red(){
   eccState = INDEX_Red;
   state_START();
}
/** The actions to take upon entering state Release. */
void state_Release(){
   eccState = INDEX_Release;
   alg_RELEASE();
   RELEASEE.serviceEvent(this);
   state_Red();
}
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
RED.value=false;
YELLOW.value=false;
GREEN.value=false;
MINGREENTIMEIN.value=100;
YELLOWTIMEIN.value=100;
GREENTIMEIN.value=100;
RELEASE.value=false;}
  /** ALGORITHM CLK IN ST*/
public void alg_CLK(){
if( PEDCROSS.value && MINGREENTIMEIN.value==0 ){
    GREEN.value=false;
	YELLOW.value=true;
    RED.value=false;
    GREENTIMEIN.value=0;
}
if( GREENTIMEIN.value>0 ){
	GREENTIMEIN.value = GREENTIMEIN.value - 1;
        MINGREENTIMEIN.value= MINGREENTIMEIN.value - 1;
}
GREENREMAINING.value=GREENTIMEIN.value;
if( GREENTIMEIN.value==0 ){
    GREEN.value=false;
	YELLOW.value= true;
    RED.value=false;
	if( YELLOWTIMEIN.value>0 ){
		YELLOWTIMEIN.value= YELLOWTIMEIN.value - 1;
	}
   if( YELLOWTIMEIN.value==0 ){
        GREEN.value=false;
        YELLOW.value=false;
		RED.value=true;
	}
}}
  /** ALGORITHM LD IN ST*/
public void alg_LD(){
MINGREENTIMEIN.value=MINGREENTIME.value;
YELLOWTIMEIN.value=YELLOWTIME.value;
GREEN.value=true;
GREENTIMEIN.value=GREENTIME.value;
GREENREMAINING.value=GREENTIME.value;
RELEASE.value=false;}
  /** ALGORITHM RELEASE IN ST*/
public void alg_RELEASE(){
RELEASE.value=true;}
}
