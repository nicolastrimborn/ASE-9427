/* Copyright (c)2019 Rockwell Automation. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK ADD_DELAY (* Composite Function Block Type *)
  * @author JHC
  * @version 20190401/JHC - Generated.
  */
public class ADD_DELAY extends fb.rt.FBInstance {
/** Execution Confirmation */
public final EventOutput CNF1 = new EventOutput();
/** EVENT CNF2 */
public final EventOutput CNF2 = new EventOutput();
/** EVENT INIT */
public final EventServer INIT = (e) -> service_INIT();
/** EVENT REQ */
public final EventServer REQ = (e) -> service_REQ();
/** FB DLY:E_DELAY */
  protected E_DELAY DLY = new E_DELAY() ;
/** FB test:E_R_TRIG */
  protected E_R_TRIG test = new E_R_TRIG() ;
/** FB PASS_IT_ON:Basic */
  protected Basic PASS_IT_ON = new Basic() ;
/** Input event qualifier */
  public BOOL QI = new BOOL();
/** VAR CI:COLOR */
  public COLOR CI = new COLOR();
/** Output event qualifier */
  public final BOOL QO = (BOOL)PASS_IT_ON.QO;
/** VAR CO:COLOR */
  public final COLOR CO = (COLOR)PASS_IT_ON.CO;
/** The default constructor. */
public ADD_DELAY(){
    super();
    DLY.EO.connectTo(CNF2);
    test.EO.connectTo(CNF1);
    test.EO.connectTo(PASS_IT_ON.REQ);
    DLY.EO.connectTo(PASS_IT_ON.REQ);
    PASS_IT_ON.connectIVNoException("QI",QI);
    PASS_IT_ON.connectIVNoException("CI",CI);
    DLY.DT.initializeNoException("t#2s");
    test.QI.initializeNoException("1");
  }
	/**
 * {@inheritDoc}
 * @param newVar {@inheritDoc}
 */
@Override
protected void connectInternal(ANY newVar) {
  if(newVar == QI)
    PASS_IT_ON.connectIVNoException("QI",QI);
  if(newVar == CI)
    PASS_IT_ON.connectIVNoException("CI",CI);
}
/** start the FB instances. */
public void start( ){
    super.start();
  DLY.start();
  test.start();
  PASS_IT_ON.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  DLY.stop();
  test.stop();
  PASS_IT_ON.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  DLY.kill();
  test.kill();
  PASS_IT_ON.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  DLY.reset();
  test.reset();
  PASS_IT_ON.reset();
}
protected synchronized void service_INIT(){
   PASS_IT_ON.INIT.serviceEvent(this);
}
protected synchronized void service_REQ(){
   test.EI.serviceEvent(this);
   DLY.START.serviceEvent(this);
}
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    DLY.initialize("DLY",r);
    test.initialize("test",r);
    PASS_IT_ON.initialize("PASS_IT_ON",r);
}
}
