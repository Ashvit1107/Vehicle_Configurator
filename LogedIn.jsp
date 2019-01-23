<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="js/jquery-1.8.2.js"></script>
<script src="js/jquery-ui.js"></script>

<!-- 
<script>
$(function() {
$( ".datepicker" ).datepicker({ changeMonth: true, changeYear: true, yearRange: '1990:2000' });
});
</script>  

<style>
div.ui-datepicker
{
 margin-left:180px;
}
</style>

-->

<head>
<title>Vehicle Configurator</title>
<script>
$(document).ready(function() {

	$('#segments').change(function(event) {
        var segments = $("select#segments").val();
       // alert(actors);
        var select = $('#manufacturer');
        $.ajax({
					type : "POST",
					url : "/Vehicle_Configurator/second.do?segmentName="+segments+"",
					success : function(data) {
								console.log("SUCCESS: ", data);
								$('#manufacturer option').remove();
								$('#manufacturer').append("<option value='Select Value'>Select Value</option>");
								for(var i=0;i<data.length;i++)
								{
			    		        	$('<option>').val(data[i]).text(data[i]).appendTo(select);
			
								};
        					}
				});  
			});
	$('#manufacturer').change(function(event) {
        var manufacturer = $("select#manufacturer").val();
        var selectrd = $('#modelNvariant');
        $.ajax({
					type : "POST",
					url : "/Vehicle_Configurator/third.do?manufacturerName="+manufacturer+"",
					success : function(data) {
								console.log("SUCCESS: ", data);
								$('#modelNvariant option').remove();
								$('#modelNvariant').append("<option value='Select Value'>Select Value</option>");
								for(var i=0;i<data.length;i++)
								{
			    		        	$('<option>').val(data[i]).text(data[i]).appendTo(selectrd);
			
								};
        					}
				});  
			});
	
	$('#modelNvariant').change(function(event) {
        var modelNvariant = $("select#modelNvariant").val();
       // alert(song);
        var selectrd = $('#modelNvariant');
        $.ajax({
					type : "POST",
					url : "/Vehicle_Configurator/fourth.do?modelNvariantName="+modelNvariant+"",
				});  
			});
}); 
</script>
</head>
<body>
<form:form id="form" method="post" commandName="segmenttran">
        Select Segment:
        
     
        <select id="segments">
		<option>Select Value</option>
        <c:forEach items="${mylist}" var="segment">
		<option value="${segment}">${segment}</option>
    	</c:forEach>	
         </select>
          <br> <br>
        Select Manufacturer:
        <select id="manufacturer">
        <option>Select Value</option>
        <c:forEach items="${mlist}" var="manufacturer">
				<option value="${manufacturer}">${manufacturer}</option>
    	</c:forEach>
        </select>
        <br> <br>
        Select Model And Variant:
        <select id="modelNvariant">
                <option>Select Value</option>
        </select>
        
       <br><br>

<input type=submit name="Submit" value="Submit"> 
</form:form>
</body>
</html>