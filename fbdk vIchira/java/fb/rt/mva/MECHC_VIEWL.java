/* Copyright (c)2019 Holobloc Inc. All rights reserved. */
package fb.rt.mva; import fb.rt.net.*; import fb.rt.hmi.VDIR;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
import fb.rt.hmi.*;
import fb.rt.net.*;
/** FUNCTION_BLOCK MECHC_VIEWL (* Linear Mechanism View with Clamping & Local Data Publish/Subscribe *)
  * @author JHC
  * @version 20190331/JHC - Generated.
  */
public class MECHC_VIEWL extends FBMVCD {
/** Initialized */
public final EventOutput INITO = new EventOutput();
/** Initialize */
public final EventServer INIT = (e) -> service_INIT();
/** FB REND:SUBL_4 */
  protected SUBL REND = new SUBL(4);
/** FB VIEW:MECHC_VIEW */
  protected MECHC_VIEW VIEW = new MECHC_VIEW() ;
/** FB UI:PUBL_1 */
  protected PUBL UI = new PUBL(1);
/** Rendering Data Channel from Model */
  public WSTRING REND_ID = new WSTRING();
/** User Input Channel to Model */
  public WSTRING UI_ID = new WSTRING();
/** 0=Paint workpiece with clamp,1=Paint as conveyor with gate at end. */
  public BOOL CNV = new BOOL();
/** Background Color */
  public COLOR BKGD = new COLOR("blue");
/** Length in Diameters */
  public UINT LEN = new UINT();
/** Diameter */
  public UINT DIA = new UINT();
/** Orientation */
  public VDIR DIR = new VDIR();
/** The default constructor. */
public MECHC_VIEWL(){
    super();
    REND.INITO.connectTo(VIEW.INIT);
    VIEW.INITO.connectTo(UI.INIT);
    UI.INITO.connectTo(INITO);
    REND.IND.connectTo(VIEW.REQ);
    VIEW.IND.connectTo(UI.REQ);
    REND.connectOVNoException("RD_1",VIEW.POS);
    UI.connectIVNoException("SD_1",VIEW.ovNamedNoException("FAULT"));
    REND.connectIVNoException("ID",REND_ID);
    UI.connectIVNoException("ID",UI_ID);
    VIEW.connectIVNoException("BKGD",BKGD);
    VIEW.connectIVNoException("LEN",LEN);
    VIEW.connectIVNoException("DIA",DIA);
    VIEW.connectIVNoException("DIR",DIR);
    REND.connectOVNoException("RD_3",VIEW.WKPC);
    REND.connectOVNoException("RD_4",VIEW.CLAMP);
    VIEW.connectIVNoException("CNV",CNV);
    REND.connectOVNoException("RD_2",VIEW.STYLE);
  }
	/**
 * {@inheritDoc}
 * @param newVar {@inheritDoc}
 */
@Override
protected void connectInternal(ANY newVar) {
  if(newVar == REND_ID)
    REND.connectIVNoException("ID",REND_ID);
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
  if(newVar == CNV)
    VIEW.connectIVNoException("CNV",CNV);
}
/** start the FB instances. */
public void start( ){
    super.start();
  REND.start();
  VIEW.start();
  UI.start();
}
/** stop the FB instances. */
public void stop( ){
    super.stop();
  REND.stop();
  VIEW.stop();
  UI.stop();
}
/** kill the FB instances. */
public void kill( ){
    super.kill();
  REND.kill();
  VIEW.kill();
  UI.kill();
}
/** reset the FB instances. */
public void reset( ){
    super.reset();
  REND.reset();
  VIEW.reset();
  UI.reset();
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
    REND.initialize("REND",r);
    VIEW.initialize("VIEW",r);
    UI.initialize("UI",r);
}
}
