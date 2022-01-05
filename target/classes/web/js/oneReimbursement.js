var apiURL="http://localhost:7000/oneReimbursement";
fetch(apiURL) 
   
    .then(response => response.json()) 
    .then(json => populateData(json))    
    .catch(err => console.log('Request Failed', err));
    
   console.log("from add rembersment");
    
 function populateData(response){
	 var dataSection = document.getElementById('tableBody');
	 dataSection.innerHTML='';
	 
	 for(i=0;i<response.length;i++){
		var row = document.createElement('tr');
		row.innerHTML='';
	  
		var col1 = document.createElement('td');
		var data = response[i].id;
		col1.innerHTML=data;
		row.appendChild(col1)
		
		var col2 = document.createElement('td');
		var data = response[i].authorid;
		col2.innerHTML=data;
		row.appendChild(col2);
		 
		var col3 = document.createElement('td');
		var data = response[i].resolverid;
		col3.innerHTML=data;
		row.appendChild(col3);
			 
		var col4 = document.createElement('td');
		var data = response[i].type;
		col4.innerHTML=data;
		row.appendChild(col4);
		 
		var col5 = document.createElement('td');
		var data = response[i].amount;
		col5.innerHTML=data;
		row.appendChild(col5);
		 
		var col6 = document.createElement('td');
		var data = response[i].description;
		col6.innerHTML=data;
		row.appendChild(col6)
	
		 
		var col7 = document.createElement('td');
		var data = response[i].submittime;
		col7.innerHTML=data;
		row.appendChild(col7)
		
		var col8 = document.createElement('td');
		var data = response[i].resolvetime;
		col8.innerHTML=data;
		row.appendChild(col8)
		 
		 
		var col9 = document.createElement('td');
		var data = response[i].status;
		col9.innerHTML=data;
		row.appendChild(col9)
		
		 
		var col10 = document.createElement('td');
		var data = response[i].accepted;
		col10.innerHTML=data;		
		row.appendChild(col10)
		
			
		dataSection.appendChild(row);
	}
	 
}