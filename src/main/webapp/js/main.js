function getRoleList() {
    $.ajax({
        url: 'cs?action=roleList',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        },
        error: function (response) {
            alert('ERROR');
        }
    });
}

function getEmployeeList() {
    $.ajax({
        url: 'cs?action=employeeList',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        },
        error: function (response) {
            alert('ERROR');
        }
    });
}

$(function () {
    $('body').layout({applyDemoStyles: true});
    $('.ui-layout-center,.ui-layout-east,.ui-layout-west,.ui-layout-north,.ui-layout-south').css('background-color', 'bisquite');


    $('#nazAp').click(function () {
        getEmployeeList();
    });

    $('#roleDataBtnId').click(function () {
        getRoleList();
    });


});
