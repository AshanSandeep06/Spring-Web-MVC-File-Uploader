let baseUrl = "http://localhost:8080/backend/";

$('#fileChooser').change(function () {
    var filePath = $(this).val();
    $('#file_path').val(filePath);
    console.log(filePath);
});

$('#btnFileUpload').on('click', function (){
    var formData = new FormData($('#fileUploadingForm')[0]);

    $.ajax({
        url: baseUrl + "file_upload",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,

        success: function (res){
            console.log(res);
        }
    });
});
