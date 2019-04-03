/* Copyright (c)2019 Rockwell Automation. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
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
/** FB PREV_VALS:SUBL_3 */
  protected SUBL PREV_VALS = new SUBL(3);
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
    PREV_VALS.INITO.connectTo(INITO);
    CLOCK.EO.connectTo(CLK);
    CNV_LOAD_STATE.IND.connectTo(LOAD);
    PREV_VALS.INITO.connectTo(INITO);
    MOTOR_CONTOL.CNF.connectTo(CNF);
    PICK_COLOUR.CNF.connectTo(CNF);
    PREV_VALS.IND.connectTo(MOTOR_CONTOL.REQ);
    MOTOR.IND.connectTo(MOTOR_CONTOL.REQ);
    PREV_VALS.connectIVNoException("ID",PREV);
    CNV_LOAD_STATE.connectIVNoException("ID",LOAD_STATE);
    MOTOR.connectIVNoException("ID",CNV_STATE);
    PREV_VALS.connectIVNoException("ID",PREV);
    CNV_LOAD_STATE.connectIVNoException("ID",LOAD_STATE);
    MOTOR.connectIVNoException("ID",CNV_STATE);
    PREV_VALS.connectOVNoException("RD_1",MOTOR_CONTOL.POS);
    MOTOR.connectOVNoException("RD_1",MOTOR_CONTOL.STATE);
    MOTOR_CONTOL.connectIVNoException("COLOUR",COLOUR);
    MOTOR_CONTOL.connectIVNoException("P1",P1);
    MOTOR_CONTOL.connectIVNoException("P2",P2);
    MOTOR_CONTOL.connectIVNoException("P3",P3);
    PICK_COLOUR.connectIVNoException("K",COLOUR);
    CLOCK.DT.initializeNoException("t#100ms");
    PICK_COLOUR.IN0.initializeNoException("[0,0,0]");
    PICK_COLOUR.IN1.initializeNoException("[255,0,0]");
    PICK_COLOUR.IN2.initializeNoException("[255,211,0]");
    PICK_COLOUR.IN3.initializeNoException("[0,0,255]");
  }
	/**
 * {@inheritDoc}
 * @param newVar {@inheritDoc}
 */
@Override
protected void connectInternal(ANY newVar) {
  if(newVar == PREV)
    PREV_VALS.connectIVNoException("ID",PREV);
  if(newVar == LOAD_STATE)
    CNV_LOAD_STATE.connectIVNoException("ID",LOAD_STATE);
  if(newVar == CNV_STATE)
    MOTOR.connectIVNoException("ID",CNV_STATE);
  if(newVar == PREV)
    PREV_VALS.connectIVNoException("ID",PREV);
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
}
/** start the FB instances. */
public void start( ){
    super.start();
  PREV_VALS.start();
  MOTOR.start();
  CNV_LOAD_STATE.start();
  CLOCK.start();
  MOTOR_CONTOL.start();
  PICK_COLOUR.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  PREV_VALS.stop();
  MOTOR.stop();
  CNV_LOAD_STATE.stop();
  CLOCK.stop();
  MOTOR_CONTOL.stop();
  PICK_COLOUR.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  PREV_VALS.kill();
  MOTOR.kill();
  CNV_LOAD_STATE.kill();
  CLOCK.kill();
  MOTOR_CONTOL.kill();
  PICK_COLOUR.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  PREV_VALS.reset();
  MOTOR.reset();
  CNV_LOAD_STATE.reset();
  CLOCK.reset();
  MOTOR_CONTOL.reset();
  PICK_COLOUR.reset();
}
protected synchronized void service_INIT(){
   PREV_VALS.INIT.serviceEvent(this);
   MOTOR.INIT.serviceEvent(this);
   CNV_LOAD_STATE.INIT.serviceEvent(this);
   PREV_VALS.INIT.serviceEvent(this);
   MOTOR.INIT.serviceEvent(this);
   CNV_LOAD_STATE.INIT.serviceEvent(this);
   MOTOR_CONTOL.INIT.serviceEvent(this);
}
protected synchronized void service_REQ(){
   CLOCK.START.serviceEvent(this);
   CLOCK.START.serviceEvent(this);
   PICK_COLOUR.REQ.serviceEvent(this);
   MOTOR_CONTOL.REQ.serviceEvent(this);
}
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    PREV_VALS.initialize("PREV_VALS",r);
    MOTOR.initialize("MOTOR",r);
    CNV_LOAD_STATE.initialize("CNV_LOAD_STATE",r);
    CLOCK.initialize("CLOCK",r);
    MOTOR_CONTOL.initialize("MOTOR_CONTOL",r);
    PICK_COLOUR.initialize("PICK_COLOUR",r);
}
}
