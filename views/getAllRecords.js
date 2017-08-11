$(document).ready(function(){

	$("#getAllRecords").click(function(){
		$.ajax({
		  url: "http://localhost:8080/SpringExpeneses/exp/readall",
		  type: "GET",
		  //contentType: "application/json",  
		  success: 
		   function(data) {
			 var objXML ,txt = []; 
			 var id, login, dd, time, desc, amount, comment;
             objXML = data;
			 id = objXML.getElementsByTagName("id");
			 login = objXML.getElementsByTagName("login");
			 dd = objXML.getElementsByTagName("dd");
			 time = objXML.getElementsByTagName("time");
			 desc = objXML.getElementsByTagName("desc");
			 amount = objXML.getElementsByTagName("amount");
			 comment = objXML.getElementsByTagName("comment");
			 
			 for (i=0; i<id.length; i++) {
				txt[i]="";
			    txt[i] = txt[i] + id[i].childNodes[0].nodeValue + "  ";
			    txt[i] = txt[i] + login[i].childNodes[0].nodeValue + "  ";
			    txt[i] = txt[i] + dd[i].childNodes[0].nodeValue + "  ";	
			    txt[i] = txt[i] + time[i].childNodes[0].nodeValue + "  ";					 
			    txt[i] = txt[i] + desc[i].childNodes[0].nodeValue + "  ";	
			    txt[i] = txt[i] + amount[i].childNodes[0].nodeValue + "  ";	
			    txt[i] = txt[i] + comment[i].childNodes[0].nodeValue + "  ";	
				
				var para = document.createElement("P");
		        var t = document.createTextNode(txt[i]);       
				para.appendChild(t);                                         
				document.body.appendChild(para);   							
			   } 
			}
		});		
		
    });
});