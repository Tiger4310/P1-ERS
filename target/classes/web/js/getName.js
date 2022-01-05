var apiURL="http://localhost:7000/http://employee";
fetch(apiURL) 
    // Handle success // Promise
    .then(response => response.json())  // convert to json
    .then(json => populateData(json))    //pass data to populateDate() OR print data to console
    .catch(err => console.log('Request Failed', err));
    
  function populateData(response){
	 var dataSection = document.getElementById('titleName');
	 
	 for(i=0;i<response.length;i++){	
   		  dataSection.innerHTML(idTag);
	}
	 
}