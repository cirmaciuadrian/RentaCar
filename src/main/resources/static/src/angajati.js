$(document).ready(function () {
    $(".modal-adaugare-client-btn").on("click", function (e) {
        //alert("cliked");
        $(".modal-adaugare").show();
    })
    $(".sterge-angajat-btn").on("click", function (e) {
        var id = $(this).attr("data-id");
        $(".modal-stergere").find(".btn-confirma").attr("href", "/angajati/delete/" + id)
        $(".modal-stergere").show();
    })
    $(".select-categorie-masini").on("change", function () {
        var $this = $(this);
        var categorie = $(this).children("option:selected").val();
        $(".input-categorie-id").val(categorie);
        document.getElementById("filtrareForm").submit();
    });
    $(".btn-masini-libere").on("click", function () {
        $(".input-status-masini").val("libere");
        document.getElementById("filtrareForm").submit();
    })
    $(".btn-masini-inchiriate").on("click", function () {
        $(".input-status-masini").val("inchiriate");
        document.getElementById("filtrareForm").submit();
    })
    function initCategorieMasini() {
        $(".select-categorie-masini").val($(".input-categorie-id").val());
    }
    initCategorieMasini();
    $(".modal-adaugare").on("click", function (e) {
        e.preventDefault();
        $.ajax({
            url: "/masini/add",
            type: "get"
        })
            .done(function (response) {
                $(".continut-modal-adaugare").html(response);
            })
            .fail(function () {
                alert("fail");
            });
    });
    $(".modal-form-masina").on("click", ".btn-send-form-add-masini", function (e) {
        e.preventDefault();
        var data = $(".form-adaugare").serialize();
        $.ajax({
            url: "/masini/add",
            type: "post",
            data: data
        })
            .done(function (response) {
                if (response == "succes") {
                    alert("Masina a fost salvata cu succes");
                    location.reload();
                } else {
                    $(".continut-modal-adaugare").html(response);
                }
            })
            .fail(function () {
                alert("fail");
            });
    })
    $(".btn-edit-masina").on("click", function (e) {
        e.preventDefault();
        data = {
            id: $(this).attr('data-id')
        }
        $.ajax({
            url: "/masini/add",
            type: "get",
            data: data
        })
            .done(function (response) {
                $(".continut-modal-adaugare").html(response);
            })
            .fail(function () {
                alert("fail");
            });
    })
    $(".modal-form-masina").on("click", ".btn-send-form-update-masini", function (e) {
        e.preventDefault();
        alert("Masina a fost actualizata cu succes");
        location.reload();
    })
    $(".btn-inchiriaza-masina").on("click", function(){
        var id = $(this).attr('data-id');
        var nrInmatric = $(this).attr('data-nrinamat');
        $(".modal-inchiriaza-masina").find(".hidden-id-masina-pentru-icnhiriat").val(id);
        $(".modal-inchiriaza-masina").find(".modal-title").text("Inchiriaza masina "+nrInmatric);
    });

    $(".btn-inchiriaza-confirmare").on("click", function(e){
        e.preventDefault();
        var idCLient = $(".select-client-inchiriaza-masina").val();
        var idMasina = $(".hidden-id-masina-pentru-icnhiriat").val();
        if(idCLient == 0){
            $(".modal-inchiriaza-masina").find(".mesaj-eroare").text("Trebuie sa elegeti un client");
            return;
        }
        else{
            $(".modal-inchiriaza-masina").find(".mesaj-eroare").text("");
        }
        data = {
            idClient: idCLient,
            idMasina: idMasina
        }
        $.ajax({
            url: "masina/inchiriaza",
            type: "post",
            data: data
        })
            .done(function (response) {
                alert("Masina a fost inchriata cu succes")
                window.location.href = "http://localhost:8080/chirie/active";
            })
            .fail(function () {
                alert("fail");
            });
    });

    $(".btn-finalizeaza-chirie").on("click", function(){
        var idCLient =  $(this).attr('data-idClient');
        var idMasina = $(this).attr('data-idMasina');
        var nrInmatric = $(this).attr('data-nrInmat');
        var idChirieActiva = $(this).attr('data-idChirieActiva');
        var numeClient = $(this).attr('data-numeClient');
        $(".modal-finalizeaza-chirie").find(".modal-title").text("Inchiriaza masina "+nrInmatric);
        $(".modal-finalizeaza-chirie").find(".hidden-id-masina-finalizare-chirie").val(idMasina);
        $(".modal-finalizeaza-chirie").find(".hidden-id-client-finalizare-chirie").val(idCLient);
        $(".modal-finalizeaza-chirie").find(".hidden-id-chirieFinaizeaza-finalizare-chirie").val(idChirieActiva);

        data = {
            idClient: idCLient,
            idMasina: idMasina,
            idChirieActiva: idChirieActiva
        }
        $.ajax({
            url: "/chirie/getpret",
            type: "get",
            data: data
        })
            .done(function (response) {
                var text = "Se finalizeaza chiria pentru masina " + nrInmatric;
                $(".modal-finalizeaza-chirie").find(".mesaj-finalizare-chirie").text(text);
                var text2 = "Clientul " + numeClient +" are de platit "+ response + " LEI!"
                $(".modal-finalizeaza-chirie").find(".mesaj-finalizare-chirie2").text(text2);
                $(".modal-finalizeaza-chirie").find(".hidden-id-pret-finalizare-chirie").val(response);
            })
            .fail(function () {
                alert("fail");
            });

    });
    $(".btn-finalizeaza-chiria-confirmare").on("click", function(){
        var idMasina = $(".modal-finalizeaza-chirie").find(".hidden-id-masina-finalizare-chirie").val();
        var idClient = $(".modal-finalizeaza-chirie").find(".hidden-id-client-finalizare-chirie").val();
        var idChirieActiva = $(".modal-finalizeaza-chirie").find(".hidden-id-chirieFinaizeaza-finalizare-chirie").val();
        var pret = $(".modal-finalizeaza-chirie").find(".hidden-id-pret-finalizare-chirie").val();
        data={
            idMasina:idMasina,
            idClient:idClient,
            idChirieActiva: idChirieActiva,
            pret: pret
        }
        $.ajax({
            url: "/chirii/finalizeaza",
            type: "post",
            data: data
        })
            .done(function (response) {
                alert("Chiria a fost finalizata cu succes!");
                window.location.href = "http://localhost:8080/chirie/finalizate";
            })
            .fail(function () {
                alert("fail");
            });
    })
});