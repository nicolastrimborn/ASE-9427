/* Copyright (c)2019 Rockwell Automation. All rights reserved. */
package fb.rt.template;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
import fb.rt.hmi.*;
/** FUNCTION_BLOCK CoinButtonsComposite (* Composite Function Block Type *)
  * @author JHC
  * @version 20190318/JHC - Generated.
  */
public class CoinButtonsComposite extends fb.rt.FBInstance {
/** Initialization Confirm */
public final EventOutput INITO = new EventOutput();
/** EVENT Coin1Evt */
public final EventOutput Coin1Evt = new EventOutput();
/** EVENT Coin5Evt */
public final EventOutput Coin5Evt = new EventOutput();
/** Initialization Request */
public final EventServer INIT = (e) -> service_INIT();
/** FB Coin5Event:IN_EVENT */
  protected IN_EVENT Coin5Event = new IN_EVENT() ;
/** FB Coin1Event:IN_EVENT */
  protected IN_EVENT Coin1Event = new IN_EVENT() ;
/** The default constructor. */
public CoinButtonsComposite(){
    super();
    Coin5Event.IND.connectTo(Coin5Evt);
    Coin1Event.IND.connectTo(Coin1Evt);
    Coin5Event.INITO.connectTo(INITO);
    Coin1Event.INITO.connectTo(Coin5Event.INIT);
    Coin5Event.LABEL.initializeNoException("5 euro");
    Coin1Event.LABEL.initializeNoException("1 euro");
  }
/** start the FB instances. */
public void start( ){
    super.start();
  Coin5Event.start();
  Coin1Event.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  Coin5Event.stop();
  Coin1Event.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  Coin5Event.kill();
  Coin1Event.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  Coin5Event.reset();
  Coin1Event.reset();
}
protected synchronized void service_INIT(){
   Coin1Event.INIT.serviceEvent(this);
}
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    Coin5Event.initialize("Coin5Event",r);
    Coin1Event.initialize("Coin1Event",r);
}
}
