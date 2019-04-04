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
/** EVENT CNF */
public final EventOutput CNF = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** Normal Execution Request */
public final EventServer REQ1 = (e) -> service_REQ1();
/** Input event qualifier */
  public BOOL QI = new BOOL();
/** VAR CI:COLOR */
  public COLOR CI = new COLOR();
/** Output event qualifier */
  public final BOOL QO = new BOOL();
/** VAR CO:COLOR */
  public final COLOR CO = new COLOR();
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
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
QO.value==QI.value;
CO.value==CI.value;}
  /** ALGORITHM REQ1 IN ST*/
public void alg_REQ1(){
QO.value=QI.value;}
}
