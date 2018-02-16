<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<HTML>
    <HEAD>
        <TITLE>Fetching Data From a Database</TITLE>
    </HEAD>

    <BODY>
        
        <% 
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/emp", "root", "");

            Statement statement = connection.createStatement();

            String name = request.getParameter("name"); 
            

            ResultSet resultset = statement.executeQuery("select * from emp1 where name like '%a%'"); 
           
%>
             <TABLE BORDER="1">
            <TR>
               <TH>id</TH>
               <TH>name</TH>
               <TH>password</TH>
               <TH>email</TH>
               <TH>country</TH>
           </TR>
           <TR>
  <% while(resultset.next()!=false){%>
            <TR>	
               <TD> <%= resultset.getInt(1) %> </TD>
               <TD> <%= resultset.getString(2) %> </TD>
               <TD> <%= resultset.getString(3) %> </TD>
               <TD> <%= resultset.getString(4) %> </TD>
               <TD> <%= resultset.getString(5) %> </TD>
           </TR>
               <% } %> 
       </TABLE>
       <BR>
       
    </BODY>
</HTML>
