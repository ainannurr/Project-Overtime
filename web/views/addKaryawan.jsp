<%-- 
    Document   : addKaryawan
    Created on : Aug 13, 2018, 3:09:31 PM
    Author     : AINAN
--%>

<%@page import="entities.Role"%>
<%@page import="tools.HibernateUtil"%>
<%@page import="controllers.RoleController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Karyawan</title>
    </head>
    <body>
        <h1>TAMBAH DATA KARYAWAN</h1>
        <table border="0">
            <tbody>
                <tr>
                    <td>ID Karyawan</td>
                    <td>: </td>
                    <td><input type="text" name="txtPegawaiId" /></td>
                </tr>
                <tr>
                    <td>Role</td>
                    <td>: </td>
                    <td><select name="cmbRole">
                            <%
                                RoleController rc = new RoleController(HibernateUtil.getSessionFactory());
                                
                                for (Role role : rc.getAll()) {
                            %><option value="<%= role.getId() %>"><%= role.getNama() %></option>           
                            <%    }
                            %>
                        </select></td>
                </tr>
                <tr>
                    <td>Nama Karyawan</td>
                    <td>: </td>
                    <td><input type="text" name="txtNamaPegawai"/></td>
                </tr>
                <tr>
                    <td>Tanggal Lahir</td>
                    <td>: </td>
                    <td><input type="text" name="tglLahir" /></td>
                </tr>
                <tr>
                    <td>Tanggal Masuk</td>
                    <td>: </td>
                    <td><input type="text" name="tglMasuk" /></td>
                </tr>
                <tr>
                    <td>Alamat</td>
                    <td>; </td>
                    <td><input type="text" name="alamat" /></td>
                </tr>
                <tr>
                    <td>Gaji</td>
                    <td>: </td>
                    <td><input type="text" name="gaji" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>: </td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                    <td>Jenis Kelamin</td>
                    <td>: </td>
                    <td><input type="text" name="txtJenisKelamin"/></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
