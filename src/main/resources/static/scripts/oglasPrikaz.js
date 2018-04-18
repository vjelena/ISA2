function getID(e){
		localStorage.setItem("ponudaId", $(e).attr('data-id'));
		console.log("ponuda id je" + localStorage.getItem("ponudaId"));
}

$(document).ready(function(){

	var obj = { "id":localStorage.getItem("oglasId")}
	var korisnik = localStorage.getItem("registrovan korisnik")
	console.log(korisnik)
	console.log(obj.id)

	$.ajax({
		url: "http://localhost:8080/oglas/getOglas/" + obj.id
	}).then(function(data) {

		var naziv = "<tr><th scope=\"col\">Naziv: " + data.naziv + "</th></tr>";
		var opis = "<tr><th scope=\"col\">Opis: " + data.opis + "</th></tr>";
		var datum = "<tr><th scope=\"col\">Datum do kog vazi prikupljanje ponuda: " + data.datum + "</th></tr>";
		var slika = "<tr><th scope=\"col\">Slika: " + data.slika + "</th></tr>";
		var cena = "<tr><th scope=\"col\">Cena: " + data.cena + "</th></tr>";
		var vlasnik = "<tr><th scope=\"col\">Vlasnik: " + data.korisnik.email + "</th></tr>";

		$("#tabelaOglasPrikaz").append(naziv);
		$("#tabelaOglasPrikaz").append(opis);
		$("#tabelaOglasPrikaz").append(datum);
		$("#tabelaOglasPrikaz").append(slika);
		$("#tabelaOglasPrikaz").append(cena);
		$("#tabelaOglasPrikaz").append(vlasnik);

		$.each(data.listaPonuda, function(index, val){
			console.log("each")
			console.log(index, val);
			$("#tabelaOglasPonude").append(val.cena);
		});
	});


	$.ajax({
		url: "http://localhost:8080/oglas/getPonude/" + obj.id
	}).then(function(data) {

		$.each(data, function(index, val){
			index = index + 1;
			console.log(index, val);
			
			$("#tabelaOglasPonude").append("<tr><th scope=\"col\">" + val.cena + "RSD</th></tr>");
			$("#tabelaOglasPonude").append("<tr><th scope=\"col\">&nbsp</th></tr>");
			if(korisnik == val.ponudjac.id){
				$("#tabelaOglasPonude").append("<tr><th scope=\"col\">  <input type=\"text\" class=\"form-control\" onclick=\"getID(this)\" data-id=\"" + index +"\" name=\"" + index +"\" placeholder=\"Ponuda\">"
											 + "<a class=\"ponuda\" href='/oglas/ponuda/" + obj.id + "'>Posalji novu ponudu</a></th></tr>");
			}
			$("#tabelaOglasPonude").append("<tr><th scope=\"col\">&nbsp</th></tr>");
		});
	});

	$(document).on("click", ".ponuda", function(event){

			event.preventDefault();

			var id = localStorage.getItem("ponudaId");

			var vrednost = $("#tabelaOglasPonude [name= '"+id+"']").val()
			console.log(vrednost)

			var provera = true;
			if(!vrednost){	
				alert("Niste uneli ponudu!")
				provera = false;
			}
			if(isNaN(vrednost)) {
				alert("Ponuda mora sadrzati samo cifre!")
				provera = false;
			}

			if(provera){

				formData = JSON.stringify({cena:vrednost});	
				console.log(formData);
				$.ajax({
					url: "http://localhost:8080/oglas/izmeniPonudu/" + id,
					type: "PUT",
					data: formData,
					contentType: "application/json",
				 	datatype: 'json',
					success: function(data){
						if(data){
							location.href = "http://localhost:8080/oglasPrikaz.html"			
						}else
							alert("IZMENA PONUDE NIJE USPELA.");
					}
				});
			}

	});
});
