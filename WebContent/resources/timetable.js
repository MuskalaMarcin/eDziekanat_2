function showHideEndDate(iIndex, jIndex) {
    var endDateLabelId = "endDateLabel";
    var endDateId = "endDate";
    var repeatId = "repeat";

    if (iIndex != null && jIndex != null) {
        endDateLabelId += "_" + iIndex + "_" + jIndex;
        endDateId += "_" + iIndex + "_" + jIndex;
        repeatId += "_" + iIndex + "_" + jIndex;
    }

    var endDateLabel = document.getElementById(endDateLabelId);
    var endDateInput = document.getElementById(endDateId);

    if (document.getElementById(repeatId).value > 0) {
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

function setMultipleDatePickers() {
    var minDate = new Date();
    $('.datepickers').datepicker({
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

function showTopicSettings() {

}

function saveTopic() {
    
}

