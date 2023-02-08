$('#fileChooser').change(function() {
    var filePath = $(this).val();
    $('#file_path').val(filePath);
    console.log(filePath);
});
