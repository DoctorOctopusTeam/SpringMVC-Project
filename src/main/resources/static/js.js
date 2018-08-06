$(".ae").on("click", function () {
    $.get("/allemployees", function (data) {
        data.forEach(function(entity){
            $("<div/>", {class: "cl",text: entity.firstName + " " + entity.lastName})
                .appendTo(document.body);
        });
    })
})

$(".at").on("click", function () {
    $.get("/alltowns", function (data) {
        data.forEach(function(entity){
            $("<div/>", {class: "cl",text: entity.name})
                .appendTo(document.body);
        });
    })
});

$(".as").on("click", function () {
    $.get("/averagesalary", function (avgSlr) {
            $("<div/>", {class: "cl",text: avgSlr.toString()})
                .appendTo(document.body);
    })
});

$(".asd").on("click", function () {
    var $department = $(".value").val();
    var $url = "/allemployeesfromdepartment?depName=" + $department;
    $.get($url, function (list) {
        list.forEach(function(entity){
            $("<div/>", {class: "cl",text: entity.firstName})
                .appendTo(document.body);
        });
    })
});

$(".mnt").on("click", function () {
    var $nameOfNewTown = $(".ntv").val();
    var $url = "/newtown?townName=" + $nameOfNewTown;
    $.post($url, function (data, status, jqXHR){
        $("<div/>", {class: "cl", text: "New town with name " +
            $nameOfNewTown + " created " +
            status.toString()}).appendTo(document.body);
    });
});


$(".dt").on("click", function () {
    var $idOfTowToBeDeleted = $(".dtv").val();
    var $url = "/delete?id=" + $idOfTowToBeDeleted;
    $.ajax({
        url: $url,
        type: "delete",
        success: function(result){
            $("<div/>", {class: "cl", text: "Town with id " + $idOfTowToBeDeleted +
            " and name " + result.toString() + " deleted!"}).appendTo(document.body);
        }
    });
})


$(".cb").on("click", function(){
    $(".cl").remove();
});