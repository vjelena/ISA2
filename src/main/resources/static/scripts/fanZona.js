function getID(e){
		localStorage.setItem("oglasId", $(e).attr('data-id'));
		console.log("usao u getid")
		console.log(localStorage.getItem("oglasId"));
}

$(document).ready(function() {

	$.ajax({
		url : "http://localhost:8080/korisnik/getTrenutnoAktivan"
	}).then(function(data){
		console.log(data)

		if(data.uloga == "fanzona"){

			console.log(data + "a")

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
						+ "<td class=\"cena\">" + data[i].korisnik.email + "</td>"
						+ "<td><a class=\"odobri\" id = \"odobri\" href='/oglas/odobri/" + data[i].id + "'>Odobri</a></td>"
						+ "</tr>"
						$("#tabelaOglasa").append(newRow)

						if(data[i].status == 0){
							$("#odobri").show();
						}else{
							$("#odobri").hide();
						}
					
					}
				});

		}else if(data.uloga == "obican"){
			console.log("b")

				$.ajax({
					url: "http://localhost:8080/oglas/getOglasi"
				}).then(function(data) {

					for(i=0; i<data.length; i++) {
						newRow = "<tr>"
						+ "<td onclick=\"getID(this)\" data-id=\"" + data[i].id +"\" id=\"naziv\" class=\"naziv\">" + data[i].naziv + "</td>"
						+ "<td class=\"opis\">" + data[i].opis + "</td>"
						+ "<td class=\"datum\">" + data[i].datum + "</td>"
						+ "<td class=\"slika\">" + data[i].slika + "</td>"
						+ "<td class=\"cena\">" + data[i].cena + "</td>"
						+ "<td class=\"cena\">" + data[i].korisnik.email + "</td>"
						+ "<td id=\"slanjePonude\"><input type=\"text\" class=\"form-control\" name=\"" + data[i].id +"\" placeholder=\"Ponuda\">"
						+ "<a class=\"ponuda\" href='/oglas/ponuda/" + data[i].id + "'>Posalji ponudu</a></td>"
						+ "<td><a class=\"rezervacija\" href='/oglas/rezervacija/" + data[i].id + "'>Rezervisi</a></td>"
						+ "</tr>"
						$("#tabelaOglasa").append(newRow)

						if(data[i].status == 0){
							console.log(data[i].naziv +"statuuus"+ data[i].status)
							red = $("#naziv").closest("tr")
							$(red).hide();
						}else{
							$("#naziv").show();
						}

						var d = new Date();
						var month = d.getMonth()+1;
						var day = d.getDate();
						var datum = d.getFullYear() + '-' + (month<10 ? '0' : '') + month + '-' +(day<10 ? '0' : '') + day;
						console.log("datum danasnji  "+datum)
						console.log("datum ponude  "+data[i].datum)
						//ako je istekao datum za prikupljanje ponuda i ako si vec poslao ponudu sakrij 
						/*if((data[i].datum <= datum) || (data[i].ponudjac.id == localStorage.getItem("registrovan korisnik"))){
							$("#slanjePonude").hide();
							console.log("**")
						}else{
							console.log("888")
							$("#slanjePonude").show();
						}*/
					
					}
				});

		}


		$(document).on("click", ".ponuda", function(event){

			event.preventDefault();

			var id = $(this).attr("href").match(/[0-9]+/)[0];
			console.log("id " + id)

			var vrednost = $("#tabelaOglasa [name= '"+id+"']").val()
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

				formData = JSON.stringify({
				        cena:vrednost,
				        korisnikId:data.id,
				});	
				console.log(formData);
				$.ajax({
					url: $(this).attr("href"),
					type: "POST",
					data: formData,
					contentType: "application/json",
				 	datatype: 'json',
					success: function(data){
						if(data){
							location.href = "http://localhost:8080/fanZona.html"			
						}else
							alert("DODAVANJE PONUDE NIJE USPELO.");
					}
				});
			}

		});


		$(document).on("click", ".naziv", function(event){

			event.preventDefault();

			location.href = "http://localhost:8080/oglasPrikaz.html" 

		});

		$(document).on("click", ".odobri", function(event){

			event.preventDefault();

			var id = $(this).attr("href").match(/[0-9]+/)[0];
			console.log("id " + id)

			$.ajax({
				url: "http://localhost:8080/oglas/odobri/" + id,
				type: "PUT",
				success: function(data){
					if(data){
						location.href = "http://localhost:8080/fanZona.html"			
					}else
						alert("ODOBRAVANJE OGLASA NIJE USPELO.");
				}
			});

		});

	});
	
});



