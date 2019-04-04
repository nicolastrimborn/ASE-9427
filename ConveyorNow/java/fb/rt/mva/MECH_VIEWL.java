/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.mva; import fb.rt.net.*; import fb.rt.hmi.*;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
import fb.rt.hmi.*;
import fb.rt.net.*;
/** FUNCTION_BLOCK MECH_VIEWL (* Linear Mechanism View with Local Data Publish/Subscribe *)
  * @author JHC
  * @version 20190403/JHC - Generated.
  */
public class MECH_VIEWL extends FBMVCD {
/** Initialized */
public final EventOutput INITO = new EventOutput();
/** Initialize */
public final EventServer INIT = (e) -> service_INIT();
/** FB VIEW:MECH_VIEW */
  protected MECH_VIEW VIEW = new MECH_VIEW() ;
/** FB UI:PUBL_1 */
  protected PUBL UI = new PUBL(1);
/** FB REND2:SUBL_4 */
  protected SUBL REND2 = new SUBL(4);
/** Rendering Data Channel from Model */
  public WSTRING REND_ID = new WSTRING();
/** User Input Channel to Model */
  public WSTRING UI_ID = new WSTRING();
/** Background Color */
  public COLOR BKGD = new COLOR("blue");
/** Length in Diameters */
  public UINT LEN = new UINT();
/** Diameter */
  public UINT DIA = new UINT();
/** Orientation */
  public VDIR DIR = new VDIR();
/** The default constructor. */
public MECH_VIEWL(){
    super();
    VIEW.INITO.connectTo(UI.INIT);
    UI.INITO.connectTo(INITO);
    VIEW.IND.connectTo(UI.REQ);
    REND2.INITO.connectTo(VIEW.INIT);
    REND2.IND.connectTo(VIEW.REQ);
    UI.connectIVNoException("SD_1",VIEW.ovNamedNoException("FAULT"));
    UI.connectIVNoException("ID",UI_ID);
    VIEW.connectIVNoException("BKGD",BKGD);
    VIEW.connectIVNoException("LEN",LEN);
    VIEW.connectIVNoException("DIA",DIA);
    VIEW.connectIVNoException("DIR",DIR);
    REND2.connectIVNoException("ID",REND_ID);
    REND2.connectOVNoException("RD_2",VIEW.POS);
    REND2.connectOVNoException("RD_3",VIEW.STYLE);
    REND2.connectOVNoException("RD_4",VIEW.WKPC);
  }
	/**
 * {@inheritDoc}
 * @param newVar {@inheritDoc}
 */
@Override
protected void connectInternal(ANY newVar) {
  if(newVar == UI_ID)
    UI.connectIVNoException("ID",UI_ID);
  if(newVar == BKGD)
    VIEW.connectIVNoException("BKGD",BKGD);
  if(newVar == LEN)
    VIEW.connectIVNoException("LEN",LEN);
  if(newVar == DIA)
    VIEW.connectIVNoException("DIA",DIA);
  if(newVar == DIR)
    VIEW.connectIVNoException("DIR",DIR);
  if(newVar == REND_ID)
    REND2.connectIVNoException("ID",REND_ID);
}
/** start the FB instances. */
public void start( ){
    super.start();
  VIEW.start();
  UI.start();
  REND2.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  VIEW.stop();
  UI.stop();
  REND2.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  VIEW.kill();
  UI.kill();
  REND2.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  VIEW.reset();
  UI.reset();
  REND2.reset();
}
protected synchronized void service_INIT(){
   REND2.INIT.serviceEvent(this);
}
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    VIEW.initialize("VIEW",r);
    UI.initialize("UI",r);
    REND2.initialize("REND2",r);
}
}
