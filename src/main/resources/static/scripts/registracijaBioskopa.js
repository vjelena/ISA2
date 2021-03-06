$.ajax({
	url: "http://localhost:8080/bioskopi/prikaziBioskope",
	type: "GET",
	contentType: "application/json",
	datatype: 'json',
	success: function(data){
		if(data){
			console.log("GET ZAHTEV");
			console.log(data);
			$.each(data, function(index, val){
				console.log(index, val);
				$("#sviBioskopi").append('<option value="' + val.id + '">' + val.naziv + '</option>');
			});
							
		}else
			alert("GRESKA");
	}
});

$.ajax({
	url: "http://localhost:8080/bioskopi/prikaziBioskope",
	type: "GET",
	contentType: "application/json",
	datatype: 'json',
	success: function(data){
		if(data){
			console.log("GET ZAHTEV");
			console.log(data);
			$.each(data, function(index, val){
				console.log(index, val);
				$("#sviBioskopiSkala").append('<option value="' + val.id + '">' + val.naziv + '</option>');
			});
							
		}else
			alert("GRESKA");
	}
});



$("#dugmeRegistrujBioskop").click(function(){

	var provera = true;
	var forma = $('form[id="formaRegistrujBioskop"]');
	var naziv = forma.find('[name=naziv]').val();
	var opis = forma.find('[name=opis]').val();
	var ulica = forma.find('[name=ulica]').val();
	var broj = forma.find('[name=broj]').val();
	var grad = forma.find('[name=grad]').val();
	var xKoordinata = forma.find('[name=xKoordinata]').val();
	var yKoordinata = forma.find('[name=yKoordinata]').val();
	

	if(!naziv) {
		$('#divValidacijaBioskop').empty();
		$('#divValidacijaBioskop').append('<label class="col-lg-8 control-label">Morate uneti naziv.</label>');
		provera = false;
	}	

	if(!opis) {
		$('#divValidacijaBioskop').empty();
		$('#divValidacijaBioskop').append('<label class="col-lg-8 control-label">Morate uneti opis.</label>');
		provera = false;
	}

	if(!ulica) {
		$('#divValidacijaBioskop').empty();
		$('#divValidacijaBioskop').append('<label class="col-lg-8 control-label">Morate uneti naziv ulice.</label>');
		provera = false;
	}

	if(!broj) {
		$('#divValidacijaBioskop').empty();
		$('#divValidacijaBioskop').append('<label class="col-lg-8 control-label">Morate uneti broj.</label>');
		provera = false;
	}
	if(isNaN(broj)) {
		$('#divValidacijaBioskop').empty();
		$('#divValidacijaBioskop').append('<label class="col-lg-8 control-label">Broj moze sadrzati samo cifre.</label>');
		provera = false;
	}

	if(!grad) {
		$('#divValidacijaBioskop').empty();
		$('#divValidacijaBioskop').append('<label class="col-lg-8 control-label">Morate uneti naziv grada.</label>');
		provera = false;
	}

	if(provera) {

		$('#divValidacijaBioskop').empty();

			formData = JSON.stringify({
				naziv:$("#formaRegistrujBioskop [name='naziv']").val(),
        		opis:$("#formaRegistrujBioskop [name='opis']").val(),
        		ulica:$("#formaRegistrujBioskop [name='ulica']").val(), 
				broj:$("#formaRegistrujBioskop [name='broj']").val(),
				grad:$("#formaRegistrujBioskop [name='grad']").val(),
				xKoordinata:xKoordinata,
				yKoordianta:yKoordinata
			});
					
			$.ajax({
				url: "http://localhost:8080/admin/dodajBioskop",
				type: "POST",
				data: formData,
				contentType: "application/json",
				datatype: 'json',
				success: function(data){
					if(data){
						location.reload();
					}else
						alert("Registracija NIJE uspela.");
				}
			});

			

	}

	

});

$("#dugmeDodajSalu").click(function(){
	formData = JSON.stringify({
		nazivSale:$("#formaDodajSalu [name='nazivSale']").val(),
		brojMesta:$("#formaDodajSalu [name='brojMesta']").val(),
		konfiguracija:$("#formaDodajSalu [name='konfiguracija']").val(), 
		bioskopId:$("#formaDodajSalu [name='bioskop']").val()
	});
			
	$.ajax({
		url: "http://localhost:8080/sala/dodajSalu",
		type: "POST",
		data: formData,
		contentType: "application/json",
		datatype: 'json',
		success: function(data){
			if(data){
				console.log("TOP");				
			}else
				alert("Registracija NIJE uspela.");
		}
	});
});

$("#dugmeDodajSkalu").click(function(){
	formData = JSON.stringify({
		zlatni:$("#formaDodajSkalu [name='bodoviZlatni']").val(),
		srebrni:$("#formaDodajSkalu [name='bodoviSrebrni']").val(),
		bronzani:$("#formaDodajSkalu [name='bodoviBronzani']").val(),
		zlatniPopust:$("#formaDodajSkalu [name='procenatZlatni']").val(),
		srebrniPopust:$("#formaDodajSkalu [name='procenatSrebrni']").val(),
		bronzaniPopust:$("#formaDodajSkalu [name='procenatBronzani']").val(), 
		bioskop:$("#formaDodajSkalu [name='bioskopSkala']").val()
	});

	
			
	$.ajax({
		url: "http://localhost:8080/admin/dodajSkalu",
		type: "POST",
		data: formData,
		contentType: "application/json",
		datatype: 'json',
		success: function(data){
			if(data){
				console.log(formData);
				console.log("TOP");				
			}else
				alert("Registracija NIJE uspela.");
		}
	});
});
