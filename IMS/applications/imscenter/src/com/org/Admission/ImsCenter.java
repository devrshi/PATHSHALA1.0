package com.org.Admission;

import java.util.Locale;
import java.util.Map;

import org.ofbiz.base.util.Debug;
import org.ofbiz.base.util.UtilDateTime;
import org.ofbiz.base.util.UtilMisc;
import org.ofbiz.base.util.UtilProperties;
import org.ofbiz.base.util.UtilValidate;
import org.ofbiz.entity.GenericDelegator;
import org.ofbiz.entity.GenericEntityException;
import org.ofbiz.entity.GenericValue;
import org.ofbiz.service.DispatchContext;
import org.ofbiz.service.GenericServiceException;
import org.ofbiz.service.LocalDispatcher;
import org.ofbiz.service.ServiceUtil;

import javolution.util.FastMap;

public class ImsCenter {
	  public static final  String resource = "imsCenterUiLabels";
	
	public static Map<String, Object> studentRegistration(DispatchContext dctx,
			Map<String, ? extends Object> context) {
			Map<String, Object> result = ServiceUtil.returnSuccess();
			GenericDelegator delegator = (GenericDelegator)dctx.getDelegator();
			GenericValue userLogin = (GenericValue) context.get("userLogin");
			LocalDispatcher dispatcher = dctx.getDispatcher();
			Locale locale = (Locale) context.get("locale");
			String instId = (String) context.get("instId");
			
			String salutation = (String) context.get("salutation");
			String stName = (String) context.get("stName");
			String stCourse = (String) context.get("stCourse");
			String stFatherName = (String) context.get("stFatherName");
			String stMotherName = (String) context.get("stMotherName");
			String sex = (String) context.get("sex");
			String religion = (String) context.get("religion");
			String caste = (String) context.get("caste");
			
			String nationality = (String) context.get("nationality");
			String qualifyingExam = (String) context.get("qualifyingExam");
			String lastAttended = (String) context.get("lastAttended");
			String enrollmentNo = (String) context.get("enrollmentNo");
			String receiptNo = (String) context.get("receiptNo");
			
			String address1 = (String) context.get("address1");
			String address2 = (String) context.get("address2");
			String state = (String) context.get("state");
			String district = (String) context.get("district");
			String city = (String) context.get("city");
			String pincode = (String) context.get("pincode");
			String mobileNo = (String) context.get("mobileNo");
			String email = (String) context.get("email");
			
			Map<String,Object> postalMap = FastMap.newInstance();
			Map<String,Object> inMap = FastMap.newInstance();
			Map<String, Object> outMap = FastMap.newInstance();
			String postalContactId = null;
			
			try
			{
		    // Create party And relation ship with INST
				
			String studentId = delegator.getNextSeqId("Party");
			GenericValue studentSave = delegator.makeValue("Party", 
                    UtilMisc.toMap("partyId",studentId,
                 		           "partyTypeId", "PERSON"));
			delegator.create(studentSave);
			GenericValue createRole = delegator.makeValue("PartyRole", 
                    UtilMisc.toMap("partyId",studentId,
                 		           "roleTypeId", "STUDENT"));
			delegator.create(createRole);
			GenericValue createRelation = delegator.makeValue("PartyRelationship", 
                    UtilMisc.toMap("partyIdFrom",studentId,
                 		           "partyIdTo", instId,
                 		           "roleTypeIdFrom","STUDENT","roleTypeIdTo","_NA_","fromDate", UtilDateTime.nowTimestamp()));
			delegator.create(createRelation);
			
			// Create Person
			GenericValue stPersonalDetails = delegator.makeValue("Person", 
                    UtilMisc.toMap("partyId",studentId,"salutation",salutation,
                 		            "firstName",stName,"gender",sex,
                 		            "fatherName",stFatherName,"caste",caste,
                 		            "motherName",stMotherName,"religion",religion));
			delegator.create(stPersonalDetails);
			
	       // Create Address
			    postalMap.put("userLogin", userLogin);
	            postalMap.put("fromDate", UtilDateTime.nowTimestamp());
	            postalMap.put("address1",address1);
	            postalMap.put("address2",address2);
	            postalMap.put("stateProvinceGeoId",state);
	            postalMap.put("countyGeoId",district);
	            postalMap.put("countryGeoId",nationality);
	            postalMap.put("city",city);
	            postalMap.put("postalCode",pincode);
	            postalMap.put("partyId", studentId);
	            
	            
	            try {
	                outMap = dispatcher.runSync("createPartyPostalAddress", postalMap);
	                postalContactId = (String) outMap.get("contactMechId");
	            } catch (GenericServiceException e) {
	                Debug.log(e);
	            }
			
	            inMap.clear();
	            inMap.put("userLogin", userLogin);
	            inMap.put("contactMechId", postalContactId);
	            inMap.put("partyId", studentId);
	            try {
	                    inMap.put("contactMechPurposeTypeId", "PRIMARY_LOCATION");
	                    dispatcher.runSync("createPartyContactMechPurpose", inMap);
	            } catch (GenericServiceException e) {
	                // Not the end of the world, we'll carry on
	                Debug.log(e.getMessage());
	            }
	            
	            if (UtilValidate.isNotEmpty(email)) {
	                inMap.clear();
	                inMap.put("userLogin", userLogin);
	                inMap.put("contactMechPurposeTypeId", "PRIMARY_EMAIL");
	                inMap.put("emailAddress", email);
	                inMap.put("partyId", studentId);
	                inMap.put("verified", "Y");  // Going to assume PayPal has taken care of this for us
	                inMap.put("fromDate", UtilDateTime.nowTimestamp());
	                try {
	                    outMap = dispatcher.runSync("createPartyEmailAddress", inMap);
	                   /* emailContactMechId = (String) outMap.get("contactMechId");*/
	                } catch (GenericServiceException e) {
	                    Debug.log(e);
	                }
	            }
	            if (UtilValidate.isNotEmpty(mobileNo)) {
	            inMap.clear();
	            inMap.put("userLogin", userLogin);
	            inMap.put("partyId", studentId);
	            inMap.put("contactNumber",mobileNo);
	            try {
	                outMap = dispatcher.runSync("createUpdatePartyTelecomNumber", inMap);
	               
	            } catch (GenericServiceException e) {
	                Debug.log(e);
	            }
	           }
	            // Create Student Other Details.
	            String studentDetailId = delegator.getNextSeqId("StudentDetails");
	            GenericValue stDetails = delegator.makeValue("StudentDetails", 
	                    UtilMisc.toMap("studentDetailId",studentDetailId,"studentId",studentId,"qualifyingExam",qualifyingExam,
	                 		            "lastAttended",lastAttended,"enrollmentNo",enrollmentNo,
	                 		            "receiptNo",receiptNo));
				delegator.create(stDetails);
				String studentCourseId = delegator.getNextSeqId("StudentCourse");
				GenericValue stCourseDetails = delegator.makeValue("StudentCourse", 
	                    UtilMisc.toMap("studentCourseId",studentCourseId,"studentId",studentId,
	                    		       "courseId",stCourse));
				delegator.create(stCourseDetails);
			}catch(GenericEntityException e)
			{
				
			}
			result.put("successMessage",
					UtilProperties.getMessage(resource, "Student Registerd Successfully ", locale));
			return result;
			
			
	}
	
		  
		  
