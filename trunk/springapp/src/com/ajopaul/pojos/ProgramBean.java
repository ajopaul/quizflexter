package com.ajopaul.pojos;

import java.util.HashMap;
import java.util.Map;

public class ProgramBean {

  private int ProgramId;
  private String DefIssueTime="";
  private String DefStartTime="";
  private int DefEventDur=0;
  private String DefTolStartTime="";
  private String DefTolStartAfterTime="";
  private String MinIssueStart="";
  private String ProgramName="";
  private String ShortName="";
  private String UtilityName="";
  private int Priority=0;
  private boolean TestProgram;
  private boolean CommProgram;
  private boolean EmDispatch;
  private boolean DayAheadDispatch;
  private String Description="";
  private String ProgramType="";
  private String VenPushLevel="";
  //private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * @return the programId
   */
  public int getProgramId()
  {
    return ProgramId;
  }

  /**
   * @param programId the programId to set
   */
  public void setProgramId(int programId)
  {
    ProgramId = programId;
  }

  /**
   * 
   * @return
   * The DefIssueTime
   */
  public String getDefIssueTime() {
    return DefIssueTime;
  }

  /**
   * 
   * @param DefIssueTime
   * The DefIssueTime
   */
  public void setDefIssueTime(String DefIssueTime) {
    this.DefIssueTime = DefIssueTime;
  }

  /**
   * 
   * @return
   * The DefStartTime
   */
  public String getDefStartTime() {
    return DefStartTime;
  }

  /**
   * 
   * @param DefStartTime
   * The DefStartTime
   */
  public void setDefStartTime(String DefStartTime) {
    this.DefStartTime = DefStartTime;
  }

  /**
   * 
   * @return
   * The DefEventDur
   */
  public int getDefEventDur() {
    return DefEventDur;
  }

  /**
   * 
   * @param DefEventDur
   * The DefEventDur
   */
  public void setDefEventDur(int DefEventDur) {
    this.DefEventDur = DefEventDur;
  }

  /**
   * 
   * @return
   * The DefTolStartTime
   */
  public String getDefTolStartTime() {
    return DefTolStartTime;
  }

  /**
   * 
   * @param DefTolStartTime
   * The DefTolStartTime
   */
  public void setDefTolStartTime(String DefTolStartTime) {
    this.DefTolStartTime = DefTolStartTime;
  }

  /**
   * 
   * @return
   * The DefTolStartAfterTime
   */
  public String getDefTolStartAfterTime() {
    return DefTolStartAfterTime;
  }

  /**
   * 
   * @param DefTolStartAfterTime
   * The DefTolStartAfterTime
   */
  public void setDefTolStartAfterTime(String DefTolStartAfterTime) {
    this.DefTolStartAfterTime = DefTolStartAfterTime;
  }

  /**
   * 
   * @return
   * The MinIssueStart
   */
  public String getMinIssueStart() {
    return MinIssueStart;
  }

  /**
   * 
   * @param MinIssueStart
   * The MinIssueStart
   */
  public void setMinIssueStart(String MinIssueStart) {
    this.MinIssueStart = MinIssueStart;
  }

 

  /**
   * @return the programName
   */
  public String getProgramName()
  {
    return ProgramName;
  }

  /**
   * @param programName the programName to set
   */
  public void setProgramName(String programName)
  {
    ProgramName = programName;
  }

  /**
   * @return the shortName
   */
  public String getShortName()
  {
    return ShortName;
  }

  /**
   * @param shortName the shortName to set
   */
  public void setShortName(String shortName)
  {
    ShortName = shortName;
  }

  /**
   * @return the utilityName
   */
  public String getUtilityName()
  {
    return UtilityName;
  }

  /**
   * @param utilityName the utilityName to set
   */
  public void setUtilityName(String utilityName)
  {
    UtilityName = utilityName;
  }

  /**
   * @return the priority
   */
  public int getPriority()
  {
    return Priority;
  }

  /**
   * @param priority the priority to set
   */
  public void setPriority(int priority)
  {
    Priority = priority;
  }
/*
  *//**
   * @param additionalProperties the additionalProperties to set
   *//*
  public void setAdditionalProperties(Map<String, Object> additionalProperties)
  {
    this.additionalProperties = additionalProperties;
  }
*/
  /**
   * 
   * @return
   * The TestProgram
   */
  public boolean getTestProgram() {
    return TestProgram;
  }

  /**
   * 
   * @param TestProgram
   * The TestProgram
   */
  public void setTestProgram(boolean TestProgram) {
    this.TestProgram = TestProgram;
  }

  /**
   * 
   * @return
   * The CommProgram
   */
  public boolean getCommProgram() {
    return CommProgram;
  }

  /**
   * 
   * @param CommProgram
   * The CommProgram
   */
  public void setCommProgram(boolean CommProgram) {
    this.CommProgram = CommProgram;
  }

  /**
   * 
   * @return
   * The EmDispatch
   */
  public boolean getEmDispatch() {
    return EmDispatch;
  }

  /**
   * 
   * @param EmDispatch
   * The EmDispatch
   */
  public void setEmDispatch(boolean EmDispatch) {
    this.EmDispatch = EmDispatch;
  }

  /**
   * 
   * @return
   * The DayAheadDispatch
   */
  public boolean getDayAheadDispatch() {
    return DayAheadDispatch;
  }

  /**
   * 
   * @param DayAheadDispatch
   * The DayAheadDispatch
   */
  public void setDayAheadDispatch(boolean DayAheadDispatch) {
    this.DayAheadDispatch = DayAheadDispatch;
  }

  /**
   * 
   * @return
   * The Description
   */
  public String getDescription() {
    return Description;
  }

  /**
   * 
   * @param Description
   * The Description
   */
  public void setDescription(String Description) {
    this.Description = Description;
  }

  /**
   * 
   * @return
   * The ProgramType
   */
  public String getProgramType() {
    return ProgramType;
  }

  /**
   * 
   * @param ProgramType
   * The ProgramType
   */
  public void setProgramType(String ProgramType) {
    this.ProgramType = ProgramType;
  }

  /**
   * 
   * @return
   * The VenPushLevel
   */
  public String getVenPushLevel() {
    return VenPushLevel;
  }

  /**
   * 
   * @param VenPushLevel
   * The VenPushLevel
   */
  public void setVenPushLevel(String VenPushLevel) {
    this.VenPushLevel = VenPushLevel;
  }

/*  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }*/

}
