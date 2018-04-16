$(document).ready(function() {
	$.ajax({
		url: "http://localhost:8080/rekvizit/getRekviziti"
	}).then(function(data) {
		for(i=0; i<data.length; i++) {
			newRow = "<tr>"
				+ "<td class=\"naziv\">" + data[i].naziv + "</td>"
				+ "<td class=\"opis\">" + data[i].opis + "</td>"
				+ "<td class=\"slika\">" + data[i].slika + "</td>"
				+ "<td class=\"cena\">" + data[i].cena + "</td>"
				+ "<td><a class=\"ponuda\" href='" + data[i].id + "'>Posalji ponudu</a></td>"
				+ "<td><a class=\"rezervacija\" href='" + data[i].id + "'>Rezervisi</a></td>"
				+ "<td><a class=\"izbrisi\" href='/rekvizit/" + data[i].id + "'>Izbrisi</a></td>"
				+ "<td><a class=\"izmeni\" href='" + data[i].id + "'>Izmeni</a></td>"
				+ "</tr>"
			$("#tabelaRekvizita").append(newRow)
		}
	});

	$.ajax({
		url : "http://localhost:8080/korisnik/getTrenutnoAktivan"
	}).then(function(data){
		if(data.uloga == "fanzona"){
			$("#dodajRekvizit").show();
			$(".izbrisi").show();
			$(".izmeni").show();
		}else{
			$("#dodajRekvizit").hide();
			$(".izbrisi").hide();
			$(".izmeni").hide();
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
