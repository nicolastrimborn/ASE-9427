/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.test;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK STOPGO (* ECC with no Transient ECC State *)
  * @author JHC
  * @version 20190330/JHC - Generated.
  */
public class STOPGO extends fb.rt.FBInstance {
/** The index (0) of state START. */
public static final int INDEX_START = 0;
/** The index (1) of state INIT. */
public static final int INDEX_INIT = 1;
/** The index (2) of state GO. */
public static final int INDEX_GO = 2;
/** The index (3) of state STOP. */
public static final int INDEX_STOP = 3;
/** The index (4) of state CLK. */
public static final int INDEX_CLK = 4;
/** The index (5) of state RELEASED. */
public static final int INDEX_RELEASED = 5;
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** EVENT PASSCONTROL */
public final EventOutput PASSCONTROL = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** Normal Execution Request */
public final EventServer GO = (e) -> service_GO();
/** EVENT STOP */
public final EventServer STOP = (e) -> service_STOP();
/** EVENT CLK */
public final EventServer CLK = (e) -> service_CLK();
/** EVENT LD */
public final EventServer LD = (e) -> {
  alg_LD();
  }
;
/** Input event qualifier */
  public UINT YELLOWTIME = new UINT();
/** Output event qualifier */
  public final BOOL RED = new BOOL();
/** VAR YELLOW:BOOL */
  public final BOOL YELLOW = new BOOL();
/** VAR GREEN:BOOL */
  public final BOOL GREEN = new BOOL();
/** VAR YELLOWCVV:UINT */
  public final UINT YELLOWCVV = new UINT();
/** VAR RELEASE:BOOL */
  public final BOOL RELEASE = new BOOL();
/** VAR YELLOWDONE:BOOL */
  public BOOL YELLOWDONE = new BOOL();
/** VAR STOPREQUESTED:BOOL */
  public BOOL STOPREQUESTED = new BOOL();
/** The default constructor. */
public STOPGO(){
    super();
  }
protected synchronized void service_INIT(){
  if(eccState == INDEX_START){
    state_INIT();
  }
}
protected synchronized void service_GO(){
  if(eccState == INDEX_START){
    state_GO();
  }
}
protected synchronized void service_STOP(){
  if((eccState == INDEX_START) && (STOPREQUESTED.value == false)){
    state_STOP();
  }
}
protected synchronized void service_CLK(){
  if((eccState == INDEX_START) && (STOPREQUESTED.value == true)){
    state_CLK();
  }
}
/** The actions to take upon entering state START. */
void state_START(){
   eccState = INDEX_START;
   if(RELEASE.value == true)
     state_RELEASED();
}
/** The actions to take upon entering state INIT. */
void state_INIT(){
   eccState = INDEX_INIT;
   alg_INIT();
   INITO.serviceEvent(this);
   state_START();
}
/** The actions to take upon entering state GO. */
void state_GO(){
   eccState = INDEX_GO;
   alg_GO();
   state_START();
}
/** The actions to take upon entering state STOP. */
void state_STOP(){
   eccState = INDEX_STOP;
   alg_STOPREQ();
   state_START();
}
/** The actions to take upon entering state CLK. */
void state_CLK(){
   eccState = INDEX_CLK;
   alg_CD();
   state_START();
}
/** The actions to take upon entering state RELEASED. */
void state_RELEASED(){
   eccState = INDEX_RELEASED;
   alg_Release();
   PASSCONTROL.serviceEvent(this);
   state_START();
}
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
RED.value=false;
YELLOW.value=false;
GREEN.value=false;
YELLOWDONE.value=false;
STOPREQUESTED.value=false;
RELEASE.value=false;}
  /** ALGORITHM GO IN ST*/
public void alg_GO(){
GREEN.value=true;
YELLOW.value=false;
RED.value=false;
YELLOWCVV.value=YELLOWTIME.value;
STOPREQUESTED.value=false;
RELEASE.value=false;}
  /** ALGORITHM CD IN ST*/
public void alg_CD(){
if( YELLOWCVV.value > 0 ){
	YELLOWCVV.value= YELLOWCVV.value - 1;
}
if( YELLOWCVV.value == 0 ){
	YELLOWDONE.value = true;
	RED.value=true;
	YELLOW.value=false;
	GREEN.value=false;
	RELEASE.value=true;
	STOPREQUESTED.value=false;
}}
  /** ALGORITHM STOPREQ IN ST*/
public void alg_STOPREQ(){
YELLOW.value=true;
RED.value=false;
GREEN.value=false;
STOPREQUESTED.value= true;
RELEASE.value=false;}
  /** ALGORITHM LD IN ST*/
public void alg_LD(){
YELLOWCVV.value = YELLOWTIME.value;}
  /** ALGORITHM Release IN ST*/
public void alg_Release(){
RELEASE.value=false;}
}
