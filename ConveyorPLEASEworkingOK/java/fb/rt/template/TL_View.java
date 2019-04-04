/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.template; import fb.rt.hmi.*;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
import fb.rt.hmi.*;
/** FUNCTION_BLOCK TL_View (* Normal Traffic Light *)
  * @author JHC
  * @version 20190319/JHC - Generated.
  */
public class TL_View extends fb.rt.FBInstance {
/** INIT Confirm */
public final EventOutput INITO = new EventOutput();
/** REQ Confirmation */
public final EventOutput CNF = new EventOutput();
/** Initialize */
public final EventServer INIT = (e) -> service_INIT();
/** LED State/Color Update */
public final EventServer REQ = (e) -> service_REQ();
/** FB OUT3:OUT_BOOL */
  protected OUT_BOOL OUT3 = new OUT_BOOL() ;
/** FB OUT2:OUT_BOOL */
  protected OUT_BOOL OUT2 = new OUT_BOOL() ;
/** FB OUT1:OUT_BOOL */
  protected OUT_BOOL OUT1 = new OUT_BOOL() ;
/** MSB - Most Significant Bit */
  public BOOL RED = new BOOL();
/** VAR YELLOW:BOOL */
  public BOOL YELLOW = new BOOL();
/** VAR GREEN:BOOL */
  public BOOL GREEN = new BOOL();
/** OFF color */
  public COLOR C0 = new COLOR("COLOR#white");
/** The default constructor. */
public TL_View(){
    super();
    OUT3.INITO.connectTo(OUT2.INIT);
    OUT2.INITO.connectTo(OUT1.INIT);
    OUT3.CNF.connectTo(OUT2.REQ);
    OUT2.CNF.connectTo(OUT1.REQ);
    OUT3.INITO.connectTo(OUT2.INIT);
    OUT2.INITO.connectTo(OUT1.INIT);
    OUT3.CNF.connectTo(OUT2.REQ);
    OUT2.CNF.connectTo(OUT1.REQ);
    OUT1.INITO.connectTo(INITO);
    OUT1.CNF.connectTo(CNF);
    OUT3.connectIVNoException("IN",RED);
    OUT2.connectIVNoException("IN",YELLOW);
    OUT1.connectIVNoException("IN",GREEN);
    OUT3.connectIVNoException("C0",C0);
    OUT2.connectIVNoException("C0",C0);
    OUT1.connectIVNoException("C0",C0);
    OUT3.connectIVNoException("IN",RED);
    OUT2.connectIVNoException("IN",YELLOW);
    OUT1.connectIVNoException("IN",GREEN);
    OUT3.connectIVNoException("C0",C0);
    OUT2.connectIVNoException("C0",C0);
    OUT1.connectIVNoException("C0",C0);
    OUT3.QI.initializeNoException("1");
    OUT3.LABEL.initializeNoException("R");
    OUT3.C1.initializeNoException("[255,0,0]");
    OUT2.QI.initializeNoException("1");
    OUT2.LABEL.initializeNoException("Y");
    OUT2.C1.initializeNoException("[255,211,0]");
    OUT1.QI.initializeNoException("1");
    OUT1.LABEL.initializeNoException("G");
    OUT1.C1.initializeNoException("[0,255,0]");
  }
	/**
 * {@inheritDoc}
 * @param newVar {@inheritDoc}
 */
@Override
protected void connectInternal(ANY newVar) {
  if(newVar == RED)
    OUT3.connectIVNoException("IN",RED);
  if(newVar == YELLOW)
    OUT2.connectIVNoException("IN",YELLOW);
  if(newVar == GREEN)
    OUT1.connectIVNoException("IN",GREEN);
  if(newVar == C0)
    OUT3.connectIVNoException("C0",C0);
  if(newVar == C0)
    OUT2.connectIVNoException("C0",C0);
  if(newVar == C0)
    OUT1.connectIVNoException("C0",C0);
  if(newVar == RED)
    OUT3.connectIVNoException("IN",RED);
  if(newVar == YELLOW)
    OUT2.connectIVNoException("IN",YELLOW);
  if(newVar == GREEN)
    OUT1.connectIVNoException("IN",GREEN);
  if(newVar == C0)
    OUT3.connectIVNoException("C0",C0);
  if(newVar == C0)
    OUT2.connectIVNoException("C0",C0);
  if(newVar == C0)
    OUT1.connectIVNoException("C0",C0);
}
/** start the FB instances. */
public void start( ){
    super.start();
  OUT3.start();
  OUT2.start();
  OUT1.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  OUT3.stop();
  OUT2.stop();
  OUT1.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  OUT3.kill();
  OUT2.kill();
  OUT1.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  OUT3.reset();
  OUT2.reset();
  OUT1.reset();
}
protected synchronized void service_INIT(){
   OUT3.INIT.serviceEvent(this);
   OUT3.INIT.serviceEvent(this);
}
protected synchronized void service_REQ(){
   OUT3.REQ.serviceEvent(this);
   OUT3.REQ.serviceEvent(this);
}
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    OUT3.initialize("OUT3",r);
    OUT2.initialize("OUT2",r);
    OUT1.initialize("OUT1",r);
}
}
