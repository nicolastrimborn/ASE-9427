/* Copyright (c)2019 Rockwell Automation. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
import fb.rt.hmi.*;
import fb.rt.net.*;
import fb.rt.select.*;
/** FUNCTION_BLOCK CNV_CTRL (* Composite Function Block Type *)
  * @author JHC
  * @version 20190403/JHC - Generated.
  */
public class CNV_CTRL extends fb.rt.FBInstance {
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
/** FB MTR_DELAY:E_DELAY */
  protected E_DELAY MTR_DELAY = new E_DELAY() ;
/** FB CNV_LOAD_STATE:SUBL_1 */
  protected SUBL CNV_LOAD_STATE = new SUBL(1);
/** FB test:OUT_EVENT */
  protected OUT_EVENT test = new OUT_EVENT() ;
/** FB PASS_IT:PASS_BOOL */
  protected PASS_BOOL PASS_IT = new PASS_BOOL() ;
/** FB TO_NEXT:PUBL_2 */
  protected PUBL TO_NEXT = new PUBL(2);
/** VAR CNV_STATE:WSTRING */
  public WSTRING CNV_STATE = new WSTRING();
/** VAR NEXT:WSTRING */
  public WSTRING NEXT = new WSTRING();
/** VAR COLOUR:WSTRING */
  public WSTRING COLOUR = new WSTRING();
/** Output event qualifier */
  public final BOOL MTR = (BOOL)PASS_IT.MTR;
/** VAR WKPC:COLOR */
  public final COLOR WKPC = (COLOR)PASS_COLOUR.OUT;
/** The default constructor. */
public CNV_CTRL(){
    super();
    NEXT_STATE.IND.connectTo(UNLOAD.EI);
    CLOCK.EO.connectTo(CLK);
    UNLOAD.ER.connectTo(UNLD);
    PASS_COLOUR.CNF.connectTo(CNF);
    WKPC_COLOUR.IND.connectTo(PASS_COLOUR.REQ);
    CNV_LOAD_STATE.IND.connectTo(LOAD);
    CNV_LOAD_STATE.IND.connectTo(MTR_DELAY.START);
    MTR_DELAY.EO.connectTo(test.REQ);
    CNV_LOAD_STATE.IND.connectTo(PASS_IT.INIT);
    MTR_DELAY.EO.connectTo(PASS_IT.REQ);
    PASS_IT.CNF.connectTo(CNF);
    PASS_IT.INITO.connectTo(INITO);
    NEXT_STATE.connectOVNoException("RD_1",UNLOAD.QI);
    NEXT_STATE.connectIVNoException("ID",NEXT);
    WKPC_COLOUR.connectOVNoException("RD_1",PASS_COLOUR.K);
    WKPC_COLOUR.connectIVNoException("ID",COLOUR);
    CNV_LOAD_STATE.connectIVNoException("ID",CNV_STATE);
    test.connectIVNoException("FLASH",WKPC);
    CNV_LOAD_STATE.connectOVNoException("RD_1",PASS_IT.STATE);
    TO_NEXT.connectIVNoException("ID",NEXT);
    TO_NEXT.connectIVNoException("SD_2",WKPC);
    CLOCK.DT.initializeNoException("t#100ms");
    PASS_COLOUR.IN0.initializeNoException("[0,0,0]");
    PASS_COLOUR.IN1.initializeNoException("[255,0,0]");
    PASS_COLOUR.IN2.initializeNoException("[255,211,0]");
    PASS_COLOUR.IN3.initializeNoException("[0,0,255]");
    MTR_DELAY.DT.initializeNoException("t#1s");
    test.LABEL.initializeNoException("TEST");
    test.DT.initializeNoException("t#1s");
  }
	/**
 * {@inheritDoc}
 * @param newVar {@inheritDoc}
 */
@Override
protected void connectInternal(ANY newVar) {
  if(newVar == NEXT)
    NEXT_STATE.connectIVNoException("ID",NEXT);
  if(newVar == COLOUR)
    WKPC_COLOUR.connectIVNoException("ID",COLOUR);
  if(newVar == CNV_STATE)
    CNV_LOAD_STATE.connectIVNoException("ID",CNV_STATE);
  if(newVar == NEXT)
    TO_NEXT.connectIVNoException("ID",NEXT);
}
/** start the FB instances. */
public void start( ){
    super.start();
  NEXT_STATE.start();
  UNLOAD.start();
  CLOCK.start();
  PASS_COLOUR.start();
  WKPC_COLOUR.start();
  MTR_DELAY.start();
  CNV_LOAD_STATE.start();
  test.start();
  PASS_IT.start();
  TO_NEXT.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  NEXT_STATE.stop();
  UNLOAD.stop();
  CLOCK.stop();
  PASS_COLOUR.stop();
  WKPC_COLOUR.stop();
  MTR_DELAY.stop();
  CNV_LOAD_STATE.stop();
  test.stop();
  PASS_IT.stop();
  TO_NEXT.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  NEXT_STATE.kill();
  UNLOAD.kill();
  CLOCK.kill();
  PASS_COLOUR.kill();
  WKPC_COLOUR.kill();
  MTR_DELAY.kill();
  CNV_LOAD_STATE.kill();
  test.kill();
  PASS_IT.kill();
  TO_NEXT.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  NEXT_STATE.reset();
  UNLOAD.reset();
  CLOCK.reset();
  PASS_COLOUR.reset();
  WKPC_COLOUR.reset();
  MTR_DELAY.reset();
  CNV_LOAD_STATE.reset();
  test.reset();
  PASS_IT.reset();
  TO_NEXT.reset();
}
protected synchronized void service_INIT(){
   NEXT_STATE.INIT.serviceEvent(this);
   WKPC_COLOUR.INIT.serviceEvent(this);
   CNV_LOAD_STATE.INIT.serviceEvent(this);
   test.INIT.serviceEvent(this);
   TO_NEXT.INIT.serviceEvent(this);
}
protected synchronized void service_REQ(){
   CLOCK.START.serviceEvent(this);
   TO_NEXT.REQ.serviceEvent(this);
}
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    NEXT_STATE.initialize("NEXT_STATE",r);
    UNLOAD.initialize("UNLOAD",r);
    CLOCK.initialize("CLOCK",r);
    PASS_COLOUR.initialize("PASS_COLOUR",r);
    WKPC_COLOUR.initialize("WKPC_COLOUR",r);
    MTR_DELAY.initialize("MTR_DELAY",r);
    CNV_LOAD_STATE.initialize("CNV_LOAD_STATE",r);
    test.initialize("test",r);
    PASS_IT.initialize("PASS_IT",r);
    TO_NEXT.initialize("TO_NEXT",r);
}
}
