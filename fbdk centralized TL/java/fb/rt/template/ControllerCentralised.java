/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK ControllerCentralised (* Basic Function Block Type *)
  * @author JHC
  * @version 20190401/JHC - Generated.
  */
public class ControllerCentralised extends fb.rt.FBInstance {
/** The index (0) of state START. */
public static final int INDEX_START = 0;
/** The index (1) of state INIT. */
public static final int INDEX_INIT = 1;
/** The index (2) of state CLK. */
public static final int INDEX_CLK = 2;
/** The index (3) of state LD. */
public static final int INDEX_LD = 3;
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** EVENT CNF */
public final EventOutput CNF = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** Normal Execution Request */
public final EventServer CLK = (e) -> service_CLK();
/** EVENT LD */
public final EventServer LD = (e) -> service_LD();
/** VAR GREENTIME:UINT */
  public UINT GREENTIME = new UINT();
/** VAR YELLOWTIME:UINT */
  public UINT YELLOWTIME = new UINT();
/** Output event qualifier */
  public final BOOL RED1 = new BOOL();
/** VAR YELLOW1:BOOL */
  public final BOOL YELLOW1 = new BOOL();
/** VAR GREEN1:BOOL */
  public final BOOL GREEN1 = new BOOL();
/** VAR RT1:UINT */
  public final UINT RT1 = new UINT();
/** VAR RELEASE:BOOL */
  public final BOOL RELEASE = new BOOL();
/** VAR RED2:BOOL */
  public final BOOL RED2 = new BOOL();
/** VAR YELLOW2:BOOL */
  public final BOOL YELLOW2 = new BOOL();
/** VAR GREEN2:BOOL */
  public final BOOL GREEN2 = new BOOL();
/** VAR RT2:UINT */
  public final UINT RT2 = new UINT();
/** VAR YELLOWTIMEIN:UINT */
  public UINT YELLOWTIMEIN = new UINT();
/** VAR GREENTIMEIN:UINT */
  public UINT GREENTIMEIN = new UINT();
/** VAR GREENTIME1CV:UINT */
  public UINT GREENTIME1CV = new UINT();
/** VAR GREENTIME2CV:UINT */
  public UINT GREENTIME2CV = new UINT();
/** VAR YELLOWTIME1CV:UINT */
  public UINT YELLOWTIME1CV = new UINT();
/** VAR YELLOWTIME2CV:UINT */
  public UINT YELLOWTIME2CV = new UINT();
/** The default constructor. */
public ControllerCentralised(){
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
protected synchronized void service_LD(){
  if(eccState == INDEX_START){
    state_LD();
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
/** The actions to take upon entering state LD. */
void state_LD(){
   eccState = INDEX_LD;
   alg_LD();
   CNF.serviceEvent(this);
   state_START();
}
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
RED1.value=false;
YELLOW1.value=false;
GREEN1.value=false;
RED2.value=false;
YELLOW2.value=false;
GREEN2.value=false;
YELLOWTIMEIN.value=100;
GREENTIMEIN.value=100;
RELEASE.value=false;}
  /** ALGORITHM CLK IN ST*/
public void alg_CLK(){
if( RELEASE.value == false ){
	if( GREENTIME1CV.value > 0 ){
		GREENTIME1CV.value = GREENTIME1CV.value - 1;
		GREEN1.value=true;
		YELLOW1.value= false;
		RED1.value=false;
		GREEN2.value=false;
		YELLOW2.value= false;
		RED2.value=true;
		RT1.value=GREENTIME1CV.value;
	}
	
	if(  GREENTIME1CV.value==0 ){
		GREEN1.value=false;
		YELLOW1.value= true;
		RED1.value=false;
		GREEN2.value=false;
		YELLOW2.value= false;
		RED2.value=true;

		if( YELLOWTIME1CV.value>0 ){
			YELLOWTIME1CV.value= YELLOWTIME1CV.value - 1;
			RT1.value=YELLOWTIME1CV.value;
		}
	}
	if( YELLOWTIME1CV.value==0 ){
		GREEN1.value=false;
		YELLOW1.value=false;
		RED1.value=true;
		GREEN2.value=true;
		YELLOW2.value=false;
		RED2.value=false;
		RELEASE.value=true;
		RT1.value=0;
		RT2.value=GREENTIMEIN.value;
		GREENTIME1CV.value= GREENTIMEIN.value;
		YELLOWTIME1CV.value=  YELLOWTIME.value;
	}
}

if( RELEASE.value == true ){
	if( GREENTIME2CV.value > 0 ){
		GREENTIME2CV.value = GREENTIME2CV.value - 1;
		GREEN1.value=false;
		YELLOW1.value= false;
		RED1.value=true;
		GREEN2.value=true;
		YELLOW2.value= false;
		RED2.value=false;
		RT1.value=GREENTIMEIN.value;
		RT2.value=GREENTIME2CV.value;
	}
	if( GREENTIME2CV.value==0 ){
		GREEN1.value=false;
		YELLOW1.value= false;
		RED1.value=true;
		GREEN2.value=false;
		YELLOW2.value= true;
		RED2.value=false;

		if( YELLOWTIME2CV.value>0 ){
			YELLOWTIME2CV.value= YELLOWTIME2CV.value - 1;
		    RT2.value=YELLOWTIME2CV.value;
		}
	}
	if( YELLOWTIME2CV.value==0 ){
		GREEN1.value=true;
		YELLOW1.value=false;
		RED1.value=false;
		RELEASE.value=false;
		RT1.value=GREENTIMEIN.value;
		RT2.value=0;
		GREENTIME2CV.value= GREENTIMEIN.value;
		YELLOWTIME2CV.value=  YELLOWTIME.value;
	}
}}
  /** ALGORITHM LD IN ST*/
public void alg_LD(){
GREEN1.value=true;
YELLOW1.value=false;
RED1.value=false;
GREEN2.value=false;
YELLOW2.value=false;
RED2.value=false;

YELLOWTIMEIN.value=YELLOWTIME.value+1;
GREENTIMEIN.value=GREENTIME.value;

RT1.value=GREENTIME.value;
RT2.value= 0;
GREENTIME1CV.value=GREENTIME.value;
GREENTIME2CV.value=GREENTIME.value;
YELLOWTIME1CV.value=YELLOWTIME.value+1;
YELLOWTIME2CV.value=YELLOWTIME.value+1;}
}
