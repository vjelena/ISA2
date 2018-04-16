$("#potvrdi").click(function(){

	var provera = true;
	var forma = $('form[id="formaNoviOglas"]');
	var naziv = forma.find('[name=naziv]').val();
	var opis = forma.find('[name=opis]').val();
	var datum = forma.find('[name=datum]').val();
	var slika = forma.find('[name=slika]').val();
	var cena = forma.find('[name=cena]').val();

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

	if(!datum) {
		$('#divValidacija').empty();
		$('#divValidacija').append('<label class="col-lg-8 control-label">Morate uneti datum.</label>');
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
	        naziv:$("#formaNoviOglas [name='naziv']").val(),
	        opis:$("#formaNoviOglas [name='opis']").val(),
	        datum:$("#formaNoviOglas [name='datum']").val(),
	        slika:$("#formaNoviOglas [name='slika']").val(),
	        cena:$("#formaNoviOglas [name='cena']").val()
	    });
		$.ajax({
			url: "http://localhost:8080/oglas",
			type: "POST",
			data: formData,
			contentType: "application/json",
			datatype: 'json',
			success: function(data){
				if(data){
					location.href = "http://localhost:8080/fanZona.html"			
				}else
					alert("DODAVANJE OGLASA NIJE USPELO.");
				}
		});
	}
});

$("#odustani").click(function(){

	location.href = "http://localhost:8080/fanZona.html"
});