/* Copyright (c)2019 Rockwell Automation. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
import fb.rt.net.*;
import fb.rt.select.*;
/** FUNCTION_BLOCK TO_CNV_MODEL (* Composite Function Block Type *)
  * @author JHC
  * @version 20190403/JHC - Generated.
  */
public class TO_CNV_MODEL extends fb.rt.FBInstance {
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** Execution Confirmation */
public final EventOutput CNF = new EventOutput();
/** EVENT CLK */
public final EventOutput CLK = new EventOutput();
/** EVENT LOAD */
public final EventOutput LOAD = new EventOutput();
/** EVENT UNLD */
public final EventOutput UNLD = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** Normal Execution Request */
public final EventServer REQ = (e) -> service_REQ();
/** FB MOTOR:SUBL_1 */
  protected SUBL MOTOR = new SUBL(1);
/** FB CNV_LOAD_STATE:SUBL_0 */
  protected SUBL CNV_LOAD_STATE = new SUBL(0);
/** FB NEXT_STATE:SUBL_1 */
  protected SUBL NEXT_STATE = new SUBL(1);
/** FB UNLOAD:E_TRIG */
  protected E_TRIG UNLOAD = new E_TRIG() ;
/** FB CLOCK:E_CYCLE */
  protected E_CYCLE CLOCK = new E_CYCLE() ;
/** FB PASS_COLOUR:FB_MUX_COLOR */
  protected FB_MUX_COLOR PASS_COLOUR = new FB_MUX_COLOR() ;
/** FB WKPC_COLOUR:SUBL_1 */
  protected SUBL WKPC_COLOUR = new SUBL(1);
/** VAR CNV_STATE:WSTRING */
  public WSTRING CNV_STATE = new WSTRING();
/** VAR LOAD_STATE:WSTRING */
  public WSTRING LOAD_STATE = new WSTRING();
/** VAR NEXT:WSTRING */
  public WSTRING NEXT = new WSTRING();
/** VAR COLOUR:WSTRING */
  public WSTRING COLOUR = new WSTRING();
/** Output event qualifier */
  public final BOOL MTR = new BOOL();
/** VAR WKPC:COLOR */
  public final COLOR WKPC = (COLOR)PASS_COLOUR.OUT;
/** The default constructor. */
public TO_CNV_MODEL(){
    super();
    NEXT_STATE.IND.connectTo(UNLOAD.EI);
    CLOCK.EO.connectTo(CLK);
    CNV_LOAD_STATE.IND.connectTo(LOAD);
    UNLOAD.ER.connectTo(UNLD);
    MOTOR.IND.connectTo(CNF);
    PASS_COLOUR.CNF.connectTo(CNF);
    MOTOR.INITO.connectTo(INITO);
    WKPC_COLOUR.IND.connectTo(PASS_COLOUR.REQ);
    NEXT_STATE.connectOVNoException("RD_1",UNLOAD.QI);
    CNV_LOAD_STATE.connectIVNoException("ID",LOAD_STATE);
    MOTOR.connectIVNoException("ID",CNV_STATE);
    NEXT_STATE.connectIVNoException("ID",NEXT);
    MOTOR.connectOVNoException("RD_1",MTR);
    WKPC_COLOUR.connectOVNoException("RD_1",PASS_COLOUR.K);
    WKPC_COLOUR.connectIVNoException("ID",COLOUR);
    CLOCK.DT.initializeNoException("t#100ms");
    PASS_COLOUR.IN0.initializeNoException("[0,0,0]");
    PASS_COLOUR.IN1.initializeNoException("[255,0,0]");
    PASS_COLOUR.IN2.initializeNoException("[255,211,0]");
    PASS_COLOUR.IN3.initializeNoException("[0,0,255]");
  }
	/**
 * {@inheritDoc}
 * @param newVar {@inheritDoc}
 */
@Override
protected void connectInternal(ANY newVar) {
  if(newVar == LOAD_STATE)
    CNV_LOAD_STATE.connectIVNoException("ID",LOAD_STATE);
  if(newVar == CNV_STATE)
    MOTOR.connectIVNoException("ID",CNV_STATE);
  if(newVar == NEXT)
    NEXT_STATE.connectIVNoException("ID",NEXT);
  if(newVar == COLOUR)
    WKPC_COLOUR.connectIVNoException("ID",COLOUR);
}
/** start the FB instances. */
public void start( ){
    super.start();
  MOTOR.start();
  CNV_LOAD_STATE.start();
  NEXT_STATE.start();
  UNLOAD.start();
  CLOCK.start();
  PASS_COLOUR.start();
  WKPC_COLOUR.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  MOTOR.stop();
  CNV_LOAD_STATE.stop();
  NEXT_STATE.stop();
  UNLOAD.stop();
  CLOCK.stop();
  PASS_COLOUR.stop();
  WKPC_COLOUR.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  MOTOR.kill();
  CNV_LOAD_STATE.kill();
  NEXT_STATE.kill();
  UNLOAD.kill();
  CLOCK.kill();
  PASS_COLOUR.kill();
  WKPC_COLOUR.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  MOTOR.reset();
  CNV_LOAD_STATE.reset();
  NEXT_STATE.reset();
  UNLOAD.reset();
  CLOCK.reset();
  PASS_COLOUR.reset();
  WKPC_COLOUR.reset();
}
protected synchronized void service_INIT(){
   MOTOR.INIT.serviceEvent(this);
   CNV_LOAD_STATE.INIT.serviceEvent(this);
   NEXT_STATE.INIT.serviceEvent(this);
   WKPC_COLOUR.INIT.serviceEvent(this);
}
protected synchronized void service_REQ(){
   CLOCK.START.serviceEvent(this);
}
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    MOTOR.initialize("MOTOR",r);
    CNV_LOAD_STATE.initialize("CNV_LOAD_STATE",r);
    NEXT_STATE.initialize("NEXT_STATE",r);
    UNLOAD.initialize("UNLOAD",r);
    CLOCK.initialize("CLOCK",r);
    PASS_COLOUR.initialize("PASS_COLOUR",r);
    WKPC_COLOUR.initialize("WKPC_COLOUR",r);
}
}
