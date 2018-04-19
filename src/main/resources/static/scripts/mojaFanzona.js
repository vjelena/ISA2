function getID(e){
	localStorage.setItem("prihvatiPonudu", $(e).attr('data-id'));
	console.log("prihvacena ponuda id je" + localStorage.getItem("prihvatiPonudu"));
}

function getIDO(e){
	localStorage.setItem("prihvatiPonuduOglas", $(e).attr('data-id'));
	console.log("oglas prihvacene ponuda id je" + localStorage.getItem("prihvatiPonuduOglas"));
}

var korisnik = localStorage.getItem("registrovan korisnik");
console.log("prijavljen je " + korisnik);

$(document).ready(function(){

	$.ajax({
		url: "http://localhost:8080/oglas/mojiOglasi/" + korisnik
	}).then(function(data) {

		for(i=0; i<data.length; i++) {

			var status = "";
			if(data[i].status == 0){
				status = "neodobren";
			}else if(data[i].status == 1){
				status = "odobren";
			}

			newRow = "<tr>"
				+ "<td class=\"naziv\">" + data[i].naziv + "</td>"
				+ "<td class=\"opis\">" + data[i].opis + "</td>"
				+ "<td class=\"datum\">" + data[i].datum + "</td>"
				+ "<td class=\"slika\">" + data[i].slika + "</td>"
				+ "<td class=\"cena\">" + data[i].cena + "</td>"
				+ "<td class=\"status\">" + status + "</td>"
				+ "<td class=\"ponude\" onclick=\"getIDO(this)\" data-id=\"" + data[i].id +"\"> <div class=\"form-group col-lg-2\" id=\"podaciOglas\">"
										+ "<table id=\"tabelaOglasPonude\" class=\"table\">";

			$.ajax({
				url: "http://localhost:8080/oglas/getPonude/" + data[i].id
			}).then(function(data) {
				$.each(data, function(index, val){
					index = index + 1;

					newRowP = "<tr>"
						+ "<td scope=\"col\">" + val.cena + "RSD</td>"
						+ "<td scope=\"col\"><a class=\"prihvati\" onclick=\"getID(this)\" data-id=\"" + index +"\" href='" + index + "'>Prihvati</a></td>"
						+ "</tr>";

					$("#tabelaOglasPonude").append(newRowP);
				});
			});	

			newRow = newRow + "</table></div></td></tr>";
			$("#tabelaOglasa").append(newRow);
		}
	});

	$.ajax({
		url: "http://localhost:8080/oglas/mojePonude/" + korisnik
	}).then(function(data) {

		for(i=0; i<data.length; i++) {

			var status = "";
			if(data[i].status == -1){
				status = "odbijena";
			}else if(data[i].status == 1){
				status = "prihvacena";
			}

			newRow = "<tr>"
				+ "<td class=\"cena\">" + data[i].cena + "</td>"
				+ "<td class=\"status\">" + status + "</td>"
				+ "</tr>";
			$("#tabelaPonuda").append(newRow)					
		}
	});


	$(document).on("click", ".prihvati", function(event){

			event.preventDefault();

			var id = localStorage.getItem("prihvatiPonudu");
			console.log("prihvatam ponudu : " +id);
			var idOglasa = localStorage.getItem("prihvatiPonuduOglas");
			console.log("ponuda pripada oglasu: " + idOglasa);
			
			$.ajax({
				url: "http://localhost:8080/oglas/prihvatiPonudu/" + id + "/" + idOglasa,
				type: "PUT",
				success: function(data){
					if(data){
						location.href = "http://localhost:8080/mojaFanzona.html"			
					}else
						alert("PRIHVATANJE PONUDE NIJE USPELO.");
				}
			});

	});

});