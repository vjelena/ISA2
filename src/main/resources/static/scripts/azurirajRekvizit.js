$.ajax({
	url: "http://localhost:8080/film/getFilmovi",
	type: "GET",
	contentType: "application/json",
	datatype: 'json',
	success: function(data){
		if(data){
			console.log("GET ZAHTEV");
			console.log(data);
			$.each(data, function(index, val){
				console.log(index, val);
				$("#sviFilmovi").append('<option value="' + val.id + '">' + val.naziv + '</option>');
			});
							
		}else
			alert("GRESKA");
	}
});

var rekvizit = localStorage.getItem("rekvizitId");
console.log(rekvizit);

$(document).ready(function(){
		$.ajax({
			url : "http://localhost:8080/rekvizit/getRekvizit/" + rekvizit
		}).then(function(data){
			$("#nazivA").append(data.naziv);
			$("#opisA").append(data.opis);
			$("#slikaA").append(data.slika);
			$("#cenaA").append(data.cena);
			$("#filmA").append(data.film.naziv);
		});
});	


$("#dugmeAzurirajPodatke").click(function(){

	var provera = true;
	var forma = $('form[id="formaAzurirajRekvizit"]');
	var naziv = forma.find('[name=naziv]').val();
	var opis = forma.find('[name=opis]').val();
	var slika = forma.find('[name=slika]').val();
	var cena = forma.find('[name=cena]').val();
	var film = forma.find('[name=film]').val();

	if(!naziv) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti naziv.</label>');
		provera = false;
	}	

	if(!opis) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti opis.</label>');
		provera = false;
	}

	if(!slika) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti sliku.</label>');
		provera = false;
	}

	if(!cena) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti cenu.</label>');
		provera = false;
	}
	if(isNaN(cena)) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Cena moze sadrzati samo cifre.</label>');
		provera = false;
	}

	if(provera) {

		$('#divValidacija').empty();

		formData = JSON.stringify({
	        naziv:$("#formaAzurirajRekvizit [name='naziv']").val(),
	        opis:$("#formaAzurirajRekvizit [name='opis']").val(),
	        slika:$("#formaAzurirajRekvizit [name='slika']").val(),
	        cena:$("#formaAzurirajRekvizit [name='cena']").val(),
	        filmId:$("#formaAzurirajRekvizit [name='film']").val()
	    });	
	    console.log(formData);
		$.ajax({
			url: "http://localhost:8080/rekvizit/azurirajRekvizit/" + rekvizit,
			type: "PUT",
			data: formData,
			contentType: "application/json",
			datatype: 'json',
			success: function(data){
				if(data){
					location.href = "http://localhost:8080/prodavnica.html"			
				}else
					alert("AZURIRANJE REKVIZITA NIJE USPELO.");
				}
		});
	}
});

$("#dugmeOdustaniOdAzuriranja").click(function(){

	location.href = "http://localhost:8080/prodavnica.html"
});
