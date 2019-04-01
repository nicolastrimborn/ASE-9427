/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.events;
import fb.datatype.*;
import fb.rt.*;
/** FUNCTION_BLOCK E_CTDEVENT (* Event-Driven Up Counter *)
  * @author JHC
  * @version 20190320/JHC - Generated.
  */
public class E_CTDEVENT extends fb.rt.FBInstance {
/** The index (0) of state START. */
public static final int INDEX_START = 0;
/** The index (1) of state CD. */
public static final int INDEX_CD = 1;
/** The index (2) of state CountReached. */
public static final int INDEX_CountReached = 2;
/** Count Up Output Event */
public final EventOutput CUO = new EventOutput();
/** Reset Output Event */
public final EventOutput RO = new EventOutput();
/** Count Down */
public final EventServer CD = (e) -> service_CD();
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
public E_CTDEVENT(){
    super();
  }
protected synchronized void service_CD(){
  if((eccState == INDEX_START) && (CV.value>=PV.value)){
    state_CountReached();
  }
  else if(eccState == INDEX_START){
    state_CD();
  }
}
/** The actions to take upon entering state START. */
void state_START(){
   eccState = INDEX_START;
}
/** The actions to take upon entering state CD. */
void state_CD(){
   eccState = INDEX_CD;
   alg_CD();
   state_START();
}
/** The actions to take upon entering state CountReached. */
void state_CountReached(){
   eccState = INDEX_CountReached;
   CUO.serviceEvent(this);
   state_START();
}
  /** ALGORITHM CD IN ST*/
public void alg_CD(){
CV.value = CV.value - 1;
Q.value = (CV.value >= PV.value);}
  /** ALGORITHM R IN ST*/
public void alg_R(){
CV.value = 0;
Q.value = false;
}
}
