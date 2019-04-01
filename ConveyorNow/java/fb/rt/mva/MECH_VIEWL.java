/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.mva; import fb.rt.net.*; import fb.rt.hmi.*;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
import fb.rt.hmi.*;
import fb.rt.net.*;
/** FUNCTION_BLOCK MECH_VIEWL (* Linear Mechanism View with Local Data Publish/Subscribe *)
  * @author JHC
  * @version 20190401/JHC - Generated.
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
/** FB REND:SUBL_3 */
  protected SUBL REND = new SUBL(3);
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
    REND.INITO.connectTo(VIEW.INIT);
    REND.IND.connectTo(VIEW.REQ);
    UI.connectIVNoException("SD_1",VIEW.ovNamedNoException("FAULT"));
    UI.connectIVNoException("ID",UI_ID);
    VIEW.connectIVNoException("BKGD",BKGD);
    VIEW.connectIVNoException("LEN",LEN);
    VIEW.connectIVNoException("DIA",DIA);
    VIEW.connectIVNoException("DIR",DIR);
    REND.connectOVNoException("RD_1",VIEW.POS);
    REND.connectOVNoException("RD_2",VIEW.STYLE);
    REND.connectOVNoException("RD_3",VIEW.WKPC);
    REND.connectIVNoException("ID",REND_ID);
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
    REND.connectIVNoException("ID",REND_ID);
}
/** start the FB instances. */
public void start( ){
    super.start();
  VIEW.start();
  UI.start();
  REND.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  VIEW.stop();
  UI.stop();
  REND.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  VIEW.kill();
  UI.kill();
  REND.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  VIEW.reset();
  UI.reset();
  REND.reset();
}
protected synchronized void service_INIT(){
   REND.INIT.serviceEvent(this);
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
    REND.initialize("REND",r);
}
}
