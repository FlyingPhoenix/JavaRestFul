$(document).ready(function(){

	$("#getRowById").click(function(){
		var id = document.getElementById("idRow").value;
		 $.ajax({
		  url: "http://localhost:8080/SpringExpeneses/exp/readbyid",
		  type: "POST",
		  //contentType: "application/json",
		  data: id,  
		  success: 
		   function(data) {
			 var objXML ,txt; 
			 var id, login, dd, time, desc, amount, comment;
             objXML = data;
			 id = objXML.getElementsByTagName("id");
			 login = objXML.getElementsByTagName("login");
			 dd = objXML.getElementsByTagName("dd");
			 time = objXML.getElementsByTagName("time");
			 desc = objXML.getElementsByTagName("desc");
			 amount = objXML.getElementsByTagName("amount");
			 comment = objXML.getElementsByTagName("comment");
			 txt = "";
			 txt = txt + id[0].childNodes[0].nodeValue + "&nbsp&nbsp";
			 txt = txt + login[0].childNodes[0].nodeValue + "&nbsp&nbsp";
			 txt = txt + dd[0].childNodes[0].nodeValue + "&nbsp&nbsp";	
			 txt = txt + time[0].childNodes[0].nodeValue + "&nbsp&nbsp";					 
			 txt = txt + desc[0].childNodes[0].nodeValue + "&nbsp&nbsp";	
			 txt = txt + amount[0].childNodes[0].nodeValue + "&nbsp&nbsp";	
			 txt = txt + comment[0].childNodes[0].nodeValue + "&nbsp&nbsp";	

			 /*
			  for (i = 0; i < x.length; i++) {
              txt = txt + x[i].childNodes[0].nodeValue + "<br>";
              } */
			document.getElementById("demo").innerHTML = txt;
			}
		});		
		
    });
});