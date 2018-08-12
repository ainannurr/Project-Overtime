<%-- 
    Document   : dataKaryawan
    Created on : Aug 12, 2018, 10:39:04 PM
    Author     : BINTANG
--%>

<%@page import="tools.HibernateUtil"%>
<%@page import="controllers.KaryawanController"%>
<%@page import="entities.Karyawan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Karyawan</title>
    </head>
    <body>
        <%
            KaryawanController kc = new KaryawanController(HibernateUtil.getSessionFactory());
        %>
        <h1>Karyawan</h1>
        <select name="cmbCategory">
        </select>
        <input type="text" name="txtFind" value="" />
        <input type="submit" value="Find" name="btnFind" />
        
        <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Role </th>
                <th>Nama Karyawan</th>
                <th>Tanggal Lahir</th>
                <th>Tanggal Bergabung</th>
                <th>Alamat</th>
                <th>Gaji</th>
                <th>Email</th>
                <th>Jenis Kelamin</th>
                <th>Password</th>
                <th>Aksi</th>
            </tr>
        </thead>
        <tbody>
            <%
               
                for (Karyawan kar : kc.getAllSort("id", "asc")) {
            %>
            <tr>
                
                <td><%= kar.getId() %></td>
                <td><%= kar.getIdRole()%></td>
                <td><%= kar.getNama() %></td>
                <td><%=kar.getTglLahir() %></td>
                <td><%=kar.getTglMasuk()%></td>
                <td><%=kar.getAlamat() %></td>
                <td><%=kar.getGaji() %></td>
                <td><%=kar.getEmail() %></td>
                <td><%=kar.getJenisKelamin() %></td>
                <td><%=kar.getPassword() %></td>
                <td>
                    <span><a href="#">Edit</a></span>
                    <span><a href="#">Delete</a></span>
                </td>
            </tr>
            <%
                    
                }
            %>
        </tbody>
    </table>
    </body>
</html>
