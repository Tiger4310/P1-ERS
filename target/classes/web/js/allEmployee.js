
var apiURL="http://localhost:7000/employee";
fetch(apiURL) 
    .then(response => response.json())  
    .then(json => populateData(json))    
    .catch(err => console.log('Request Failed', err));
    
  function populateData(response){
	 var dataSection = document.getElementById('tableBody');
	 dataSection.innerHTML='';
	 
	 for(i=0;i<response.length;i++){
		var row = document.createElement('tr');
		row.innerHTML='';
	  
		var col1 = document.createElement('td');
		var data = response[i].userid;
		col1.innerHTML=data;
		row.appendChild(col1)
		
		var col2 = document.createElement('td');
		var data = response[i].firstname;
		col2.innerHTML=data;
		row.appendChild(col2);
		 
		var col3 = document.createElement('td');
		var data = response[i].lastname;
		col3.innerHTML=data;
		row.appendChild(col3);
			
		var col6 = document.createElement('td');
		var data = response[i].email;
		col6.innerHTML=data;
		row.appendChild(col6)
	
		 
		var col7 = document.createElement('td');
		var data = response[i].username;
		col7.innerHTML=data;
		row.appendChild(col7)
		
		var col8 = document.createElement('td');
		var data = response[i].password;
		col8.innerHTML=data;
		row.appendChild(col8)
		 
		 
		var col9 = document.createElement('td');
		var data = response[i].userrole;
		col9.innerHTML=data;
		row.appendChild(col9)
			
		dataSection.appendChild(row);
	}
	 
}