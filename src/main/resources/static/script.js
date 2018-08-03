$(document).ready(function () {
    var $make = $('#make'),
        $model = $('#model'),
        $options = $model.find('option');

    $make.on('change', function () {
        $model.html($options.filter('[value="' + this.value + '"]'));
        $model.trigger('change');
    }).trigger('change');
});

$("#button").on('click', function () {
    var car = {
        make: $('#make option:selected').text(),
        model: $('#model option:selected').text(),
        fuel: $('#fuel option:selected').text(),
        consumeFuel: $('#km').val()

    }
    console.log(JSON.stringify(car));
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        url: "http://localhost:8080/api/add",
        data: JSON.stringify(car)
    });
});

$("#button1").on('click', function () {

    $.get("http://localhost:8080/api/get/", function (c) {
        $("<div/>")
            .html(c)
            .appendTo(document.body);
    });
});









