<<<<<<< HEAD
/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK Basic (* Basic Function Block Type *)
  * @author JHC
  * @version 20190401/JHC - Generated.
  */
public class Basic extends fb.rt.FBInstance {
/** The index (0) of state START. */
public static final int INDEX_START = 0;
/** The index (1) of state INIT. */
public static final int INDEX_INIT = 1;
/** The index (2) of state REQ1. */
public static final int INDEX_REQ1 = 2;
/** The index (3) of state REQ2. */
public static final int INDEX_REQ2 = 3;
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** Execution Confirmation */
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
public Basic(){
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
   INITO.serviceEvent(this);
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
}
=======
/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK Basic (* Basic Function Block Type *)
  * @author JHC
  * @version 20190401/JHC - Generated.
  */
public class Basic extends fb.rt.FBInstance {
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
/** Input event qualifier */
  public BOOL QI = new BOOL();
/** VAR CI:COLOR */
  public COLOR CI = new COLOR();
/** Output event qualifier */
  public final BOOL QO = new BOOL();
/** VAR CO:COLOR */
  public final COLOR CO = new COLOR();
/** The default constructor. */
public Basic(){
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
}
  /** ALGORITHM REQ IN Java*/
public void alg_REQ(){
QI.value=QO.value;
CI.value=CO.value;
CI.value=[0 0 0];
}
}
>>>>>>> 4fc5eddf98f340facf2279a41ea4e68315b1aa5f
