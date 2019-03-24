/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.events;
import fb.datatype.*;
import fb.rt.*;
/** FUNCTION_BLOCK E_CTUEVENT (* Event-Driven Up Counter *)
  * @author JHC
  * @version 20190320/JHC - Generated.
  */
public class E_CTUEVENT extends fb.rt.FBInstance {
/** The index (0) of state START. */
public static final int INDEX_START = 0;
/** The index (1) of state CU. */
public static final int INDEX_CU = 1;
/** Count Up Output Event */
public final EventOutput CUO = new EventOutput();
/** Reset Output Event */
public final EventOutput RO = new EventOutput();
/** Count Up */
public final EventServer CU = (e) -> service_CU();
/** Reset */
public final EventServer R = (e) -> {
  alg_R();
  RO.serviceEvent(this);
  }
;
/** LImit Value */
  public UINT PV = new UINT();
/** CV >= PV */
  public final BOOL Q = new BOOL();
/** Current Value */
  public final UINT CV = new UINT();
/** The default constructor. */
public E_CTUEVENT(){
    super();
  }
protected synchronized void service_CU(){
  if((eccState == INDEX_START) && (CV.value>=PV.value)){
    state_CU();
  }
}
/** The actions to take upon entering state START. */
void state_START(){
   eccState = INDEX_START;
}
/** The actions to take upon entering state CU. */
void state_CU(){
   eccState = INDEX_CU;
   alg_CU();
   CUO.serviceEvent(this);
   state_START();
}
  /** ALGORITHM CU IN ST*/
public void alg_CU(){
CV.value = CV.value + 1;
Q.value = (CV.value >= PV.value);}
  /** ALGORITHM R IN ST*/
public void alg_R(){
CV.value = 0;
Q.value = false;
}
}