		  public static Map<String, Object> createCourseMaster(DispatchContext dctx,Map<String, ? extends Object> context) {
			 Map<String, Object> result = ServiceUtil.returnSuccess();
		   GenericDelegator delegator = (GenericDelegator) dctx.getDelegator();
		   Locale locale = (Locale) context.get("locale");
		   String courseName = (String)context.get("courseName");
		   String courseDescription = (String)context.get("courseDescription");
		   String courseLevel = (String)context.get("courseLevel");
		   String courseYear = (String)context.get("courseYear");
		   Long noOfSemester = (Long) context.get("noOfSemester");
		   Long courseDuration = (Long) context.get("courseDuration");
		   Long noOfSeat = (Long) context.get("noOfSeat");
		   String courseMasterId = delegator.getNextSeqId("CourseMaster");
		   
		   try {
		   GenericValue courseSave = delegator.makeValue("CourseMaster", UtilMisc.toMap("courseMasterId",courseMasterId,"courseName", courseName, "courseDescription", courseDescription, "courseLevel", courseLevel, 
				   "courseYear", courseYear, "noOfSemester", noOfSemester,"courseDuration",courseDuration,"noOfSeat",noOfSeat));
		  
		   
		   delegator.create(courseSave);
		result.put("successMessage",
					UtilProperties.getMessage(resource, "Course Master Created Successfully "
							+ courseMasterId, locale));
		   } catch (Exception e) {
			}
		   
		return result;
		 }
	    
	    
	    public static Map<String, Object> createSubjectMaster(DispatchContext dctx, Map<String, ? extends Object> context)  {	
			 Map<String, Object> result = ServiceUtil.returnSuccess();
		   //LocalDispatcher dispatcher = dctx.getDispatcher();
		   GenericDelegator delegator = (GenericDelegator) dctx.getDelegator();
		   Locale locale = (Locale) context.get("locale");
		   String subjectName = (String)context.get("subjectName");
		   String subjectType = (String)context.get("subjectType");
		   String subjectNature = (String)context.get("subjectNature");
		   
		 
		   try {
			   
			   String subjectId = delegator.getNextSeqId("SubjectMaster");
			
			
		   GenericValue subjectSave = delegator.makeValue("SubjectMaster", 
				                                           UtilMisc.toMap("subjectId",subjectId,
				                                        		           "subjectName", subjectName,
				                                        		           "subjectNature",subjectNature,
				                                        		           "subjectType", subjectType));
		   delegator.create(subjectSave);	
		   
		   result.put("successMessage",
					UtilProperties.getMessage(resource, "Subject Master Created Successfully "+ subjectId, locale));
	     
		   } catch (GenericEntityException e) {
			
			}
		  
		return result;
		 }


}
