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

function showTopicSettings(j, i) {
    var currentTopicDivId = "seeTopic_" + j + "_" + i;
    var topicSettingsDivId = "editTopic_" + j + "_" + i;

    var currentTopicDiv = document.getElementById(currentTopicDivId);
    var topicSettingsDiv = document.getElementById(topicSettingsDivId);

    currentTopicDiv.style.display = "none";
    topicSettingsDiv.style.display = "block";
}

function saveTopic(j, i, classId) {
    var popoverId = "popover_" + j + "_" + i;
    var currentTopicDivId = "seeTopic_" + j + "_" + i;
    var topicSettingsDivId = "editTopic_" + j + "_" + i;
    var topicId = "topic_" + j + "_" + i;
    var topicValueId = "topicValue_" + j + "_" + i;

    var currentTopicDiv = document.getElementById(currentTopicDivId);
    var topicSettingsDiv = document.getElementById(topicSettingsDivId);
    var popover = document.getElementById(popoverId);

    var newTopicDiv = document.getElementById(topicId);
    var valueTopicDiv = document.getElementById(topicValueId);

    var previousTopic = valueTopicDiv.textContent;
    var newTopic = newTopicDiv.value;

    var params = {
        previousTopic: previousTopic,
        newTopic: newTopic,
        classesId: classId
    };

    $.ajax({
        type: "POST",
        url: "settopic",
        contentType: "application/json",
        data: JSON.stringify(params),
        success: function (response) {
            if (response != "error") {
                var previousContent = popover.getAttribute("data-content");
                var content = previousContent.replace(previousTopic, response);
                newTopicDiv.setAttribute("placeholder", response);
                popover.setAttribute("data-content", content);
                newTopicDiv.value = "";
                valueTopicDiv.innerHTML = response;
            }
            else
            {
                currentTopicDiv.appendChild(document.createTextNode("Podczas przetwarzania wyst±pi³ b³±d"));
            }
        }
    });

    currentTopicDiv.style.display = "block";
    topicSettingsDiv.style.display = "none";
}

