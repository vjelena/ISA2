function getID(e){
	localStorage.setItem("rekvizitId", $(e).attr('data-id'));
	console.log("usao u getid")
	console.log(localStorage.getItem("rekvizitId"));
}

var admin = localStorage.getItem("admin");
console.log(admin);

$(document).ready(function() {
	
	$("#dodajRekvizit").hide();
	$("#azurirajAdmina").hide();
	
	$.ajax({
		url: "http://localhost:8080/rekvizit/getRekviziti"
	}).then(function(data) {
		for(i=0; i<data.length; i++) {
			if(data[i].status == 0){
				newRow = "<tr>"
					+ "<td id=\"naziv\" class=\"naziv\">" + data[i].naziv + "</td>"
					+ "<td id=\"opis\" class=\"opis\">" + data[i].opis + "</td>"
					+ "<td id=\"slika\" class=\"slika\">" + data[i].slika + "</td>"
					+ "<td id=\"cena\" class=\"cena\">" + data[i].cena + "</td>"
					+ "<td><a onclick=\"getID(this)\" data-id=\"" + data[i].id +"\" class=\"rezervacija\" href='/oglas/rezervacija/" + data[i].id + "'>Rezervisi</a></td>"
					+ "<td><a class=\"izbrisi\" href='/rekvizit/" + data[i].id + "'>Izbrisi</a></td>"
					+ "<td><a onclick=\"getID(this)\" data-id=\"" + data[i].id + "\" class=\"izmeni\" href='/rekvizit/" + data[i].id + "'>Izmeni</a></td>"
					+ "</tr>"
				$("#tabelaRekvizita").append(newRow)
			}
			
			if(admin == "fanzona"){
				$("#dodajRekvizit").show();
				$("#azurirajAdmina").show();
				$(".izbrisi").show();
				$(".izmeni").show();
				$(".rezervacija").hide();
			}else{
				$(".izbrisi").hide();
				$(".izmeni").hide();
				$(".rezervacija").show();
			}
		}
	});
});


$(document).on("click", ".izbrisi", function(event){
		//ne salji get zahtev
		event.preventDefault(); 
		
		var confirmed = confirm("Da li ste sigurni da zelite da obrišete?");
		if(confirmed){
		
			var url = $(this).attr("href")
			console.log(url)
			//red koji se treba izbrisati ako je brisanje na serveru bilo uspesno
			tr_parent = $(this).closest("tr")
			$.ajax({
	        	url: url,
	        	type: "DELETE",
	        	success: function(){
	        		//ukloni i na strani 
					tr_parent.remove()
		        }
			});
		}
});

$(document).on("click", ".izmeni", function(event){

	event.preventDefault(); 

	location.href = "http://localhost:8080/azurirajRekvizit.html"
});

$(document).on("click", ".rezervacija", function(event){

	event.preventDefault();

	var id = localStorage.getItem("rekvizitId");
	console.log("id " + id)

	$.ajax({
		url: "http://localhost:8080/rekvizit/rezervacija/" + id,
		type: "PUT",
		success: function(data){
			if(data){
				location.href = "http://localhost:8080/prodavnica.html"			
			}else
				alert("ODOBRAVANJE OGLASA NIJE USPELO.");
		}
	});

});

