<form name="addSubSite" method="post" action="<@ofbizUrl>createCourseMaster</@ofbizUrl>">
<table cellspacing="8">
  <tr>
    <td align="right">Course Name</td>
    <td><input type="text" size="20" name="courseName"/></td>
    
     <td align="right">Course Level</td>
    <td>
      <select name="courseLevel">
      <option value="">Select One</option>
        <option value="UNDER_GRADUATE">Under Graduate</option>
        <option value="POST_GRADUATE">Post Graduate</option>
      </select>
    </td>
  </tr>
  <tr>
    <td align="right">Course Description</td>
    <td><input type="text" size="40" name="courseDescription"/></td>
 
     <td align="right">Course Duration</td>
    <td>
      <select name="courseDuration">
      <option value="">Select One</option>
        <option value="1">1 Year</option>
        <option value="2">2 Year</option>
        <option value="3">3 Year</option>
        <option value="4">4 Year</option>

      </select>
    </td>
     </tr>
  <tr>
   
     <td align="right">Year</td>
    <td>
      <select name="courseYear">
      <option value="">Select One</option>
        <option value="2016">2016</option>
      </select>
    </td>
     <td align="right">No Of Semester</td>
    <td>
      <select name="noOfSemester">
      <option value="">Select One</option>
        <option value="2">2</option>
        <option value="4">4</option>
        <option value="6">6</option>
      </select>
    </td>
  </tr>
  <tr><td align="right">No Of Seat</td>
    <td><input type="text" size="20" name="noOfSeat"/></td></tr>
  <tr>
    <td colspan="2"><input type="submit" name="submitBtn" value="Create"/></td>
    <#--
    <td align="right"><a href="javascript:submit_add()">Create</a></td>
    <td align="right"><a href="javascript:win_cancel()">Cancel</a></td>
    -->
  </tr>
</table>


</form>
