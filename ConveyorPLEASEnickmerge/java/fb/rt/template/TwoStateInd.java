/* Copyright (c)2019 Rockwell Automation. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
import fb.rt.hmi.*;
/** FUNCTION_BLOCK TwoStateInd (* Composite Function Block Type *)
  * @author JHC
  * @version 20190404/JHC - Generated.
  */
public class TwoStateInd extends fb.rt.FBInstance {
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** Execution Confirmation */
public final EventOutput CNF = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** Normal Execution Request */
public final EventServer REQ = (e) -> service_REQ();
/** FB State1:OUT_BOOL */
  protected OUT_BOOL State1 = new OUT_BOOL() ;
/** FB State2:OUT_BOOL */
  protected OUT_BOOL State2 = new OUT_BOOL() ;
/** VAR LABEL1:WSTRING */
  public WSTRING LABEL1 = new WSTRING();
/** VAR LABEL2:WSTRING */
  public WSTRING LABEL2 = new WSTRING();
/** VAR IN:BOOL */
  public BOOL IN = new BOOL();
/** The default constructor. */
public TwoStateInd(){
    super();
    State1.INITO.connectTo(State2.INIT);
    State1.CNF.connectTo(State2.REQ);
    State2.INITO.connectTo(INITO);
    State2.CNF.connectTo(CNF);
    State1.INITO.connectTo(State2.INIT);
    State1.CNF.connectTo(State2.REQ);
    State2.INITO.connectTo(INITO);
    State2.CNF.connectTo(CNF);
    State1.INITO.connectTo(State2.INIT);
    State1.CNF.connectTo(State2.REQ);
    State2.INITO.connectTo(INITO);
    State2.CNF.connectTo(CNF);
    State1.INITO.connectTo(State2.INIT);
    State1.CNF.connectTo(State2.REQ);
    State2.INITO.connectTo(INITO);
    State2.CNF.connectTo(CNF);
    State1.connectIVNoException("IN",IN);
    State2.connectIVNoException("IN",IN);
    State1.connectIVNoException("LABEL",LABEL1);
    State2.connectIVNoException("LABEL",LABEL2);
    State1.connectIVNoException("IN",IN);
    State2.connectIVNoException("IN",IN);
    State1.connectIVNoException("LABEL",LABEL1);
    State2.connectIVNoException("LABEL",LABEL2);
    State1.connectIVNoException("IN",IN);
    State2.connectIVNoException("IN",IN);
    State1.connectIVNoException("LABEL",LABEL1);
    State2.connectIVNoException("LABEL",LABEL2);
    State1.connectIVNoException("IN",IN);
    State2.connectIVNoException("IN",IN);
    State1.connectIVNoException("LABEL",LABEL1);
    State2.connectIVNoException("LABEL",LABEL2);
    State1.C0.initializeNoException("[255,255,255]");
    State1.C1.initializeNoException("[0,255,0]");
    State1.QI.initializeNoException("1");
    State2.C0.initializeNoException("[0,255,0]");
    State2.C1.initializeNoException("[255,255,255]");
    State2.QI.initializeNoException("1");
  }
	/**
 * {@inheritDoc}
 * @param newVar {@inheritDoc}
 */
@Override
protected void connectInternal(ANY newVar) {
  if(newVar == IN)
    State1.connectIVNoException("IN",IN);
  if(newVar == IN)
    State2.connectIVNoException("IN",IN);
  if(newVar == LABEL1)
    State1.connectIVNoException("LABEL",LABEL1);
  if(newVar == LABEL2)
    State2.connectIVNoException("LABEL",LABEL2);
  if(newVar == IN)
    State1.connectIVNoException("IN",IN);
  if(newVar == IN)
    State2.connectIVNoException("IN",IN);
  if(newVar == LABEL1)
    State1.connectIVNoException("LABEL",LABEL1);
  if(newVar == LABEL2)
    State2.connectIVNoException("LABEL",LABEL2);
  if(newVar == IN)
    State1.connectIVNoException("IN",IN);
  if(newVar == IN)
    State2.connectIVNoException("IN",IN);
  if(newVar == LABEL1)
    State1.connectIVNoException("LABEL",LABEL1);
  if(newVar == LABEL2)
    State2.connectIVNoException("LABEL",LABEL2);
  if(newVar == IN)
    State1.connectIVNoException("IN",IN);
  if(newVar == IN)
    State2.connectIVNoException("IN",IN);
  if(newVar == LABEL1)
    State1.connectIVNoException("LABEL",LABEL1);
  if(newVar == LABEL2)
    State2.connectIVNoException("LABEL",LABEL2);
}
/** start the FB instances. */
public void start( ){
    super.start();
  State1.start();
  State2.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  State1.stop();
  State2.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  State1.kill();
  State2.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  State1.reset();
  State2.reset();
}
protected synchronized void service_INIT(){
   State1.INIT.serviceEvent(this);
   State1.INIT.serviceEvent(this);
   State1.INIT.serviceEvent(this);
   State1.INIT.serviceEvent(this);
}
protected synchronized void service_REQ(){
   State1.REQ.serviceEvent(this);
   State1.REQ.serviceEvent(this);
   State1.REQ.serviceEvent(this);
   State1.REQ.serviceEvent(this);
}
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    State1.initialize("State1",r);
    State2.initialize("State2",r);
}
}
