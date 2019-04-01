/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK PASS_COLOUR (* Basic Function Block Type *)
  * @author JHC
  * @version 20190401/JHC - Generated.
  */
public class PASS_COLOUR extends fb.rt.FBInstance {
/** The index (0) of state START. */
public static final int INDEX_START = 0;
/** The index (1) of state INIT. */
public static final int INDEX_INIT = 1;
/** The index (2) of state REQ1. */
public static final int INDEX_REQ1 = 2;
/** The index (3) of state REQ2. */
public static final int INDEX_REQ2 = 3;
/** EVENT CNF */
public final EventOutput CNF = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** Normal Execution Request */
public final EventServer REQ1 = (e) -> service_REQ1();
/** EVENT REQ2 */
public final EventServer REQ2 = (e) -> service_REQ2();
/** Input event qualifier */
  public BOOL QI = new BOOL();
/** VAR CI:COLOR */
  public COLOR CI = new COLOR();
/** Output event qualifier */
  public final BOOL QO1 = new BOOL();
/** VAR CO:COLOR */
  public final COLOR CO = new COLOR();
/** VAR QO2:BOOL */
  public final BOOL QO2 = new BOOL();
/** The default constructor. */
public PASS_COLOUR(){
    super();
  }
protected synchronized void service_INIT(){
  if(eccState == INDEX_START){
    state_INIT();
  }
}
protected synchronized void service_REQ1(){
  if(eccState == INDEX_START){
    state_REQ1();
  }
}
protected synchronized void service_REQ2(){
  if(eccState == INDEX_START){
    state_REQ2();
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
   CNF.serviceEvent(this);
   state_START();
}
/** The actions to take upon entering state REQ1. */
void state_REQ1(){
   eccState = INDEX_REQ1;
   alg_REQ1();
   CNF.serviceEvent(this);
   state_START();
}
/** The actions to take upon entering state REQ2. */
void state_REQ2(){
   eccState = INDEX_REQ2;
   alg_REQ2();
   CNF.serviceEvent(this);
   state_START();
}
  /** ALGORITHM INIT IN Java*/
public void alg_INIT(){
QO1.value=false;
QO2.value=true;
CO.value=CI.value;
}
  /** ALGORITHM REQ1 IN Java*/
public void alg_REQ1(){
QO1.value=QI.value;
QO2.value=QI.value;
CI.value=CO.value;
}
  /** ALGORITHM REQ2 IN ST*/
public void alg_REQ2(){
QO2.value=false;
QO1.value=QI.value;}
}
