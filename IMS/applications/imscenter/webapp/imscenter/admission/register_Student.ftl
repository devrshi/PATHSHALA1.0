<div class="screenlet">
  <div class="screenlet-title-bar">
    <ul>
       <div id='searchOpt'>Student Registration</div></h1>
    </ul>
    <br class="clear"/>
  </div>
  <div class="screenlet-body">
     <form method="post" name="stRegistration" action="<@ofbizUrl>CreateStudent</@ofbizUrl>"  class="basic-form">
        <table class="tableView" cellspacing="0">
               <tr>
                 <td class='tLabel'>Study Institute Code :</td>
                 <td><input   type='text' name='instId' value='${partyId?if_exists}'></td>
                 <td class='tLabel'>Name of  Institute :</td>
                 <td><input  type='text' value='${org.groupName?if_exists}'></td>
               </tr>
               <tr>
                 <td class='tLabel'>Candidate Name :</td>
                 <td><Select name='salutation'>
                       <option value='Mr'>MR</option>
                       <option value='Mrs'>MRS</option>
                       <option value='Miss'>MISS</option>
                     </select><input  type='text' name='stName'></td>
                 <td class='tLabel'>Course Name:</td>
                 <td><select name='stCourse'>
                        <#if courseList?has_content>
                           <#list courseList as courseList>
                               <option value='${courseList.courseId?if_exists}'>${courseList.courseName?if_exists}</option>
                            </#list>
                         </#if>   
                      </select>
                 </td>
               </tr>
               <tr>
                 <td class='tLabel'>Father's Name :</td>
                 <td><input  type='text' name='stFatherName'></td>
                 <td class='tLabel'>Mother's Name:</td>
                 <td><input  type='text' name='stMotherName'></td>
               </tr>
               <tr>
                 <td class='tLabel'>Husband's Name :</td>
                 <td><input  type='text' ></td>
                 <td class='tLabel'>Sex:</td>
                 <td><input type='radio' name='sex' value='M'>Male / <input type='radio' name="sex" value="Female">Female</td>
               </tr>
               <tr>
                 <td class='tLabel'>Religion:</td>
                 <td><select name='religion'>
                     <option value='HINDU'>Hindu</option>
                     <option value='MUSLIM'>MUSLIM</option>
                     <option value='CHRISTEN'>CHIRSTEN</option>
                     <option value='SIKH'>SIKH</option>
                     <option value='OTHER'>OTHER</option>
                     </select></td>
                 <td class='tLabel'>Caste :</td>
                 <td><select name='caste'>
                     <option value='SC'>SC</option>
                     <option value='ST'>ST</option>
                     <option value='OBC'>OBC</option>
                     <option value='GEN'>GEN</option>
                     </select></td>
                 
               </tr>
               <tr>
                 <td class='tLabel'>Nationality :</td>
                 <td><input type='radio' name='nationality' value='IND'>Indian <input type='radio' name='nationality' value='OTHER'>Other </td>
                 <td class='tLabel'>If Other Please Specify :</td>
                 <td><input type='text' name="otherNationality" value=""></td>
               </tr>
             <tr>
		        <td class='tLabel'>qualifying Exam</td>
		        <td><textarea name='qualifyingExam'></textarea><i>Name of the School / College and place</i></td>
		        <td class='tLabel'>Last Attended</td>
		        <td><textarea name='lastAttended'></textarea><i>Name of the school / College / Institute</i></td>
		     </tr>
		     <tr>
		        <td class='tLabel'>Enrollment No.</td>
		        <td><input type='text' name='enrollmentNo'><i> if already enrolled in this University</i></td>
		        <td class='tLabel'>Receipt No. </td>
		        <td><input type='text' name='receiptNo'><i>fees paid to the study centre / UTD for Enrollment</i></td>
		     </tr> 
		     <tr>
		        <td colspan='4'><hr/></td>
		     </tr>
		     <tr>
		        <td class='tLabel'>Address1</td>
		        <td><input type='text' name='address1'></td>
		        <td class='tLabel'>Address2</td>
		        <td><input type='text' name='address2'></td>
		     </tr> 
		     <tr>
		        <td class='tLabel'>State</td>
		        <td><select name='state'><option value='IND'>Select State</option></select></td>
		        <td class='tLabel'>District</td>
		        <td><select name='district'><option value='IND'>Select District</option></select></td>
		     </tr>
		      <tr>
		        <td class='tLabel'>City</td>
		        <td><input type='text' name='city'></td>
		        <td class='tLabel'>Pincode</td>
		        <td><input type='text' name='pincode'></td>
		     </tr>
		     <tr>
		        <td colspan='4'><hr/></td>
		     </tr>
		     <tr>
		        <td class='tLabel'>Mobile No.</td>
		        <td><input type='text' name='mobileNo'></td>
		        <td class='tLabel'>eMail</td>
		        <td><input type='text' name='email'></td>
		     </tr>
		     <tr>
		        <td colspan='4'><center><input type='submit' name='submit' value='Submit'></center></td>
		     </tr>
         </table>
      </form>
    </div>
    </div> 
    
    
    
    
   
  
