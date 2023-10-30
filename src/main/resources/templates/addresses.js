$(document).ready(function() {
    $.ajax({
        type: "POST",
        url: "/addresses"
        data: {}
    }).then(function(data, status, jqxhr) {
       $(".addressBookId").append(data.id);
       console.log(jqxhr);
    });
});


$(document).ready(function() {
    $.ajax({
        url: "/addresses"
    }).then(function(data, status, jqxhr) {
        ${#book_submit}.submit(function() {
            ${#add_book}.load();
        }
    }
});


$(document).on("submit", "#createBook", function(event) {
    event.preventDefault();

    $.ajax({
        headers: {
            Accept: "application/json; charset=utf-8",
            "Content-Type": "application/json; charset=utf-8"
        },
        type: "POST",
        url: "/addresses",
        data: {},
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(response) {
            console.log(response);
            $(".AddressBook").append("AddressBook #: " + data.id);
        }
    });
});

$(document).on("submit",".buddy_submit", function(event) {
    var num = $(this).class;
    var data = {
        "name" : $("#name" + num).val(),
        "address" : $("#address" + num).val(),
        "phoneNumber" : $("#phoneNumber" + num).val()
    };
    event.preventDefault();

    $.ajax({
        headers: {
            Accept: "application/json; charset=utf-8",
            "Content-Type": "application/json; charset=utf-8"
        },
        type: "POST",
        url: "addresses/" + num +"/buddy",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(response) {
            console.log(response);
            $("#buddy" + num).append("<p>" + response.name + "</p><br/><p>" + response.address + "</p><br/><p>" + response.phoneNumber + "</p><br/>");
        }
    });
});