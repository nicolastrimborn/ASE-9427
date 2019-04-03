/* Copyright (c)2019 Rockwell Automation. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
import fb.rt.hmi.*;
import fb.rt.net.*;
import fb.rt.select.*;
/** FUNCTION_BLOCK CHECK_POS (* Composite Function Block Type *)
  * @author JHC
  * @version 20190403/JHC - Generated.
  */
public class CHECK_POS extends fb.rt.FBInstance {
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** Execution Confirmation */
public final EventOutput CNF = new EventOutput();
/** EVENT CLK */
public final EventOutput CLK = new EventOutput();
/** EVENT LOAD */
public final EventOutput LOAD = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** Normal Execution Request */
public final EventServer REQ = (e) -> service_REQ();
/** FB MOTOR:SUBL_1 */
  protected SUBL MOTOR = new SUBL(1);
/** FB CNV_LOAD_STATE:SUBL_0 */
  protected SUBL CNV_LOAD_STATE = new SUBL(0);
/** FB CLOCK:E_CYCLE */
  protected E_CYCLE CLOCK = new E_CYCLE() ;
/** FB MOTOR_CONTOL:MTR_CNTRL_POS */
  protected MTR_CNTRL_POS MOTOR_CONTOL = new MTR_CNTRL_POS() ;
/** FB PICK_COLOUR:FB_MUX_COLOR */
  protected FB_MUX_COLOR PICK_COLOUR = new FB_MUX_COLOR() ;
/** FB PREVIOUS:SUBL_4 */
  protected SUBL PREVIOUS = new SUBL(4);
/** FB TEST:OUT_COLOR */
  protected OUT_COLOR TEST = new OUT_COLOR() ;
/** VAR PREV:WSTRING */
  public WSTRING PREV = new WSTRING();
/** VAR CNV_STATE:WSTRING */
  public WSTRING CNV_STATE = new WSTRING();
/** VAR LOAD_STATE:WSTRING */
  public WSTRING LOAD_STATE = new WSTRING();
/** VAR COLOUR:UINT */
  public UINT COLOUR = new UINT();
/** VAR P1:UINT */
  public UINT P1 = new UINT();
/** VAR P2:UINT */
  public UINT P2 = new UINT();
/** VAR P3:UINT */
  public UINT P3 = new UINT();
/** Output event qualifier */
  public final BOOL MTR = (BOOL)MOTOR_CONTOL.MTR;
/** VAR WKPC:COLOR */
  public final COLOR WKPC = (COLOR)PICK_COLOUR.OUT;
/** The default constructor. */
public CHECK_POS(){
    super();
    CLOCK.EO.connectTo(CLK);
    CNV_LOAD_STATE.IND.connectTo(LOAD);
    CLOCK.EO.connectTo(CLK);
    CNV_LOAD_STATE.IND.connectTo(LOAD);
    MOTOR_CONTOL.CNF.connectTo(CNF);
    PICK_COLOUR.CNF.connectTo(CNF);
    MOTOR.IND.connectTo(MOTOR_CONTOL.REQ);
    PREVIOUS.INITO.connectTo(INITO);
    PREVIOUS.IND.connectTo(MOTOR_CONTOL.REQ);
    CNV_LOAD_STATE.connectIVNoException("ID",LOAD_STATE);
    MOTOR.connectIVNoException("ID",CNV_STATE);
    CNV_LOAD_STATE.connectIVNoException("ID",LOAD_STATE);
    MOTOR.connectIVNoException("ID",CNV_STATE);
    MOTOR.connectOVNoException("RD_1",MOTOR_CONTOL.STATE);
    MOTOR_CONTOL.connectIVNoException("COLOUR",COLOUR);
    MOTOR_CONTOL.connectIVNoException("P1",P1);
    MOTOR_CONTOL.connectIVNoException("P2",P2);
    MOTOR_CONTOL.connectIVNoException("P3",P3);
    PICK_COLOUR.connectIVNoException("K",COLOUR);
    PREVIOUS.connectOVNoException("RD_2",MOTOR_CONTOL.POS);
    PREVIOUS.connectIVNoException("ID",PREV);
    TEST.connectIVNoException("IN",PICK_COLOUR.ovNamedNoException("OUT"));
    CLOCK.DT.initializeNoException("t#100ms");
    PICK_COLOUR.IN0.initializeNoException("[0,0,0]");
    PICK_COLOUR.IN1.initializeNoException("[255,0,0]");
    PICK_COLOUR.IN2.initializeNoException("[255,211,0]");
    PICK_COLOUR.IN3.initializeNoException("[0,0,255]");
    TEST.LABEL.initializeNoException("COLOUR");
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
  if(newVar == LOAD_STATE)
    CNV_LOAD_STATE.connectIVNoException("ID",LOAD_STATE);
  if(newVar == CNV_STATE)
    MOTOR.connectIVNoException("ID",CNV_STATE);
  if(newVar == COLOUR)
    MOTOR_CONTOL.connectIVNoException("COLOUR",COLOUR);
  if(newVar == P1)
    MOTOR_CONTOL.connectIVNoException("P1",P1);
  if(newVar == P2)
    MOTOR_CONTOL.connectIVNoException("P2",P2);
  if(newVar == P3)
    MOTOR_CONTOL.connectIVNoException("P3",P3);
  if(newVar == COLOUR)
    PICK_COLOUR.connectIVNoException("K",COLOUR);
  if(newVar == PREV)
    PREVIOUS.connectIVNoException("ID",PREV);
}
/** start the FB instances. */
public void start( ){
    super.start();
  MOTOR.start();
  CNV_LOAD_STATE.start();
  CLOCK.start();
  MOTOR_CONTOL.start();
  PICK_COLOUR.start();
  PREVIOUS.start();
  TEST.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  MOTOR.stop();
  CNV_LOAD_STATE.stop();
  CLOCK.stop();
  MOTOR_CONTOL.stop();
  PICK_COLOUR.stop();
  PREVIOUS.stop();
  TEST.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  MOTOR.kill();
  CNV_LOAD_STATE.kill();
  CLOCK.kill();
  MOTOR_CONTOL.kill();
  PICK_COLOUR.kill();
  PREVIOUS.kill();
  TEST.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  MOTOR.reset();
  CNV_LOAD_STATE.reset();
  CLOCK.reset();
  MOTOR_CONTOL.reset();
  PICK_COLOUR.reset();
  PREVIOUS.reset();
  TEST.reset();
}
protected synchronized void service_INIT(){
   MOTOR.INIT.serviceEvent(this);
   CNV_LOAD_STATE.INIT.serviceEvent(this);
   MOTOR.INIT.serviceEvent(this);
   CNV_LOAD_STATE.INIT.serviceEvent(this);
   MOTOR_CONTOL.INIT.serviceEvent(this);
   PREVIOUS.INIT.serviceEvent(this);
   TEST.INIT.serviceEvent(this);
}
protected synchronized void service_REQ(){
   CLOCK.START.serviceEvent(this);
   CLOCK.START.serviceEvent(this);
   PICK_COLOUR.REQ.serviceEvent(this);
   MOTOR_CONTOL.REQ.serviceEvent(this);
   TEST.REQ.serviceEvent(this);
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
    CLOCK.initialize("CLOCK",r);
    MOTOR_CONTOL.initialize("MOTOR_CONTOL",r);
    PICK_COLOUR.initialize("PICK_COLOUR",r);
    PREVIOUS.initialize("PREVIOUS",r);
    TEST.initialize("TEST",r);
}
}
