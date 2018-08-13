<%-- 
    Document   : addOvertime
    Created on : Aug 13, 2018, 3:27:47 PM
    Author     : AINAN
--%>

<%@page import="entities.StatusOvertime"%>
<%@page import="controllers.StatusOvertimeController"%>
<%@page import="entities.JenisLembur"%>
<%@page import="controllers.JenisLemburController"%>
<%@page import="tools.HibernateUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Overtime</title>
    </head>
    <body>
        <h1>TAMBAH DATA OVERTIME</h1>
        <table border="0">
            <tbody>
                <tr>
                    <td>ID</td>
                    <td>: </td>
                    <td><input type="text" name="txtDetailId" /></td>
                </tr>
                <tr>
                    <td>Nama Karyawan</td>
                    <td>: </td>
                    <td><input type="text" name="txtNamaKaryawan" /></td>
                </tr>
                <tr>
                    <td>Jenis Lembur</td>
                    <td>: </td>
                    <td><select name="cmbJenisLembur">
                            <%
                                JenisLemburController jlc = new JenisLemburController(HibernateUtil.getSessionFactory());
                                
                                for (JenisLembur jl : jlc.getAll()) {
                            %><option value="<%= jl.getIdJenisLembur() %>"><%= jl.getJenisLembur() %></option>           
                            <%    }
                            %>
                        </select></td>
                </tr>
                <tr>
                    <td>Tanggal</td>
                    <td>: </td>
                    <td><input type="text" name="txtTanggal" /></td>
                </tr>
                <tr>
                    <td>Jam Masuk</td>
                    <td>: </td>
                    <td><input type="text" name="txtJamMasuk" /></td>
                </tr>
                <tr>
                    <td>Jam Keluar</td>
                    <td>: </td>
                    <td><input type="text" name="txtJamKeluar"/></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td>: </td>
                    <td><select name="cmbStatus">
                            <%
                                StatusOvertimeController soc = new StatusOvertimeController(HibernateUtil.getSessionFactory());
                                
                                for (StatusOvertime so : soc.getAll()) {
                            %><option value="<%= so.getId() %>"><%= so.getStatus() %></option>           
                            <%    }
                            %>
                        </select></td>
                </tr>
                <tr>
                    <td>Upah Lembur</td>
                    <td>: </td>
                    <td><input type="text" name="txtUpah" /></td>
                </tr>
                <tr>
                    <td>Keterangan</td>
                    <td>: </td>
                    <td><input type="text" name="txtKeterangan" /></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
