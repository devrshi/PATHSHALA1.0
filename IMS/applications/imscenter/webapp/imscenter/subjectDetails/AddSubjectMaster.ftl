                
<form name="addSubjectMaster" method="post" action="<@ofbizUrl>createSubjectMaster</@ofbizUrl>">
<table cellspacing="8">
  <tr>
    <td align="right">${uiLabelMap.subjectName}</td>
    <td><input type="text" size="20" name="subjectName"/></td>
    
  </tr>
  <tr>
    <td align="right">${uiLabelMap.subjectNature}</td>
  <td>
      <select name="subjectNature">
      <option value="">Select One</option>
        <option value="THEORY">Theory</option>
        <option value="PRACTICAL">Practical</option>
      </select>
    </td>
 
     <td align="right">${uiLabelMap.subjectType}</td>
    <td>
      <select name="subjectType">
      <option value="">Select One</option>
        <option value="COMPULSORY">Compulsory</option>
        <option value="ELECTIVE">Elective</option>

      </select>
    </td>
     </tr>
  <tr>
    <td colspan="2"><input type="submit" name="submitBtn" value="Create"/></td>
  </tr>
</table>


</form>
                