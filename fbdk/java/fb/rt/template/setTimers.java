/* Copyright (c)2019 Rockwell Automation. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
import fb.rt.hmi.*;
/** FUNCTION_BLOCK setTimers (* Composite Function Block Type *)
  * @author JHC
  * @version 20190324/JHC - Generated.
  */
public class setTimers extends fb.rt.FBInstance {
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** Execution Confirmation */
public final EventOutput CNF = new EventOutput();
/** EVENT RELEASE */
public final EventOutput RELEASE = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** Normal Execution Request */
public final EventServer REQ = (e) -> service_REQ();
/** EVENT PEDCROSS */
public final EventServer PEDCROSS = (e) -> service_PEDCROSS();
/** FB Control:TRAFFICCONTROL1 */
  protected TRAFFICCONTROL1 Control = new TRAFFICCONTROL1() ;
/** FB TimerYellow:E_DELAY */
  protected E_DELAY TimerYellow = new E_DELAY() ;
/** FB TimeLeft:OUT_ANY_LBL */
  protected OUT_ANY_LBL TimeLeft = new OUT_ANY_LBL() ;
/** FB GreenTimer:E_CYCLE */
  protected E_CYCLE GreenTimer = new E_CYCLE() ;
/** FB ped:E_PERMIT */
  protected E_PERMIT ped = new E_PERMIT() ;
/** FB GREENTIMER:GREENTIMER */
  protected GREENTIMER GREENTIMER = new GREENTIMER() ;
/** VAR RED:BOOL */
  public final BOOL RED = (BOOL)Control.RED;
/** VAR YELLOW:BOOL */
  public final BOOL YELLOW = (BOOL)Control.YELLOW;
/** VAR GREEN:BOOL */
  public final BOOL GREEN = (BOOL)Control.GREEN;
/** The default constructor. */
public setTimers(){
    super();
    TimerYellow.EO.connectTo(Control.T2);
    Control.INITO.connectTo(INITO);
    Control.CNF.connectTo(CNF);
    Control.RELEASE.connectTo(RELEASE);
    ped.EO.connectTo(TimerYellow.START);
    GreenTimer.EO.connectTo(GREENTIMER.CD);
    GREENTIMER.START_Y.connectTo(Control.T1);
    GREENTIMER.START_Y.connectTo(TimerYellow.START);
    GreenTimer.EO.connectTo(TimeLeft.REQ);
    TimerYellow.EO.connectTo(Control.T2);
    Control.INITO.connectTo(INITO);
    Control.CNF.connectTo(CNF);
    Control.RELEASE.connectTo(RELEASE);
    ped.EO.connectTo(TimerYellow.START);
    GreenTimer.EO.connectTo(GREENTIMER.CD);
    GREENTIMER.START_Y.connectTo(Control.T1);
    GREENTIMER.START_Y.connectTo(TimerYellow.START);
    GreenTimer.EO.connectTo(TimeLeft.REQ);
    TimeLeft.connectIVNoException("IN",GREENTIMER.ovNamedNoException("CV"));
    TimerYellow.DT.initializeNoException("t#1s");
    TimeLeft.TYPE.initializeNoException("UINT");
    TimeLeft.LABEL.initializeNoException("TIME LEFT");
    TimeLeft.W.initializeNoException("1");
    GreenTimer.DT.initializeNoException("t#1s");
    GREENTIMER.XTIME.initializeNoException("5");
    GREENTIMER.MING.initializeNoException("4");
  }
	/**
 * {@inheritDoc}
 * @param newVar {@inheritDoc}
 */
@Override
protected void connectInternal(ANY newVar) {
}
/** start the FB instances. */
public void start( ){
    super.start();
  Control.start();
  TimerYellow.start();
  TimeLeft.start();
  GreenTimer.start();
  ped.start();
  GREENTIMER.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  Control.stop();
  TimerYellow.stop();
  TimeLeft.stop();
  GreenTimer.stop();
  ped.stop();
  GREENTIMER.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  Control.kill();
  TimerYellow.kill();
  TimeLeft.kill();
  GreenTimer.kill();
  ped.kill();
  GREENTIMER.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  Control.reset();
  TimerYellow.reset();
  TimeLeft.reset();
  GreenTimer.reset();
  ped.reset();
  GREENTIMER.reset();
}
protected synchronized void service_INIT(){
   Control.INIT.serviceEvent(this);
   TimeLeft.INIT.serviceEvent(this);
   Control.INIT.serviceEvent(this);
   TimeLeft.INIT.serviceEvent(this);
}
protected synchronized void service_REQ(){
   Control.T0.serviceEvent(this);
   GreenTimer.START.serviceEvent(this);
   GREENTIMER.LD.serviceEvent(this);
   Control.T0.serviceEvent(this);
   GreenTimer.START.serviceEvent(this);
   GREENTIMER.LD.serviceEvent(this);
}
protected synchronized void service_PEDCROSS(){
   ped.EI.serviceEvent(this);
   ped.EI.serviceEvent(this);
}
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    Control.initialize("Control",r);
    TimerYellow.initialize("TimerYellow",r);
    TimeLeft.initialize("TimeLeft",r);
    GreenTimer.initialize("GreenTimer",r);
    ped.initialize("ped",r);
    GREENTIMER.initialize("GREENTIMER",r);
}
}
