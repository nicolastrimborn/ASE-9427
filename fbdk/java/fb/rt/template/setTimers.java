/* Copyright (c)2019 Rockwell Automation. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK setTimers (* Composite Function Block Type *)
  * @author JHC
  * @version 20190319/JHC - Generated.
  */
public class setTimers extends fb.rt.FBInstance {
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** Execution Confirmation */
public final EventOutput CNF = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** Normal Execution Request */
public final EventServer REQ = (e) -> service_REQ();
/** FB Control:TRAFFICCONTROL1 */
  protected TRAFFICCONTROL1 Control = new TRAFFICCONTROL1() ;
/** FB toGreen:E_TRIG */
  protected E_TRIG toGreen = new E_TRIG() ;
/** FB TimerGreen:E_DELAY */
  protected E_DELAY TimerGreen = new E_DELAY() ;
/** FB TimerYellow:E_DELAY */
  protected E_DELAY TimerYellow = new E_DELAY() ;
/** VAR Q1:BOOL */
  public BOOL Q1 = new BOOL();
/** VAR RED:BOOL */
  public final BOOL RED = (BOOL)Control.RED;
/** VAR YELLOW:BOOL */
  public final BOOL YELLOW = (BOOL)Control.YELLOW;
/** VAR GREEN:BOOL */
  public final BOOL GREEN = (BOOL)Control.GREEN;
/** VAR RELEASE:BOOL */
  public final BOOL RELEASE = (BOOL)Control.Release;
/** The default constructor. */
public setTimers(){
    super();
    toGreen.ER.connectTo(Control.T0);
    toGreen.ER.connectTo(TimerGreen.START);
    TimerGreen.EO.connectTo(Control.T1);
    TimerGreen.EO.connectTo(TimerYellow.START);
    TimerYellow.EO.connectTo(Control.T2);
    Control.INITO.connectTo(INITO);
    Control.CNF.connectTo(CNF);
    toGreen.connectIVNoException("QI",Q1);
    TimerGreen.DT.initializeNoException("t#3s");
    TimerYellow.DT.initializeNoException("t#1s");
  }
	/**
 * {@inheritDoc}
 * @param newVar {@inheritDoc}
 */
@Override
protected void connectInternal(ANY newVar) {
  if(newVar == Q1)
    toGreen.connectIVNoException("QI",Q1);
}
/** start the FB instances. */
public void start( ){
    super.start();
  Control.start();
  toGreen.start();
  TimerGreen.start();
  TimerYellow.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  Control.stop();
  toGreen.stop();
  TimerGreen.stop();
  TimerYellow.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  Control.kill();
  toGreen.kill();
  TimerGreen.kill();
  TimerYellow.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  Control.reset();
  toGreen.reset();
  TimerGreen.reset();
  TimerYellow.reset();
}
protected synchronized void service_INIT(){
   Control.INIT.serviceEvent(this);
}
protected synchronized void service_REQ(){
   toGreen.EI.serviceEvent(this);
}
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    Control.initialize("Control",r);
    toGreen.initialize("toGreen",r);
    TimerGreen.initialize("TimerGreen",r);
    TimerYellow.initialize("TimerYellow",r);
}
}
