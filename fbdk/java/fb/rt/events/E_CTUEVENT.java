/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.events;
import fb.datatype.*;
import fb.rt.*;
/** FUNCTION_BLOCK E_CTUEVENT (* Event-Driven Up Counter *)
  * @author JHC
  * @version 20190324/JHC - Generated.
  */
public class E_CTUEVENT extends fb.rt.FBInstance {
/** The index (0) of state START. */
public static final int INDEX_START = 0;
/** The index (1) of state CountReached. */
public static final int INDEX_CountReached = 1;
/** The index (2) of state Count. */
public static final int INDEX_Count = 2;
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
    state_CountReached();
  }
  else if(eccState == INDEX_START){
    state_Count();
  }
}
/** The actions to take upon entering state START. */
void state_START(){
   eccState = INDEX_START;
}
/** The actions to take upon entering state CountReached. */
void state_CountReached(){
   eccState = INDEX_CountReached;
   alg_R();
   CUO.serviceEvent(this);
   state_START();
}
/** The actions to take upon entering state Count. */
void state_Count(){
   eccState = INDEX_Count;
   alg_CU();
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
