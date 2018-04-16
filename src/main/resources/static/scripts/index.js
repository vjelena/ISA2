$("#fanZona").click(function(){

	$.ajax({
		url : "http://localhost:8080/korisnik/getTrenutnoAktivan"
	}).then(function(data){
		if(data.length == 0){
			alert("Morate biti prijavljeni.")
			location.href = "http://localhost:8080/prijaviSe.html"
		}else
			location.href = "http://localhost:8080/fanZona.html"
	});
});

$("#prodavnica").click(function(){

	$.ajax({
		url : "http://localhost:8080/korisnik/getTrenutnoAktivan"
	}).then(function(data){
		if(data.length == 0){
			alert("Morate biti prijavljeni.")
			location.href = "http://localhost:8080/prijaviSe.html"
		}else
			location.href = "http://localhost:8080/prodavnica.html"
	});
});