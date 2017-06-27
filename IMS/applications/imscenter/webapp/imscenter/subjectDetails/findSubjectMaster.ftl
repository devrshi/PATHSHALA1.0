<div id="findEmployee" class="screenlet">
    <div class="screenlet-title-bar">
        <ul>
            <li class="h3">Search Couse Master</li>
           
        </ul>
        <br class="clear"/>
    </div>
 
    <div class="screenlet-body">
<form method="post" name="findSubjectMaster" action="<@ofbizUrl>findSubjectMaster</@ofbizUrl>" class="basic-form">
      
            <table cellspacing="0">
                <tr><td class="label">${uiLabelMap.subjectName}</td>
                    <td><input type="text" name="subjectName" value="${parameters.subjectName?if_exists}"/></td>
                </tr>
                <tr><td class="label">${uiLabelMap.subjectDetails}</td>
                    <td><input type="text" name="subjectDetails" value="${parameters.subjectDetails?if_exists}"/></td>
                </tr>
                <tr><td class="label">${uiLabelMap.subjectNature}</td>
                    <td><input type="text" name="subjectNature" value="${parameters.subjectNature?if_exists}"/></td>
                </tr>
                <tr><td class="label">${uiLabelMap.subjectType}</td>
                    <td><input type="text" name="subjectType" value="${parameters.subjectType?if_exists}"/></td>
                </tr>
                  <tr align="center">
                    <td>&nbsp;</td>
                    <td><input type="submit" value="${uiLabelMap.search}" onclick="javascript:document.lookupparty.submit();"/>
                      
                    </td>
                </tr>
        <script language="JavaScript" type="text/javascript">
        </script>
  