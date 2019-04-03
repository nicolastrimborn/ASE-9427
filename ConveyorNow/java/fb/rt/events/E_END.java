/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.events;
import fb.datatype.*;
import fb.rt.*;
/** FUNCTION_BLOCK E_END (* Permissive propagation of an event *)
  * @author JHC
  * @version 20190403/JHC - Generated.
  */
public class E_END extends fb.rt.FBInstance {
/** The index (0) of state START. */
public static final int INDEX_START = 0;
/** The index (1) of state EO. */
public static final int INDEX_EO = 1;
/** The index (2) of state INIT. */
public static final int INDEX_INIT = 2;
/** Event output */
public final EventOutput EO = new EventOutput();
/** Event input */
public final EventServer RESET = (e) -> service_RESET();
/** EVENT EI */
public final EventServer EI = (e) -> service_EI();
/** Permits EI=>EO pass-through */
  public UINT POS = new UINT();
/** VAR COUNT:UINT */
  public final UINT COUNT = new UINT();
/** The default constructor. */
public E_END(){
    super();
  }
protected synchronized void service_RESET(){
  if(eccState == INDEX_START){
    state_INIT();
  }
}
protected synchronized void service_EI(){
  if((eccState == INDEX_START) && (POS.value==100)){
    state_EO();
  }
}
/** The actions to take upon entering state START. */
void state_START(){
   eccState = INDEX_START;
}
/** The actions to take upon entering state EO. */
void state_EO(){
   eccState = INDEX_EO;
   alg_CU();
   EO.serviceEvent(this);
   state_START();
}
/** The actions to take upon entering state INIT. */
void state_INIT(){
   eccState = INDEX_INIT;
   alg_RESET();
   state_START();
}
  /** ALGORITHM CU IN ST*/
public void alg_CU(){
if( POS.value==100 ){
	END=true;
}}
  /** ALGORITHM RESET IN ST*/
public void alg_RESET(){
COUNT.value=0;}
}
