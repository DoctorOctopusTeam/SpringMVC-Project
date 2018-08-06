$(document).ready(function () {
    var $make = $('#make'),
        $model = $('#model'),
        $options = $model.find('option');

    $make.on('change', function () {
        $model.html($options.filter('[value="' + this.value + '"]'));
        $model.trigger('change');
    }).trigger('change');
});

$(document).ready(function () {
    var $make = $('#make1'),
        $model = $('#model1'),
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
    var car = {
        make: $('#make1 option:selected').text(),
        model: $('#model1 option:selected').text(),
        fuel: $('#fuel1 option:selected').text(),
        consumeFuel: null

    }
    console.log(JSON.stringify(car));
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        url: "http://localhost:8080/api/get",
        data: JSON.stringify(car),
        success: function(result) {
            // Run the code here that needs
            //    to access the data returned
            console.log(result);
            $("#fuelResult").text(result);

        },
        error: function() {
            alert('Nothing found with these parameters');
        }
    });


});










