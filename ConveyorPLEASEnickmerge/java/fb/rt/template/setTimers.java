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
/** FB GreenTimer1:GREENTIMER */
  protected GREENTIMER GreenTimer1 = new GREENTIMER() ;
/** FB blah:OUT_BOOL */
  protected OUT_BOOL blah = new OUT_BOOL() ;
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
    GreenTimer.EO.connectTo(TimeLeft.REQ);
    TimerYellow.EO.connectTo(Control.T2);
    Control.INITO.connectTo(INITO);
    Control.CNF.connectTo(CNF);
    Control.RELEASE.connectTo(RELEASE);
    GreenTimer.EO.connectTo(TimeLeft.REQ);
    GreenTimer.EO.connectTo(GreenTimer1.CD);
    GreenTimer1.START_Y.connectTo(Control.T1);
    GreenTimer1.START_Y.connectTo(TimerYellow.START);
    GreenTimer.EO.connectTo(blah.REQ);
    TimeLeft.connectIVNoException("IN",GreenTimer1.ovNamedNoException("CV"));
    blah.connectIVNoException("IN",GreenTimer1.ovNamedNoException("MIN_RCHD"));
    TimerYellow.DT.initializeNoException("t#1s");
    TimeLeft.TYPE.initializeNoException("UINT");
    TimeLeft.LABEL.initializeNoException("TIME LEFT");
    TimeLeft.W.initializeNoException("1");
    GreenTimer.DT.initializeNoException("t#1s");
    GreenTimer1.XTIME.initializeNoException("7");
    GreenTimer1.MING.initializeNoException("5");
    blah.C1.initializeNoException("[0,0,255]");
    blah.C0.initializeNoException("[0,0,0]");
    blah.LABEL.initializeNoException("min");
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
  GreenTimer1.start();
  blah.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  Control.stop();
  TimerYellow.stop();
  TimeLeft.stop();
  GreenTimer.stop();
  GreenTimer1.stop();
  blah.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  Control.kill();
  TimerYellow.kill();
  TimeLeft.kill();
  GreenTimer.kill();
  GreenTimer1.kill();
  blah.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  Control.reset();
  TimerYellow.reset();
  TimeLeft.reset();
  GreenTimer.reset();
  GreenTimer1.reset();
  blah.reset();
}
protected synchronized void service_INIT(){
   Control.INIT.serviceEvent(this);
   TimeLeft.INIT.serviceEvent(this);
   Control.INIT.serviceEvent(this);
   TimeLeft.INIT.serviceEvent(this);
   blah.INIT.serviceEvent(this);
}
protected synchronized void service_REQ(){
   Control.T0.serviceEvent(this);
   GreenTimer.START.serviceEvent(this);
   Control.T0.serviceEvent(this);
   GreenTimer.START.serviceEvent(this);
   GreenTimer1.LD.serviceEvent(this);
}
protected synchronized void service_PEDCROSS(){
   GreenTimer1.PEDCROSS.serviceEvent(this);
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
    GreenTimer1.initialize("GreenTimer1",r);
    blah.initialize("blah",r);
}
}
