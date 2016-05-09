function showHideEndDate() {
    var endDateLabel = document.getElementById("endDateLabel");
    var endDateInput = document.getElementById("endDate");

    if (document.getElementById("repeat").value > 0) {
        endDateLabel.style.display = "block";
        endDateInput.style.display = "block";
        endDateInput.required = true;
    }
    else {
        endDateLabel.style.display = "none";
        endDateInput.style.display = "none";
        endDateInput.required = false;
    }
}

function setDatePicker() {
    var minDate = new Date();
    $('#datepicker').datepicker({
        language: "pl",
        format: "dd.mm.yyyy",
        startDate: ("0" + minDate.getDate()).slice(-2) + "." + ("0" + (minDate.getMonth() + 1)).slice(-2) + "." + minDate.getFullYear(),
        daysOfWeekDisabled: "0,6",
        autoclose: true,
        orientation: "bottom auto",
        todayHighlight: true,
        toggleActive: true
    });
}