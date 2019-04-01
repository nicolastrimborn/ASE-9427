/* Copyright (c)2019 Rockwell Automation. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK TLController_Centralised (* Composite Function Block Type *)
  * @author JHC
  * @version 20190401/JHC - Generated.
  */
public class TLController_Centralised extends fb.rt.FBInstance {
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** EVENT CNF */
public final EventOutput CNF = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** EVENT START */
public final EventServer START = (e) -> service_START();
/** FB CLOCK:E_CYCLE */
  protected E_CYCLE CLOCK = new E_CYCLE() ;
/** FB CONTROLLER:ControllerCentralised */
  protected ControllerCentralised CONTROLLER = new ControllerCentralised() ;
/** VAR GREENTIME:UINT */
  public UINT GREENTIME = new UINT();
/** VAR MINGREENTIME:UINT */
  public UINT MINGREENTIME = new UINT();
/** VAR YELLOWTIME:UINT */
  public UINT YELLOWTIME = new UINT();
/** VAR RED1:BOOL */
  public final BOOL RED1 = (BOOL)CONTROLLER.RED1;
/** VAR YELLOW1:BOOL */
  public final BOOL YELLOW1 = (BOOL)CONTROLLER.YELLOW1;
/** VAR GREEN1:BOOL */
  public final BOOL GREEN1 = (BOOL)CONTROLLER.GREEN1;
/** VAR RT1:UINT */
  public final UINT RT1 = (UINT)CONTROLLER.RT1;
/** VAR RED2:BOOL */
  public final BOOL RED2 = (BOOL)CONTROLLER.RED2;
/** VAR YELLOW2:BOOL */
  public final BOOL YELLOW2 = (BOOL)CONTROLLER.YELLOW2;
/** VAR GREEN2:BOOL */
  public final BOOL GREEN2 = (BOOL)CONTROLLER.GREEN2;
/** VAR RT2:UINT */
  public final UINT RT2 = (UINT)CONTROLLER.RT2;
/** The default constructor. */
public TLController_Centralised(){
    super();
    CLOCK.EO.connectTo(CONTROLLER.CLK);
    CONTROLLER.INITO.connectTo(INITO);
    CONTROLLER.CNF.connectTo(CNF);
    CONTROLLER.connectIVNoException("GREENTIME",GREENTIME);
    CONTROLLER.connectIVNoException("MINGREENTIME",MINGREENTIME);
    CONTROLLER.connectIVNoException("YELLOWTIME",YELLOWTIME);
    CLOCK.DT.initializeNoException("t#1s");
  }
	/**
 * {@inheritDoc}
 * @param newVar {@inheritDoc}
 */
@Override
protected void connectInternal(ANY newVar) {
  if(newVar == GREENTIME)
    CONTROLLER.connectIVNoException("GREENTIME",GREENTIME);
  if(newVar == MINGREENTIME)
    CONTROLLER.connectIVNoException("MINGREENTIME",MINGREENTIME);
  if(newVar == YELLOWTIME)
    CONTROLLER.connectIVNoException("YELLOWTIME",YELLOWTIME);
}
/** start the FB instances. */
public void start( ){
    super.start();
  CLOCK.start();
  CONTROLLER.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  CLOCK.stop();
  CONTROLLER.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  CLOCK.kill();
  CONTROLLER.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  CLOCK.reset();
  CONTROLLER.reset();
}
protected synchronized void service_INIT(){
   CONTROLLER.INIT.serviceEvent(this);
}
protected synchronized void service_START(){
   CLOCK.START.serviceEvent(this);
   CONTROLLER.LD.serviceEvent(this);
}
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    CLOCK.initialize("CLOCK",r);
    CONTROLLER.initialize("CONTROLLER",r);
}
}
