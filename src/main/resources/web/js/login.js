var apiURL="http://localhost:7000/employee";
fetch(apiURL) 
   
    .then(response => response.json())  
    .then(json => populateData(json))    
    .catch(err => console.log('Request Failed', err));
    
  function populateData(response){
	 var dataSection = document.getElementById('username');
	 dataSection.innerHTML='';
	 
	 for(i=0;i<response.length;i++){
	
		var idTag = document.createElement('h3');
   		 var data= response[i].firstname +" : "+response[i].lastname
   	
   			idTag.innerHTML=data;
   		  dataSection.appendChild(idTag);
	}
	 
}