/* Copyright (c)2019 Rockwell Automation. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
import fb.rt.hmi.*;
import fb.rt.net.*;
/** FUNCTION_BLOCK UPDATE_CONV_STATE (* Composite Function Block Type *)
  * @author JHC
  * @version 20190404/JHC - Generated.
  */
public class UPDATE_CONV_STATE extends fb.rt.FBInstance {
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** Execution Confirmation */
public final EventOutput CNF = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** FB LOAD_BTN:IN_EVENT */
  protected IN_EVENT LOAD_BTN = new IN_EVENT() ;
/** FB CNV_LOAD_STATE:PUBL_0 */
  protected PUBL CNV_LOAD_STATE = new PUBL(0);
/** FB CNV:IN_BOOL */
  protected IN_BOOL CNV = new IN_BOOL() ;
/** FB CNV_MTR_STATE:PUBL_1 */
  protected PUBL CNV_MTR_STATE = new PUBL(1);
/** Input event qualifier */
  public WSTRING LOAD_STATE = new WSTRING();
/** VAR MOTOR_STATE:WSTRING */
  public WSTRING MOTOR_STATE = new WSTRING();
/** VAR LABEL:WSTRING */
  public WSTRING LABEL = new WSTRING();
/** The default constructor. */
public UPDATE_CONV_STATE(){
    super();
    LOAD_BTN.INITO.connectTo(CNV_LOAD_STATE.INIT);
    CNV_LOAD_STATE.INITO.connectTo(CNV.INIT);
    CNV.INITO.connectTo(CNV_MTR_STATE.INIT);
    LOAD_BTN.IND.connectTo(CNV_LOAD_STATE.REQ);
    CNV_LOAD_STATE.CNF.connectTo(CNV.REQ);
    CNV.IND.connectTo(CNV_MTR_STATE.REQ);
    CNV_MTR_STATE.INITO.connectTo(INITO);
    CNV_MTR_STATE.CNF.connectTo(CNF);
    CNV_MTR_STATE.connectIVNoException("SD_1",CNV.ovNamedNoException("OUT"));
    CNV_LOAD_STATE.connectIVNoException("ID",LOAD_STATE);
    CNV.connectIVNoException("LABEL",LABEL);
    CNV_MTR_STATE.connectIVNoException("ID",MOTOR_STATE);
    LOAD_BTN.LABEL.initializeNoException("Load WP");
    LOAD_BTN.QI.initializeNoException("1");
  }
	/**
 * {@inheritDoc}
 * @param newVar {@inheritDoc}
 */
@Override
protected void connectInternal(ANY newVar) {
  if(newVar == LOAD_STATE)
    CNV_LOAD_STATE.connectIVNoException("ID",LOAD_STATE);
  if(newVar == LABEL)
    CNV.connectIVNoException("LABEL",LABEL);
  if(newVar == MOTOR_STATE)
    CNV_MTR_STATE.connectIVNoException("ID",MOTOR_STATE);
}
/** start the FB instances. */
public void start( ){
    super.start();
  LOAD_BTN.start();
  CNV_LOAD_STATE.start();
  CNV.start();
  CNV_MTR_STATE.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  LOAD_BTN.stop();
  CNV_LOAD_STATE.stop();
  CNV.stop();
  CNV_MTR_STATE.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  LOAD_BTN.kill();
  CNV_LOAD_STATE.kill();
  CNV.kill();
  CNV_MTR_STATE.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  LOAD_BTN.reset();
  CNV_LOAD_STATE.reset();
  CNV.reset();
  CNV_MTR_STATE.reset();
}
protected synchronized void service_INIT(){
   LOAD_BTN.INIT.serviceEvent(this);
}
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    LOAD_BTN.initialize("LOAD_BTN",r);
    CNV_LOAD_STATE.initialize("CNV_LOAD_STATE",r);
    CNV.initialize("CNV",r);
    CNV_MTR_STATE.initialize("CNV_MTR_STATE",r);
}
}
