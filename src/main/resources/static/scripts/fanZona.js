$(document).ready(function() {

	$.ajax({
		url: "http://localhost:8080/oglas/getOglasi"
	}).then(function(data) {
		for(i=0; i<data.length; i++) {
			newRow = "<tr>"
				+ "<td class=\"naziv\">" + data[i].naziv + "</td>"
				+ "<td class=\"opis\">" + data[i].opis + "</td>"
				+ "<td class=\"datum\">" + data[i].datum + "</td>"
				+ "<td class=\"slika\">" + data[i].slika + "</td>"
				+ "<td class=\"cena\">" + data[i].cena + "</td>"
				+ "<td><a class=\"ponuda\" href='/oglas/ponuda" + data[i].id + "'>Posalji ponudu</a></td>"
				+ "<td><a class=\"rezervacija\" href='/oglas/rezervacija" + data[i].id + "'>Rezervisi</a></td>"
				+ "</tr>"
			$("#tabelaOglasa").append(newRow)
		}
	});
});


$(document).on("click", ".ponuda", function(event){

	alert("llll");

});