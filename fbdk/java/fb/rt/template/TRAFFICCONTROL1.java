/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK TRAFFICCONTROL1 (* Basic Function Block Type *)
  * @author JHC
  * @version 20190319/JHC - Generated.
  */
public class TRAFFICCONTROL1 extends fb.rt.FBInstance {
/** The index (0) of state START. */
public static final int INDEX_START = 0;
/** The index (1) of state INIT. */
public static final int INDEX_INIT = 1;
/** The index (2) of state T0. */
public static final int INDEX_T0 = 2;
/** The index (3) of state T1. */
public static final int INDEX_T1 = 3;
/** The index (4) of state T2. */
public static final int INDEX_T2 = 4;
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** Execution Confirmation */
public final EventOutput CNF = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** EVENT T0 */
public final EventServer T0 = (e) -> service_T0();
/** EVENT T1 */
public final EventServer T1 = (e) -> service_T1();
/** EVENT T2 */
public final EventServer T2 = (e) -> service_T2();
/** Output event qualifier */
  public final BOOL RED = new BOOL();
/** VAR YELLOW:BOOL */
  public final BOOL YELLOW = new BOOL();
/** VAR GREEN:BOOL */
  public final BOOL GREEN = new BOOL();
/** VAR Release:BOOL */
  public final BOOL Release = new BOOL();
/** The default constructor. */
public TRAFFICCONTROL1(){
    super();
  }
protected synchronized void service_INIT(){
  if(eccState == INDEX_START){
    state_INIT();
  }
}
protected synchronized void service_T0(){
  if(eccState == INDEX_START){
    state_T0();
  }
}
protected synchronized void service_T1(){
  if(eccState == INDEX_START){
    state_T1();
  }
}
protected synchronized void service_T2(){
  if(eccState == INDEX_START){
    state_T2();
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
/** The actions to take upon entering state T0. */
void state_T0(){
   eccState = INDEX_T0;
   alg_T0();
   CNF.serviceEvent(this);
   state_START();
}
/** The actions to take upon entering state T1. */
void state_T1(){
   eccState = INDEX_T1;
   alg_T1();
   CNF.serviceEvent(this);
   state_START();
}
/** The actions to take upon entering state T2. */
void state_T2(){
   eccState = INDEX_T2;
   alg_T2();
   CNF.serviceEvent(this);
   state_START();
}
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
GREEN.value=false;
YELLOW.value=false;
RED.value=false;
Release.value=false;}
  /** ALGORITHM T0 IN ST*/
public void alg_T0(){
GREEN.value=true;
YELLOW.value=false;
RED.value=false;
Release.value=false;}
  /** ALGORITHM T1 IN ST*/
public void alg_T1(){
GREEN.value=false;
YELLOW.value=true;
RED.value=false;
Release.value=false;}
  /** ALGORITHM T2 IN ST*/
public void alg_T2(){
GREEN.value=false;
YELLOW.value=false;
RED.value=true;
Release.value=true;}
}
