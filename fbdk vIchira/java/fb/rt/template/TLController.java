/* Copyright (c)2019 Rockwell Automation. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK TLController (* Composite Function Block Type *)
  * @author JHC
  * @version 20190330/JHC - Generated.
  */
public class TLController extends fb.rt.FBInstance {
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** EVENT TokenOut */
public final EventOutput TokenOut = new EventOutput();
/** EVENT CNF */
public final EventOutput CNF = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** EVENT TokenIn */
public final EventServer TokenIn = (e) -> service_TokenIn();
/** EVENT PEDCROSSBUT */
public final EventServer PEDCROSSBUT = (e) -> service_PEDCROSSBUT();
/** FB ButPressCTR:E_CTU */
  protected E_CTU ButPressCTR = new E_CTU() ;
/** FB CLOCK:E_CYCLE */
  protected E_CYCLE CLOCK = new E_CYCLE() ;
/** FB Split1:E_SPLIT */
  protected E_SPLIT Split1 = new E_SPLIT() ;
/** FB Controller1:Controller */
  protected Controller Controller1 = new Controller() ;
/** VAR GREENTIME:UINT */
  public UINT GREENTIME = new UINT();
/** VAR MINGREENTIME:UINT */
  public UINT MINGREENTIME = new UINT();
/** VAR YELLOWTIME:UINT */
  public UINT YELLOWTIME = new UINT();
/** VAR RED:BOOL */
  public final BOOL RED = (BOOL)Controller1.RED;
/** VAR YELLOW:BOOL */
  public final BOOL YELLOW = (BOOL)Controller1.YELLOW;
/** VAR GREEN:BOOL */
  public final BOOL GREEN = (BOOL)Controller1.GREEN;
/** VAR GreenRming:UINT */
  public final UINT GreenRming = (UINT)Controller1.GREENREMAINING;
/** The default constructor. */
public TLController(){
    super();
    Split1.EO1.connectTo(TokenOut);
    Split1.EO2.connectTo(CLOCK.STOP);
    CLOCK.EO.connectTo(Controller1.CLK);
    Controller1.INITO.connectTo(INITO);
    Controller1.CNF.connectTo(CNF);
    Controller1.connectIVNoException("PEDCROSS",ButPressCTR.ovNamedNoException("Q"));
    Controller1.connectIVNoException("GREENTIME",GREENTIME);
    Controller1.connectIVNoException("MINGREENTIME",MINGREENTIME);
    Controller1.connectIVNoException("YELLOWTIME",YELLOWTIME);
    ButPressCTR.PV.initializeNoException("4");
    CLOCK.DT.initializeNoException("t#1s");
  }
	/**
 * {@inheritDoc}
 * @param newVar {@inheritDoc}
 */
@Override
protected void connectInternal(ANY newVar) {
  if(newVar == GREENTIME)
    Controller1.connectIVNoException("GREENTIME",GREENTIME);
  if(newVar == MINGREENTIME)
    Controller1.connectIVNoException("MINGREENTIME",MINGREENTIME);
  if(newVar == YELLOWTIME)
    Controller1.connectIVNoException("YELLOWTIME",YELLOWTIME);
}
/** start the FB instances. */
public void start( ){
    super.start();
  ButPressCTR.start();
  CLOCK.start();
  Split1.start();
  Controller1.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  ButPressCTR.stop();
  CLOCK.stop();
  Split1.stop();
  Controller1.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  ButPressCTR.kill();
  CLOCK.kill();
  Split1.kill();
  Controller1.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  ButPressCTR.reset();
  CLOCK.reset();
  Split1.reset();
  Controller1.reset();
}
protected synchronized void service_INIT(){
   CLOCK.START.serviceEvent(this);
   Controller1.INIT.serviceEvent(this);
}
protected synchronized void service_TokenIn(){
   CLOCK.START.serviceEvent(this);
   Controller1.LD.serviceEvent(this);
}
protected synchronized void service_PEDCROSSBUT(){
   ButPressCTR.CU.serviceEvent(this);
}
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    ButPressCTR.initialize("ButPressCTR",r);
    CLOCK.initialize("CLOCK",r);
    Split1.initialize("Split1",r);
    Controller1.initialize("Controller1",r);
}
}
