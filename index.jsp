<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
 
<html>
  <head>
  </head>
  <body>
    <br/><br/>
    <form method="post" name="frm" action="SearchServlet.jsp">
      
        <tr><td colspan=2 style="font-size:12pt;" align="center">
        <h3>Search User</h3></td></tr>
        <tr><td ><b>Name</b></td>
          <td>: <input  type="text" name="name" >
        </td></tr>        
        <tr><td colspan=2 align="center">
        <input  type="submit" name="submit" value="Search"></td></tr>
      </table>
    </form>
  </body>
</html>