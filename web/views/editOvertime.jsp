<%-- 
    Document   : editOvertime
    Created on : Aug 13, 2018, 1:24:26 PM
    Author     : AINAN
--%>

<%@page import="entities.StatusOvertime"%>
<%@page import="controllers.StatusOvertimeController"%>
<%@page import="entities.JenisLembur"%>
<%@page import="controllers.JenisLemburController"%>
<%@page import="entities.DataOvertime"%>
<%@page import="tools.HibernateUtil"%>
<%@page import="controllers.DataOvertimeController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Data Overtime</title>
    </head>
    <body>
        <h1>EDIT DATA OVERTIME</h1>
        <%
            DataOvertimeController doc = new DataOvertimeController(HibernateUtil.getSessionFactory());
            DataOvertime dataOvertime = (DataOvertime)session.getAttribute("id");
            String id = session.getAttribute("id").toString();
        %>
        <table border="0">
            <tbody>
                <tr>
                    <td>ID</td>
                    <td>: </td>
                    <td><input type="text" name="txtDetailId" value="<%= dataOvertime.getId() %>" /></td>
                </tr>
                <tr>
                    <td>Nama Karyawan</td>
                    <td>: </td>
                    <td><input type="text" name="txtNamaKaryawan" value="<%= dataOvertime.getIdKaryawan().getNama() %>" /></td>
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
                    <td><input type="text" name="txtTanggal" value="<%= dataOvertime.getTgl() %>" /></td>
                </tr>
                <tr>
                    <td>Jam Masuk</td>
                    <td>: </td>
                    <td><input type="text" name="txtJamMasuk" value="<%= dataOvertime.getJamMasuk() %>" /></td>
                </tr>
                <tr>
                    <td>Jam Keluar</td>
                    <td>: </td>
                    <td><input type="text" name="txtJamKeluar" value="<%= dataOvertime.getJamPulang() %>" /></td>
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
                    <td><input type="text" name="txtUpah" value="<%= dataOvertime.getUpahLembur() %>" /></td>
                </tr>
                <tr>
                    <td>Keterangan</td>
                    <td>: </td>
                    <td><input type="text" name="txtKeterangan" value="<%= dataOvertime.getKeterangan() %>" /></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
